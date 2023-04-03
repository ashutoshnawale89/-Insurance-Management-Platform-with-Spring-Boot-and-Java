package com.insurance.code.services;



import com.insurance.code.dto.BuyPolicyDTO;
import com.insurance.code.model.BuyPolicyModel;

import java.util.List;
import java.util.Optional;

public interface IBuyPolicyService {
    List<BuyPolicyModel> getAllBuyPolicy();

    Optional<BuyPolicyModel> getBuyPolicyById(Integer id);
    BuyPolicyModel createBuyPolicy(BuyPolicyDTO buyPolicyDTO);
    BuyPolicyModel updateBuyPolicyById(Integer id,BuyPolicyDTO buyPolicyDTO);
    Optional<BuyPolicyModel> deleteBuyPolicyById(Integer id);
}
