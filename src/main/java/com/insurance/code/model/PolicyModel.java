package com.insurance.code.model;

import com.insurance.code.dto.PolicyDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
@NoArgsConstructor
@Table(name = "policy_details")
public class PolicyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "policy_id", nullable = false)
    private Integer policyId;

    private String type;
    private Integer coverageAmount;
    private Integer primium;
    private Integer policyDuration;

    public PolicyModel(Integer policy_id, PolicyDTO policyDTO) {
        this.policyId = policy_id;
        this.type = policyDTO.getType();
        this.coverageAmount = policyDTO.getCoverageAmount();
        this.primium = policyDTO.getPrimium();
        this.policyDuration = policyDTO.getDuration();

    }

    public PolicyModel(PolicyDTO policyDTO) {
        this.policyId = policyId;
        this.type = policyDTO.getType();
        this.coverageAmount = policyDTO.getCoverageAmount();
        this.primium = policyDTO.getPrimium();
        this.policyDuration = policyDTO.getDuration();
    }
}
