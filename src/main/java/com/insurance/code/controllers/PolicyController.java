package com.insurance.code.controllers;

import com.insurance.code.dto.PolicyDTO;
import com.insurance.code.dto.ResponseDTO;
import com.insurance.code.model.PolicyModel;
import com.insurance.code.repository.PolicyRepository;
import com.insurance.code.services.PolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/api")
public class PolicyController {
    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private PolicyService policyService;

    @GetMapping("/policies/{id}")
    public ResponseEntity<ResponseDTO> getPolicyById(Integer id){
        Optional<PolicyModel> policyModel= Optional.ofNullable(policyService.getPolicyById(id));
        ResponseDTO responseDTO=new ResponseDTO("Get Data Successfully",policyModel);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value="/policies")
    public ResponseEntity<ResponseDTO> getAllPolicy(){
        policyService.getAllPolicy();
        ResponseDTO responseDTO=new ResponseDTO("Get all Data Successfully",policyService.getAllPolicy());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/policies")
    public <clientDTO> ResponseEntity<ResponseDTO> addClient(@Valid @RequestBody PolicyDTO policyDTO){
        ResponseDTO responseDTO=new ResponseDTO("Get all Data Successfully",policyService.createPolicy(policyDTO));
        ResponseEntity<ResponseDTO> ResponseEntity;
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/policies/{policyId}")
    public ResponseEntity<ResponseDTO> updateRecordById(@PathVariable int policyId, @Valid @RequestBody PolicyDTO policyDTO) {
        PolicyModel updateRecord = policyService.updatePolicyById(policyId,policyDTO);
        ResponseDTO responseDto = new ResponseDTO(" Policy Record updated successfully by Id", updateRecord);
        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/policies/{policyId}")
    public ResponseEntity<ResponseDTO> deleteRecordById(@PathVariable int policyId) {
        Optional<PolicyModel> policyModel = policyService.deletePolicyById(policyId);
        ResponseDTO responseDto = new ResponseDTO("Record deleted successfully !", policyModel);
        return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
    }

}
