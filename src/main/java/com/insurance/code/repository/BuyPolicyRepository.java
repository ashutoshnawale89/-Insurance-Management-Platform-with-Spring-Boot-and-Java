package com.insurance.code.repository;

import com.insurance.code.model.BuyPolicyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyPolicyRepository extends JpaRepository<BuyPolicyModel,Integer> {
}
