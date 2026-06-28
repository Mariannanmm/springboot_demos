package org.okten.springboot_demos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerSizeExceptionDTO {
    private int code;
    private String message;
    private String msg;

}
