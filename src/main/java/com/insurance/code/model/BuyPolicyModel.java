package com.insurance.code.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Component
@Data
@Table(name = "buypolicy")
@NoArgsConstructor
public class BuyPolicyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "buypolicy_id", nullable = false)
    private Integer buyPolicyId;

    @OneToOne
    @JoinColumn(name = "clientId")
    private ClientModel clientModel;

    @ManyToOne
    @JoinColumn(name = "policyId")
    private PolicyModel policyModel;

    @CreationTimestamp
    private LocalDate buyingDate;

    private int clientPolicyDuration;
    private int totalPrimium;

    private LocalDate expireDate;


    public BuyPolicyModel(Integer buyPolicyId,PolicyModel policyModel,ClientModel clientModel,int duration) {
        this.buyPolicyId = buyPolicyId;
        this.clientModel = clientModel;
        this.policyModel = policyModel;
        this.clientPolicyDuration =duration;
        this.totalPrimium=duration * policyModel.getPrimium();
    }
    public BuyPolicyModel(PolicyModel policyModel, ClientModel clientModel, int duration, LocalDate expireDate) {
        this.buyPolicyId = buyPolicyId;
        this.clientModel = clientModel;
        this.policyModel = policyModel;
        this.clientPolicyDuration =duration;
        this.totalPrimium=duration * policyModel.getPrimium();
        this.expireDate=expireDate;
    }
}
