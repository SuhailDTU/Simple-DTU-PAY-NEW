Feature: HelloService

  Scenario: Hello Service returns correct answer
    When I call the hello service
    Then I get the answer "Hello RESTEasy"
