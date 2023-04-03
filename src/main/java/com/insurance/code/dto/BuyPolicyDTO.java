package com.insurance.code.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyPolicyDTO {
    @NotNull(message = "Client_ID should not be null")
    private int clientId;

    @NotNull(message = "Policy_ID should not be null")
    private int policyId;
    private int clientPolicyDuration;

}
