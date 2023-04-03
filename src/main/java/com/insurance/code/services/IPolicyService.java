package com.insurance.code.services;



import com.insurance.code.dto.PolicyDTO;
import com.insurance.code.model.PolicyModel;

import java.util.List;
import java.util.Optional;

public interface IPolicyService {
    List<PolicyModel> getAllPolicy();

    PolicyModel getPolicyById(Integer id);
    PolicyModel createPolicy(PolicyDTO policyDTO);
    PolicyModel updatePolicyById(Integer id,PolicyDTO policyDTO);
    Optional<PolicyModel> deletePolicyById(Integer id);
}


