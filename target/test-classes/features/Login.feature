Feature: Login Functionality

Scenario Outline: login with validCredentials
Given user navigates to the login page
When user enters valid emailId <username>
And user enters validPassword <password>
And user click on the login button
Then user navigates to account page
Examples:
|username|password|
|1@agmail.com|123456|
|1@bgmail.com|123456|
|1@cgmail.com|123456|

Scenario: login with invalidCredentials
Given user navigates to the login page
When user enters inValid emailId
And user enters inValid password "123456789"
And user click on the login button
Then user seen warning message about invalid emailId and password

Scenario: login with validEmailIdAndInvalidPassword
Given user navigates to the login page
When user enters valid emailId "1@agmail.com"
And user enters inValid password "123456789"
And user click on the login button
Then user seen warning message about invalid emailId and password

Scenario: login with invalidEmailIdAndValidPassword
Given user navigates to the login page
When user enters inValid emailId
And user enters validPassword "123456"
And user click on the login button
Then user seen warning message about invalid emailId and password

Scenario: login without providing anyDetails
Given user navigates to the login page
When user didnot enters any value in emailId field
And user didnot enters any value in password field
And user click on the login button
Then user seen warning message about invalid emailId and password


