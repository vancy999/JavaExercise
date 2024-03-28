Feature: User Module
  Background:
    Given url "https://petstore.swagger.io/v2/"
    And print "--Connect petstore API--"

  Scenario: Add new user
    * def reqBody = {"id": 3,"username": "irvantest01","firstName": "irvan01","lastName": "testing","email": "v0001@a.com","password": "12345","phone": "0877","userStatus": 0}
    When url "https://petstore.swagger.io/v2/user"
    And request reqBody
    When method post
    Then print response
    And status 200

  Scenario: add user with array
    * def reqBody = [{"id": 3,"username": "irvantest01","firstName": "irvan02","lastName": "testing","email": "v0002@a.com","password": "12345","phone": "0877","userStatus": 0}, {"id": 3,"username": "irvan03","firstName": "irvan03","lastName": "testing","email": "v003@a.com","password": "12345","phone": "0877","userStatus": 0}]
    When url "https://petstore.swagger.io/v2/user/createWithArray"
    And request reqBody
    When method post
    Then print response
    And status 200

  Scenario: add user with list
    * def reqBody = [{"id": 3,"username": "irvan04","firstName": "irvan04","lastName": "testing","email": "v0004@a.com","password": "12345","phone": "0877","userStatus": 0}, {"id": 3,"username": "irvan05","firstName": "irvan05","lastName": "testing","email": "v0005@a.com","password": "12345","phone": "0877","userStatus": 0}]
    When url "https://petstore.swagger.io/v2/user/createWithList"
    And request reqBody
    When method post
    Then print response
    And status 200

  Scenario: Get user by username
    When url "https://petstore.swagger.io/v2/user/aishatesting0001"
    When method get
    Then print response
    And status 200

  Scenario: Get user login
    When url "https://petstore.swagger.io/v2/user/login"
    And params {username:irvan01}
    And params {password:12345}
    When method get
    Then print response
    And status 200

  Scenario: update user
    * def reqBody = {"id": 3,"username": "irvan01","firstName": "irvanvan","lastName": "testingting","email": "vancy@a.com","password": "12345","phone": "0877","userStatus": 0}
    When url "https://petstore.swagger.io/v2/user/irvan01"
    And request reqBody
    When method put
    Then print response
    And status 200

  Scenario: Get updated user
    When url "https://petstore.swagger.io/v2/user/irvan01"
    When method get
    Then print response
    And status 200

  Scenario: delete user
    When url "https://petstore.swagger.io/v2/user/irvan02"
    When method delete
    Then print response
    And status 200

  Scenario: get success deleted user
    When url "https://petstore.swagger.io/v2/user/irvan02"
    When method delete
    Then print response
    And status 200

  Scenario: update user not found
    * def reqBody = {"id": 3,"username": "xxx","firstName": "xx","lastName": "xx","email": "xxx","password": "xxx","phone": "0877","userStatus": 0}
    When url "https://petstore.swagger.io/v2/user/irvan1234000111"
    And request reqBody
    When method put
    Then print response
    And status 404

  Scenario: delete user not found
    When url "https://petstore.swagger.io/v2/user/irvantest100"
    When method delete
    Then print response
    And status 404

  Scenario: Get user logout
    When url "https://petstore.swagger.io/v2/user/logout"
    When method get
    Then print response
    And status 200