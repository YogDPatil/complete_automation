Feature: Create job functionality from ui

  Background:
  	Given user login to the app and redirects to the dashboard page

  @create_job
  Scenario: To validate that user can create job from ui
    Given user is on create job page
    When user enters job details and submit it
    Then job should be create and id is generated
