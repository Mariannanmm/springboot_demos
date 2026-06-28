package org.okten.springboot_demos.hw_springBootDemo_task2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarLevel2DTO {
    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Producer is required")
    private String producer;

    @NotNull(message = "Power is required")
    @Min(value = 10, message = "Power must be at least 10 HP")
    private Integer power;
}
