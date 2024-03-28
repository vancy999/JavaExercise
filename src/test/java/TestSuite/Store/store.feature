Feature: Store

  Scenario: Get inventory
    When url "https://petstore.swagger.io/v2/store/inventory"
    When method get
    Then print response
    And status 200