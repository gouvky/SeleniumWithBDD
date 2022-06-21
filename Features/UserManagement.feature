Feature: User Management Feature

 Background: Perform the pre-requisite before executing the scenarios
    Given Enter the application url
    Given Enter username and password
    When  Click on login button
    Then  Verify the title of the page "OrangeHRM"

  Scenario: Add User in the User Management screen 
    When Navigate to Users screen from Admin Menu
    When Click Add button to add user
    When Fill the User details
    When Click Save button to save the user details
    When Click on Logout link
    And  Close the browser