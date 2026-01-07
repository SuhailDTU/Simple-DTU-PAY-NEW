Feature: PersonService

  Scenario: Person Service returns correct person
    Given the person service is initialized with name "John Doe" and address "123 Main St"
    When I call GET on the person service
    Then I get the person with name "John Doe" and address "123 Main St"

  Scenario: Person Service allows setting a new person
    When I call POST on the person service with name "Jane Smith" and address "456 Oak Ave"
    And I call GET on the person service
    Then I get the person with name "Jane Smith" and address "456 Oak Ave"

  Scenario: Person service rejects invalid person data
    When I call POST on the person service with name "Jane Smith" and address "-none-"
    Then I get a 400 Bad Request response
