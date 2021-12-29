package com.project.ecomapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponseDto {

    private Long id;
    private String addressLine;
    private String longitude;
    private String latitude;

}