package com.insurance.code.services;

import com.insurance.code.dto.ClientDTO;
import com.insurance.code.exception.InsuranceException;
import com.insurance.code.model.ClientModel;
import com.insurance.code.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService{
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<ClientModel> getAllClient() {
        List<ClientModel> allClientData=clientRepository.findAll();
        return allClientData;
    }

    @Override
    public ClientModel getClientById(Integer id) {
        ClientModel clientData=clientRepository.findById(id).orElseThrow();
        return clientData;
    }

    @Override
    public ClientModel createClient(ClientDTO clientDTO) {
        ClientModel addClient=new ClientModel(clientDTO);
        clientRepository.save(addClient);
        return addClient ;
    }

    @Override
    public ClientModel updateClientById(Integer id, ClientDTO clientDTO) {
        Optional<ClientModel> clientData=clientRepository.findById(id);
        if(clientData==null){
            throw new RuntimeException("It Not Available in Database .Please insure the Client ID");
        }else {
            clientData.get().setClientId(id);
            clientData.get().setAddress(clientDTO.getAddress());
            clientData.get().setName(clientDTO.getName());
            clientData.get().setDateofBirth(clientDTO.getDateofBirth());
            clientData.get().setPhoneNumber(clientDTO.getPhoneNumber());
            clientRepository.save( clientData.get());
            return  clientData.get();
        }
    }

    public Optional<ClientModel> deleteClientById(Integer id) {
        Optional<ClientModel> clientData=clientRepository.findById(id);
        if(clientData==null){
            throw new RuntimeException("It Not Available in Database .Please insure the Client ID");
        }else {
            clientRepository.deleteById(id);
            return clientData;
        }
    }
}
