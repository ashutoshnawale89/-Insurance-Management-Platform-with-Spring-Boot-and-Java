package com.insurance.code.services;

import com.insurance.code.dto.ClientDTO;
import com.insurance.code.model.ClientModel;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    List<ClientModel> getAllClient();

    ClientModel getClientById(Integer id);
    ClientModel createClient(ClientDTO clientDTO);
    ClientModel updateClientById(Integer id,ClientDTO clientDTO);
    Optional<ClientModel> deleteClientById(Integer id);
}
