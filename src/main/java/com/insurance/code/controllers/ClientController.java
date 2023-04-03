package com.insurance.code.controllers;

import com.insurance.code.dto.ClientDTO;
import com.insurance.code.dto.ResponseDTO;
import com.insurance.code.model.ClientModel;
import com.insurance.code.model.PolicyModel;
import com.insurance.code.repository.ClientRepository;
import com.insurance.code.services.IClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private IClientService clientService;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value="/clients")
    public ResponseEntity<ResponseDTO> getAllClient(){
        ResponseDTO responseDTO=new ResponseDTO("Get all Data Successfully",clientService.getAllClient());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/clients/{id}")
    public ResponseEntity<ResponseDTO> getClientById(@PathVariable Integer id){
        Optional<ClientModel> clientModel= Optional.ofNullable(clientService.getClientById(id));
        ResponseDTO responseDTO=new ResponseDTO("Get Data Successfully",clientModel);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    @PostMapping("/clients")
    public <clientDTO> ResponseEntity<ResponseDTO> addClient(@Valid @RequestBody ClientDTO clientDTO){
        ResponseDTO responseDTO=new ResponseDTO("Get all Data Successfully",clientService.createClient(clientDTO));
        ResponseEntity<ResponseDTO> ResponseEntity;
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/clients/{clientId}")
    public ResponseEntity<ResponseDTO> updateRecordById(@PathVariable int clientId, @Valid @RequestBody ClientDTO clientDTO) {
        ClientModel updateRecord = clientService.updateClientById(clientId,clientDTO);
        ResponseDTO responseDto = new ResponseDTO(" Client Record updated successfully by Id", updateRecord);
        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/clients/{clientId}")
    public ResponseEntity<ResponseDTO> deleteRecordById(@PathVariable int clientId) {
        Optional<ClientModel> clientModel = clientService.deleteClientById(clientId);
        ResponseDTO responseDto = new ResponseDTO("Record deleted successfully !", clientModel);
        return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
    }

}
