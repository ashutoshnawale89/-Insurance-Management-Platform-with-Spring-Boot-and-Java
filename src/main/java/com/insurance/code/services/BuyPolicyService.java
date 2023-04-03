package com.insurance.code.services;

import com.insurance.code.dto.BuyPolicyDTO;
import com.insurance.code.exception.InsuranceException;
import com.insurance.code.model.BuyPolicyModel;
import com.insurance.code.model.ClientModel;
import com.insurance.code.model.PolicyModel;
import com.insurance.code.repository.BuyPolicyRepository;
import com.insurance.code.repository.ClientRepository;
import com.insurance.code.repository.PolicyRepository;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class BuyPolicyService implements IBuyPolicyService{
    @Autowired
    private BuyPolicyRepository buyPolicyRepository;
    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PolicyService policyService;
    @Autowired
    private ClientService clientService;

    @Override
    public List<BuyPolicyModel> getAllBuyPolicy() {
        return buyPolicyRepository.findAll();
    }

    @Override
    public Optional<BuyPolicyModel> getBuyPolicyById(Integer id) {
        Optional<BuyPolicyModel> cartdata = buyPolicyRepository.findById(id);
        if(cartdata.isEmpty())
            throw new InsuranceException("BuyPolicy details with UserId " + id + " does not exit..!");
        else
           return buyPolicyRepository.findById(id);
    }

    @Override
    public BuyPolicyModel createBuyPolicy(BuyPolicyDTO buyPolicyDTO) {
        List<BuyPolicyModel> buyPolicyCheck=getAllBuyPolicy();
        for(int i=0; i < buyPolicyCheck.size(); i++){
            if(buyPolicyCheck.get(i).getPolicyModel().getPolicyId() == buyPolicyDTO.getPolicyId() &&
                    buyPolicyCheck.get(i).getClientModel().getClientId()==buyPolicyDTO.getClientId()){
                throw new InsuranceException("User Already Buy this Policy .It can Not buy 2 times");
            }
        }
        ClientModel clientModel=clientService.getClientById(buyPolicyDTO.getClientId());
        PolicyModel policyModel=policyService.getPolicyById(buyPolicyDTO.getPolicyId());
        if(clientModel==null && policyModel==null){
            throw new InsuranceException("Please give the correct data like clientId & policyId");
        }
        else{
            LocalDate sameDayNextYear = LocalDate.from(LocalDateTime.now().plusYears(buyPolicyDTO.getClientPolicyDuration()));
            LocalDate minusDayNextYear =sameDayNextYear.minusDays(1);
            BuyPolicyModel buyPolicyModel=new BuyPolicyModel(policyModel,clientModel,buyPolicyDTO.getClientPolicyDuration(),minusDayNextYear);
            buyPolicyRepository.save(buyPolicyModel);
            return buyPolicyModel;
        }
    }

    @Override
    public BuyPolicyModel updateBuyPolicyById(Integer id, BuyPolicyDTO buyPolicyDTO) {
        Optional<BuyPolicyModel> buyPolicyData=buyPolicyRepository.findById(id);
        if(buyPolicyData==null){
            throw new InsuranceException("Please give the correct BuyPolicyId");
        }else{
            return null;
        }
    }

    @Override
    public Optional<BuyPolicyModel> deleteBuyPolicyById(Integer id) {
        Optional<BuyPolicyModel> buyPolicyModel=buyPolicyRepository.findById(id);
        if(buyPolicyModel==null){
            throw new InsuranceException("Please give the correct BuyPolicyId");
        }else {
            buyPolicyRepository.deleteById(id);
            return buyPolicyModel;
        }
    }
}
