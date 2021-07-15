package com.shegoestech.hello_spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(groups = UpdateValidation.class)
    private Long id;
    @NotBlank(message = "Firstname is required", groups = {CreateValidation.class, UpdateValidation.class})
    private String firstName;
    @NotBlank(message = "Lastname is required", groups = {CreateValidation.class, UpdateValidation.class})
    private String lastName;
    @Size(min = 10, message = "Phone is not valid", groups = {CreateValidation.class, UpdateValidation.class})
    private String phone;
    @NotBlank(message = "Email is required", groups = {CreateValidation.class, UpdateValidation.class})
    @Email(message = "Email is invalid", groups = {CreateValidation.class, UpdateValidation.class})
    private String email;

    //@ManyToOne
    //@OneToMany
    //@OneToOne
}
