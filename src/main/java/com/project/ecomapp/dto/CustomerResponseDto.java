package com.project.ecomapp.dto;

import com.project.ecomapp.constant.Gender;
import com.project.ecomapp.constant.RecordStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto {

    private Long id;
    private String customerCode;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String contact;
    private RecordStatus status;
    private List<AddressResponseDto> addresses;

}