Feature: Login functionality by ui

	@login
  Scenario: To validate user login from ui and redirects to dashboard page
    Given user is on login page
    And user enters login cred and sign in
    Then user is on dashboard page
