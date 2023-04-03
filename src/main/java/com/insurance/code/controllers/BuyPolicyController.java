package com.insurance.code.controllers;

import com.insurance.code.dto.BuyPolicyDTO;
import com.insurance.code.dto.PolicyDTO;
import com.insurance.code.dto.ResponseDTO;
import com.insurance.code.model.BuyPolicyModel;
import com.insurance.code.model.PolicyModel;
import com.insurance.code.repository.BuyPolicyRepository;
import com.insurance.code.services.BuyPolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api")
public class BuyPolicyController {
    @Autowired
    private BuyPolicyService buyPolicyService;

    @GetMapping("/buypolicies/{id}")
    public ResponseEntity<ResponseDTO> getBuyPolicyById(Integer id){
        Optional<BuyPolicyModel> policyModel= buyPolicyService.getBuyPolicyById(id);
        ResponseDTO responseDTO=new ResponseDTO("Get Data Successfully",policyModel);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value="/buypolicies")
    public ResponseEntity<ResponseDTO> getAllBuyPolicy(){
        buyPolicyService.getAllBuyPolicy();
        ResponseDTO responseDTO=new ResponseDTO("Get all Data Successfully",buyPolicyService.getAllBuyPolicy());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/buypolicies")
    public <clientDTO> ResponseEntity<ResponseDTO> addClient(@Valid @RequestBody BuyPolicyDTO buyPolicyDTO){
        ResponseDTO responseDTO=new ResponseDTO("Get all Data Successfully",buyPolicyService.createBuyPolicy(buyPolicyDTO));
        ResponseEntity<ResponseDTO> ResponseEntity;
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/buypolicies/{policyId}")
    public ResponseEntity<ResponseDTO> updateRecordById(@PathVariable int policyId, @Valid @RequestBody BuyPolicyDTO buyPolicyDTO) {
        BuyPolicyModel updateRecord = buyPolicyService.updateBuyPolicyById(policyId,buyPolicyDTO);
        ResponseDTO responseDto = new ResponseDTO(" Policy Record updated successfully by Id", updateRecord);
        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/buypolicies/{policyId}")
    public ResponseEntity<ResponseDTO> deleteRecordById(@PathVariable int policyId) {
        Optional<BuyPolicyModel> policyModel = buyPolicyService.deleteBuyPolicyById(policyId);
        ResponseDTO responseDto = new ResponseDTO("Record deleted successfully !", policyModel);
        return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
    }
}
