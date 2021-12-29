package com.project.ecomapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequestDto {

    private String addressLine;
    private String longitude;
    private String latitude;

}