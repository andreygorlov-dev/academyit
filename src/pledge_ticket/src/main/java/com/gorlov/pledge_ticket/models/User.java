package com.gorlov.pledge_ticket.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return id == ((User) o).id;
    }

}
