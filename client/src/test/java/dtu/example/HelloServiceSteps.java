package dtu.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import dtu.example.service.HelloService;

import org.junit.jupiter.api.Assertions;

public class HelloServiceSteps {
    private String result;
    private final HelloService service = new HelloService();

    @When("I call the hello service")
    public void iCallTheHelloService() {
        result = service.hello();
    }

    @Then("I get the answer {string}")
    public void iGetTheAnswer(String answer) {
        Assertions.assertEquals(answer, result);
    }
}
