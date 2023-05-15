Feature: Employees

    @createEmployeeScenario
    Scenario: Create a new employee
        Given I am on the employee creation page
        When I select employee department
        And I enter the employee name
        And I enter the employee phone
        And I click on the save button
        Then I am redirected to Employees page
        And I am able to search by new employee's name in the table

    @searchEmployeeScenario
    Scenario: Search employee  
        Given A new employee is created
        And I am on the employees page
        When I type new employee's phone in the search field
        Then Table results are filtered by searched employee's phone
        When I type new employee's department in the search field
        Then Table results are filtered by searched employee's department
        When I type new employee's name in the search field
        Then Table results are filtered by searched employee's name
       
