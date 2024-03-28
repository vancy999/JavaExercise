Feature: Pet Module
  Background:
    Given url "https://petstore.swagger.io/v2/"
    And print "--Connect petstore API--"

  Scenario: Add Pet to Store
    * def reqBody = {"id":0,"category": {"id": 0,"name": "abc"},"name": "doggie","photoUrls": ["bbb"],"tags": [{"id": 0,"name": "jjj"}],"status": "available"}
    When url "https://petstore.swagger.io/v2/pet"
    When method post
    And request reqBody
    Then print response
    And status 200


  Scenario: Get Pet by ID
    When url "https://petstore.swagger.io/v2/pet/134342"
    When method get
    Then print response
    And status 200


  Scenario: Get Pet by Status
    When url "https://petstore.swagger.io/v2/pet/findByStatus"
    And params {status:available}
    When method get
    Then print response
    And status 200

  Scenario: Delete Pet
    When url "https://petstore.swagger.io/v2/pet/9222968140497180234"
    When method delete
    Then print response
    And status 200

  Scenario: check pet after Delete Pet
    When url "https://petstore.swagger.io/v2/pet/9222968140497180234"
    When method get
    Then print response
    And status 404