package com.insurance.code.repository;

import com.insurance.code.model.PolicyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyModel,Integer> {
}
