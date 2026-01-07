package org.acme;

import jakarta.ws.rs.BadRequestException;

public class PersonException extends BadRequestException {
    public PersonException(String message) {
        super(message);
    }
}

