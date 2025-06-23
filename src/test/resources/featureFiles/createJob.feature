Feature: Create job functionality from api

  @login
  Scenario Outline: To validate user create job from api
    Given The base url of app "http://64.227.160.186:9000/v1"
    And The header of the request
    |Content-Type|application/json|
    And Body of the request with "<username>" and "<password>"
    And The post request with endpoint "/login"
    Then The response status should be "200"
    And Token should not be null
    
    Examples:
      | username | password |
      | iamfd    | password |
