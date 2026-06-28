package org.okten.springboot_demos.hw_springBootDemo_task2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarLevel1DTO {

    private Long id;
    private String model;
    private String producer;
    private Integer power;
}
