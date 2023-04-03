package com.insurance.code.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "claims_details")
public class ClaimsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claims_id", nullable = false)
    private Integer claimsId;

    private boolean claimStatus;
    private String description;
    @CreationTimestamp
    private LocalDate claimDate;

    private int userId;
    @OneToOne(fetch = FetchType.LAZY,orphanRemoval=true)
    @JoinColumn(name = "buyPolicyId")
    private BuyPolicyModel buyPolicy;

    public ClaimsModel(Integer claimsId, boolean claimStatus, String description, int userId, BuyPolicyModel buyPolicy) {
        this.claimsId = claimsId;
        this.claimStatus = claimStatus;
        this.description = description;
        this.userId = userId;
        this.buyPolicy = buyPolicy;
    }
    public ClaimsModel(boolean claimStatus, String description, int userId, BuyPolicyModel buyPolicy) {
        this.claimsId = claimsId;
        this.claimStatus = claimStatus;
        this.description = description;
        this.userId = userId;
        this.buyPolicy = buyPolicy;
        this.claimDate=getClaimDate();
    }
}
