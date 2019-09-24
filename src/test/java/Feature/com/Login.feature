Feature: Free CRM Login test

Scenario: User is able to login sucessfully
Given User is on "login_page"
When User enter the "UserName"
And User enter the "PassWord"
And User click on "Submit"
Then user verify the $HomePage
Then user close the browser