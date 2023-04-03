package com.insurance.code.services;

import com.insurance.code.dto.PolicyDTO;
import com.insurance.code.model.PolicyModel;
import com.insurance.code.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PolicyService implements IPolicyService{
    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public List<PolicyModel> getAllPolicy() {
        return policyRepository.findAll();
    }

    @Override
    public PolicyModel getPolicyById(Integer id) {
        PolicyModel policyModel=policyRepository.findById(id).orElseThrow();
        return policyModel;
    }

    @Override
    public PolicyModel createPolicy(PolicyDTO policyDTO) {
        PolicyModel policyModel=new PolicyModel(policyDTO);
        policyRepository.save(policyModel);
        return policyModel;
    }

    @Override
    public PolicyModel updatePolicyById(Integer id, PolicyDTO policyDTO) {
        Optional<PolicyModel> policytData=policyRepository.findById(id);
        if(policytData==null){
            throw new RuntimeException("It Not Available in Database .Please insure the Policy ID");
        }else {
            policytData.get().setPolicyId(id);
            policytData.get().setType(policyDTO.getType());
            policytData.get().setPrimium(policyDTO.getPrimium());
            policytData.get().setPolicyDuration(policyDTO.getDuration());
            policytData.get().setCoverageAmount(policyDTO.getCoverageAmount());
            policyRepository.save(policytData.get());
            return policytData.get();
        }
    }

    @Override
    public Optional<PolicyModel> deletePolicyById(Integer id) {
        Optional<PolicyModel> policytData=policyRepository.findById(id);
        if(policytData==null){
            throw new RuntimeException("It Not Available in Database .Please insure the Policy ID");
        }else {
            policyRepository.deleteById(policytData.orElseThrow().getPolicyId());
            return policytData;
        }

    }
}
