Feature: Assign the job by sup from ui which created by fd

    Background:
        Given fd logged in and create the job

    @assign_job
    Scenario: to validate sup can assign the job from ui which created by fd
        Given sup login to the app and redirects to the dashboard page
        And user clicks on job assignmant tab and redirects to that page
        When user select the eng and assign the job
        Then job should assign with success message