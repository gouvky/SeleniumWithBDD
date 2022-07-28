#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Login Feature

@Sanity1
  Scenario: Verify the successful Login of the application
    Given Enter the application url
    Given Enter username and password
    When Click on login button
    Then Verify the title of the page "OrangeHRM"
    When Click on Logout link
    And Close the browser

@Sanity2
  Scenario Outline: Verify the Positive and Negative Login scenario of the application
    Given Enter the application url
    Given Enter username as '<username>' and password as '<password>'
    When Click on login button
    Then Verify the title of the page "OrangeHRM"
    When Click on Logout link
    And Close the browser

    Examples: 
      | username | password |
      | Admin    | admin123 |
      | Admin123 | admin123 |

@Sanity3
  Scenario: Verify the successful Login of the application (Datatable without header)
    Given Enter the application url
    Given Enter username and password in login page
      | Admin    |
      | admin123 |
    When Click on login button

@Sanity4
  Scenario: Verify the successful Login of the application (Datatable with header)
    Given Enter the application url
    Given Enter username and password in the login page
      | username | password |
      | Admin    | admin123 |
    When Click on login button

@Excel
  Scenario: Verify the successful Login of the application (Using Excel)
    Given Enter the application url
    Given Fetch Credentails from Excel file
    
      | SheetName   | Row | Col |
      | Credentials |   0 |   0 |
      | Credentials |   0 |   1 |
    When Click on login button
