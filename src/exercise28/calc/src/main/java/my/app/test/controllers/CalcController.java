package my.app.test.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import my.app.test.models.*;

@Controller
public class CalcController {

	private static final Logger logger = LoggerFactory.getLogger(CalcController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(@ModelAttribute("MathematicalExpression") MathematicalExpression mathematicalExpression, Model model) {
		return "calc";
	}

	@RequestMapping(value = "/calc", method = RequestMethod.POST)
	public String getResult(@ModelAttribute("MathematicalExpression") MathematicalExpression mathematicalExpression,
			Model model) {
		mathematicalExpression.setResult();
		model.addAttribute("MathematicalExpression", mathematicalExpression);
		return "calc";

	}
}
