package com.LorenaCarrillo_pruebatec4.TravelAgengy.controller;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.CreateClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.UpdateCLientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class responsible for handling client-related operations
@RestController
public class ClientController {

    private final ClientService clientService; // Service layer for client operations

    // Constructor to inject ClientService dependency
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Endpoint to create a new client
    @PostMapping("/newClient")
    public ResponseEntity<ClientDTO> createClient(@RequestBody CreateClientDTO createClientDTO) {
        // Create a new client using the provided DTO
        ClientDTO createdClient = clientService.createClient(createClientDTO);
        // Return the created client DTO in the HTTP response with CREATED status
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all clients
    @GetMapping("/allClients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        // Retrieve all clients from the service layer
        List<ClientDTO> clients = clientService.getAllClients();
        // Return the list of clients in the HTTP response with OK status
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    // Endpoint to retrieve a client by ID
    @GetMapping("client/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        // Find the client by ID using the service layer
        ClientDTO client = clientService.findClientById(id);
        // Return the client DTO if found, otherwise return NOT FOUND status
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to update a client by ID
    @PutMapping("/client/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody UpdateCLientDTO updateCLientDTO) {
        // Update the client using the provided DTO and ID
        ClientDTO updatedClient = clientService.updateClient(id, updateCLientDTO);
        // Return the updated client DTO with OK status
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    // Endpoint to delete a client by ID
    @DeleteMapping("/client/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        // Delete the client by ID using the service layer
        clientService.deleteClient(id);
        // Return NO CONTENT status as the client has been successfully deleted
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
