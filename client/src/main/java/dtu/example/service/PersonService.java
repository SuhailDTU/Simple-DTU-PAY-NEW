package dtu.example.service;

import dtu.example.record.Person;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Response;

public class PersonService {
    private final String baseUrl;

    public PersonService() {
        this("http://localhost:8080");
    }

    public PersonService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Person getPerson() {
        try (var client = ClientBuilder.newClient()) {
            return client.target(baseUrl).path("person").request().get(Person.class);
        }
    }

    public Response updatePerson(Person person) {
        try (var client = ClientBuilder.newClient()) {
            try (var response = client.target(baseUrl).path("person").request().post(Entity.json(person))) {
                return response;
            }
        }
    }
}
