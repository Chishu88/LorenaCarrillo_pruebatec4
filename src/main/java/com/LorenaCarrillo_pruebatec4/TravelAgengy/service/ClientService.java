package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.converter.ClientConverter;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.CreateClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.UpdateCLientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion.ClientNotFoundException;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Client;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService{

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO createClient(CreateClientDTO createClientDTO) {
        Client clientToCreate = ClientConverter.createToEntity(createClientDTO);
        Client createdClient = clientRepository.save(clientToCreate);
        return ClientConverter.toDto(createdClient);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return ClientConverter.toListDto(clients);
    }

    @Override
    public ClientDTO findClientById(Long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        return optionalClient.map(ClientConverter::toDto).orElse(null);
    }

    @Override
    public ClientDTO updateClient(Long clientId, UpdateCLientDTO updateCLientDTO) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client clientToUpdate = optionalClient.get();
            Client updatedClient = ClientConverter.updateToEntity(clientToUpdate, updateCLientDTO);
            return ClientConverter.toDto(clientRepository.save(updatedClient));
        } else {
            throw new RuntimeException("Client not found with ID: " + clientId);
        }
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + clientId));
    }
}
