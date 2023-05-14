Feature: Create Employee

    @createEmployee
    Scenario: Create a new employee
        Given I am on the employee creation page
        When I select employee department
        And I enter the employee name
        And I enter the employee phone
        And I click on the save button
        Then I am redirected to Employees page
        And I am able to search by new employee's name in the table
