package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.CreateClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.UpdateCLientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Client;

import java.util.List;

public interface IClientService {

    ClientDTO createClient(CreateClientDTO createClientDTO);
    List<ClientDTO> getAllClients();
    ClientDTO findClientById(Long clientId);
    ClientDTO updateClient(Long clientId, UpdateCLientDTO updateCLientDTO);
    void deleteClient(Long id);
}
