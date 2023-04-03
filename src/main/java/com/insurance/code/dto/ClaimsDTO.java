package com.insurance.code.dto;

import com.insurance.code.model.BuyPolicyModel;
import com.insurance.code.model.PolicyModel;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
@Data
public class ClaimsDTO {
    private boolean claimStatus;
    private String description;

    @NotNull(message = "BuyPolicyId Not null")
    private Integer buyPolicyId;
}
