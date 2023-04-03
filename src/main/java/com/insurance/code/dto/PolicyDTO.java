package com.insurance.code.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PolicyDTO {
    @NotNull(message = "Type Should Not be null")
    private String type;
    @NotNull(message = "Cover Amount Should Not be null")
    private Integer coverageAmount;
    @NotNull(message = "Primium Should Not be null")
    private Integer primium;
    @NotNull(message = "Duration Should Not be null")
    private Integer duration;

}
