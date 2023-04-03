package com.insurance.code.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDTO {
    @NotNull(message = "Name Should Not be null")
    private String name;
    @NotNull(message = "Date of Birth Should Not be null")
    private  String dateofBirth;
    @NotNull(message = "Address Should Not be null")
    private String address;
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Number should be 10 digit")
    @NotNull(message = "Phone Number Should Not be null")
    private String phoneNumber;


}
