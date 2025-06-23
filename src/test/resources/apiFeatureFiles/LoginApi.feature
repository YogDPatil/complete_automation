Feature: Login from api feature

  @login
  Scenario: To validate user create job from api
    Given The base url of app "http://64.227.160.186:9000/v1"
    And The header of the request
    |Content-Type|application/json|
    And Body of the request with "iamfd" and "password"
    And Post the request with endpoint "/login"
    Then The response status should be "200"
    And Token should not be null
    
