Feature: register functionality

Scenario: register with mandatory fields
Given user navigates to register page
When user enters value for the mandatory fields
|firstName|eleven|
|lastName|micky|
|telephone|123456|
|registerPassword|123456|
|registerConfirmPassword|123456|
And user clicks on the privacy policy
And user click on continue button
Then user navigates to account created page

Scenario: register with all fields
Given user navigates to register page
When user enters value for the all fields
|firstName|eleven|
|lastName|micky|
|telephone|123456|
|registerPassword|123456|
|registerConfirmPassword|123456|
And user clicks on newsletter policy
And user clicks on the privacy policy
And user click on continue button
Then user navigates to account created page

Scenario: register with duplicate email
Given user navigates to register page
When user enters value for the all fields with duplicate email
|firstName|eleven|
|lastName|micky|
|email|vijayozil87@gmail.com|
|telephone|123456|
|registerPassword|123456|
|registerConfirmPassword|123456|
And user clicks on newsletter policy
And user clicks on the privacy policy
And user click on continue button
Then user got duplicate mail warning

Scenario: register without providing any values
Given user navigates to register page
When user didnot enters value for the fields
And user click on continue button
Then user got mandatory fields warning
