Feature: Create job from api

  Background: Login and generate token
    Given The base url of app "http://64.227.160.186:9000/v1"
    And The header of the request
      | Content-Type | application/json |
    And Body of the request with "iamfd" and "password"
    When Post the request with endpoint "/login"
    Then Token should not be null

  @create_job
  Scenario: To validate user can create job from api
    Given The base url for the create job api "http://64.227.160.186:9000/v1"
    And The header of the create job request
      | Content-Type | application/json |
    And The body of the post request
    When Post the request of create job with endpoint "/job/create"
    Then The job should create with status code "200"
    And Job id is created
