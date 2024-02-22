package com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message) {
        super(message);
    }
}
