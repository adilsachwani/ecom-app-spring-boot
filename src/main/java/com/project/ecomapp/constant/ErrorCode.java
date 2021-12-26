package com.project.ecomapp.constant;

import lombok.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND(404, "Not found", "%s not found");

    private Integer code;
    private String message;
    private String detailedMessage;

}