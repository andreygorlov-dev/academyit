package com.gorlov.online_shop_spring.configs;

import com.gorlov.online_shop_spring.filters.APIKeyAuthFilter;
import com.gorlov.online_shop_spring.filters.JwtCsrfFilter;
import com.gorlov.online_shop_spring.repositories.JwtTokenRepository;
import com.gorlov.online_shop_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

    @Configuration
    public static class ApiConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService service;
        @Autowired
        private JwtTokenRepository jwtTokenRepository;

        @Autowired
        @Qualifier("handlerExceptionResolver")
        private HandlerExceptionResolver resolver;

        @Bean
        public PasswordEncoder devPasswordEncoder() {
            return NoOpPasswordEncoder.getInstance();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(this.service);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                    .and()
                    .addFilterAt(new JwtCsrfFilter(jwtTokenRepository, resolver), CsrfFilter.class)
                    .csrf().ignoringAntMatchers("/**")
                    .and()
                    .authorizeRequests()
                    .antMatchers("/auth/login")
                    .authenticated()
                    .and()
                    .httpBasic()
                    .authenticationEntryPoint(((request, response, e) -> resolver.resolveException(request, response, null, e)));
        }
    }

    @Order(1)
    @Configuration
    public static class ApiKeyConfiguration extends WebSecurityConfigurerAdapter {

        @Value("${online_shop_spring.http.api-key-header-name}")
        private String principalRequestHeader;

        @Value("${online_shop_spring.http.api-key}")
        private String principalRequestValue;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
            filter.setAuthenticationManager(authentication -> {
                String principal = (String) authentication.getPrincipal();
                if (!principalRequestValue.equals(principal)) {
                    throw new BadCredentialsException("The API key was not found or not the expected value.");
                }
                authentication.setAuthenticated(true);
                return authentication;
            });
            http.
                    antMatcher("/shipment").
                    csrf().disable().
                    sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                    and().addFilter(filter).authorizeRequests().anyRequest().authenticated();
        }

    }

}



