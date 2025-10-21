Feature: Search functionality

Scenario: search with validProduct
Given user already on homePage
When user enters validProductName "HP"
And user clicks on search button
Then user navigates to search page

Scenario: search with invalidProduct
Given user already on homePage
When user enters inValidProductName "HPA"
And user clicks on search button
Then user navigates to search page failure message

Scenario: search withOutAnyDetails
Given user already on homePage
When user didnot enters anyProductName
And user clicks on search button
Then user navigates to search page