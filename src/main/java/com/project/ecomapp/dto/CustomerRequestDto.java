package com.project.ecomapp.dto;

import com.project.ecomapp.constant.Gender;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequestDto {

    @NotBlank(message = "first name cannot be blank")
    private String firstName;

    @NotBlank(message = "last name cannot be blank")
    private String lastName;

    private Gender gender;

    @NotBlank(message = "contact cannot be blank")
    private String contact;

    private List<AddressRequestDto> addresses;

}