package com.insurance.code.controllers;

import com.insurance.code.dto.ClaimsDTO;
import com.insurance.code.dto.ClientDTO;
import com.insurance.code.dto.ResponseDTO;
import com.insurance.code.model.ClaimsModel;
import com.insurance.code.model.ClientModel;
import com.insurance.code.services.IClaimsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ClaimsController {
    @Autowired
    private IClaimsService claimsService;
    @GetMapping(value="/claims")
    public ResponseEntity<ResponseDTO> getAllClaims(){
        System.out.println(claimsService.getAllClaims());
        ResponseDTO responseDTO=new ResponseDTO("Get all Data Successfully",claimsService.getAllClaims());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/claims/{id}")
    public ResponseEntity<ResponseDTO> getClaimsById(@PathVariable Integer id){
        Optional<ClaimsModel> clientModel=claimsService.getClaimsById(id);
        ResponseDTO responseDTO=new ResponseDTO("Get Data Successfully",clientModel);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    @PostMapping("/claims")
    public <clientDTO> ResponseEntity<ResponseDTO> addClaims(@Valid @RequestBody ClaimsDTO claimsDTO){
        ResponseDTO responseDTO=new ResponseDTO("Get all Data Successfully",claimsService.createClaims(claimsDTO));
        ResponseEntity<ResponseDTO> ResponseEntity;
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/claims/{clientId}")
    public ResponseEntity<ResponseDTO> updateRecordById(@PathVariable int clientId, @Valid @RequestBody ClaimsDTO claimsDTO) {
        ClaimsModel updateRecord = claimsService.updateClaimsById(clientId,claimsDTO);
        ResponseDTO responseDto = new ResponseDTO(" Client Record updated successfully by Id", updateRecord);
        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/claims/{clientId}")
    public ResponseEntity<ResponseDTO> deleteRecordById(@PathVariable int clientId) {
        Optional<ClaimsModel> claimsModel = claimsService.deleteClaimsById(clientId);
        ResponseDTO responseDto = new ResponseDTO("Record deleted successfully !", claimsModel);
        return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
    }

}
