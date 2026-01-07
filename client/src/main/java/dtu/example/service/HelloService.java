package dtu.example.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class HelloService {
    private final String baseUrl;

    public HelloService() {
        this("http://localhost:8080");
    }

    public HelloService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String hello() {
        try (Client client = ClientBuilder.newBuilder().build()) {
            return client.target(baseUrl).path("hello").request().get(String.class);
        }
    }

}
