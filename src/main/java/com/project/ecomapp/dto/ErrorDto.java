package com.project.ecomapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

    private Integer code;
    private String message;
    private String detailedMessage;

}