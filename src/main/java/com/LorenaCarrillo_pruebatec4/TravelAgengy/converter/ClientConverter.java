package com.LorenaCarrillo_pruebatec4.TravelAgengy.converter;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientsDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.CreateClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.UpdateCLientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Client;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter class responsible for converting between Client entities and DTOs.
 */
public class ClientConverter {

    /**
     * Converts a ClientDTO object to a Client entity.
     * @param in The ClientDTO object to convert
     * @return The converted Client entity
     */
    public static Client toEntity(ClientDTO in) {
        if (in == null) {
            return null;
        }

        Client out = new Client(in.getClientId());
        out.setName(in.getName());
        out.setLastName(in.getLastName());
        out.setDni(in.getDni());
        out.setNumberPhone(in.getNumberPhone());
        out.setEmail(in.getEmail());

        return out;
    }

    /**
     * Converts a Client entity to a ClientDTO object.
     * @param in The Client entity to convert
     * @return The converted ClientDTO object
     */
    public static ClientDTO toDto(Client in) {
        if (in == null) {
            return null;
        }

        ClientDTO out = new ClientDTO();
        out.setClientId(in.getClientId());
        out.setName(in.getName());
        out.setLastName(in.getLastName());
        out.setDni(in.getDni());
        out.setNumberPhone(in.getNumberPhone());
        out.setEmail(in.getEmail());

        return out;
    }

    /**
     * Converts a list of Client entities to a ClientsDTO object.
     * @param in The list of Client entities to convert
     * @return The converted ClientsDTO object
     */
    public static ClientsDTO toListDto(List<Client> in) {
        ClientsDTO out = new ClientsDTO();

        if (!CollectionUtils.isEmpty(in)) {
            out.addAll(in.stream().map(ClientConverter::toDto)
                    .collect(Collectors.toList()));
        }

        return out;
    }

    /**
     * Converts a CreateClientDTO object to a Client entity.
     * @param in The CreateClientDTO object to convert
     * @return The converted Client entity
     */
    public static Client createToEntity(CreateClientDTO in) {
        Client out = new Client();
        out.setName(in.getName());
        out.setLastName(in.getLastName());
        out.setDni(in.getDni());
        out.setNumberPhone(in.getNumberPhone());
        out.setEmail(in.getEmail());

        return out;
    }

    /**
     * Updates a Client entity based on data from an UpdateClientDTO object.
     * @param client The Client entity to update
     * @param in The UpdateClientDTO object containing the update data
     * @return The updated Client entity
     */
    public static Client updateToEntity(Client client, UpdateCLientDTO in) {
        if (in.getName() != null) {
            client.setName(in.getName());
        }
        if (in.getLastName() != null) {
            client.setLastName(in.getLastName());
        }
        if (in.getDni() != null) {
            client.setDni(in.getDni());
        }
        if(in.getNumberPhone() != null) {
            client.setNumberPhone(in.getNumberPhone());
        }
        if (in.getEmail() != null) {
            client.setEmail(in.getEmail());
        }

        return client;
    }
}

