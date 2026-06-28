package org.okten.springboot_demos.hw_springBootDemo_task2;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Model cannot be blank")
    private String model;

    @NotBlank(message = "Producer cannot be blank")
    private String producer;

    @NotNull(message = "Power cannot be null")
    @Min(value = 10, message = "Power must be at least 10")
    private Integer power;
}
