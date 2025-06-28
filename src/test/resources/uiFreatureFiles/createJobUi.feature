Feature: Create job functionality from ui

  Background: 
    Given user is on login page
    And user enters login cred and sign in
    Then user is on dashboard page

  @create_job
  Scenario: To validate that user can create job from ui
	Given user is on create job page 
	When user enters job details
	And click on "submit" button
	Then job should be creat and id is generated