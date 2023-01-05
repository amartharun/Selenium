Feature: Add New Customer 

	Background:
		Given user launch the Chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then User can view Dashboard
    When User click on customers menu
    And click on customers menu item
 
 
  Scenario: Verify SuccessFull addition of Customer
    And click on Add new button
    Then user can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
   

	Scenario: Search Customer by EmailId
		And Enter customer Email
		When click on search button
		Then user should found email in Search table
		And close browser