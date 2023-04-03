package com.insurance.code.services;

import com.insurance.code.dto.ClaimsDTO;
import com.insurance.code.exception.InsuranceException;
import com.insurance.code.model.BuyPolicyModel;
import com.insurance.code.model.ClaimsModel;
import com.insurance.code.repository.ClaimsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService implements IClaimsService {
    @Autowired
    private ClaimsRepository claimsRepository;
    @Autowired
    private BuyPolicyService buyPolicyService;
    @Override
    public List<ClaimsModel> getAllClaims() {
        List<ClaimsModel> claimsModelList=claimsRepository.findAll();
        return claimsModelList;
    }

    @Override
    public Optional<ClaimsModel> getClaimsById(Integer id) {
        return claimsRepository.findById(id);
    }

    @Override
    public ClaimsModel createClaims(ClaimsDTO claimsDTO) {
        Optional<BuyPolicyModel> buyPolicyModel=buyPolicyService.getBuyPolicyById(claimsDTO.getBuyPolicyId());
        if(buyPolicyModel==null){
            throw new InsuranceException("The BuyPolicy Id Not present in Databases;");
        }
        else {
            List<ClaimsModel> claimsCheck=getAllClaims();
            for(int i=0; i < claimsCheck.size();i++){
                if(claimsCheck.get(i).getBuyPolicy().getBuyPolicyId()==claimsDTO.getBuyPolicyId()){
                    throw new InsuranceException("Already Claim the Policy ");
                }
            }
            ClaimsModel claimsModel=new ClaimsModel(true,claimsDTO.getDescription(),buyPolicyModel.get().getClientModel().getClientId(),
                                                        buyPolicyModel.get());
            claimsRepository.save(claimsModel);
            return claimsModel;
        }
    }

    @Override
    public ClaimsModel updateClaimsById(Integer id, ClaimsDTO claimsDTO) {
        Optional<ClaimsModel> claimsModel=claimsRepository.findById(id);
        if(claimsModel==null){
            throw new InsuranceException("The Claim Id Not present in Databases;");
        }
        else {
            Optional<BuyPolicyModel> buyPolicyModel=buyPolicyService.getBuyPolicyById(claimsDTO.getBuyPolicyId());
            claimsModel.get().setClaimStatus(claimsDTO.isClaimStatus());
            claimsModel.get().setDescription(claimsDTO.getDescription());
            claimsModel.get().setBuyPolicy(buyPolicyModel.get());
            claimsRepository.save(claimsModel.get());
            return claimsModel.get();
        }
    }

    @Override
    public Optional<ClaimsModel> deleteClaimsById(Integer id) {
        Optional<ClaimsModel> claimsModel=claimsRepository.findByClaimsId(id);
        claimsRepository.delete(claimsModel.get());
        return claimsModel;
    }
}
