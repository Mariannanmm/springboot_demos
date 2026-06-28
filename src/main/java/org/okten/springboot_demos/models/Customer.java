package org.okten.springboot_demos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "name is required")
    @Size(min =2, message = "name must be at least 2 characters")
    @Size(max = 255, message = "name must 255 characters max")
    private String name;
    private String password;
    private int age;

    public Customer() {}
}
