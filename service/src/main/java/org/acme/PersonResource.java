package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {
    private Person person = new Person("John Doe", "123 Main St");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson() {
        return person;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(Person newPerson) throws Exception {
        if (newPerson.address() == null || newPerson.address().equals("-none-")) {
            throw new PersonException("Address cannot be " + newPerson.address());
        }

        this.person = newPerson;
    }
}
