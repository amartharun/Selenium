Feature: LoginPage


  Scenario: Verify SuccessFull Login
    Given user launch the Chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on loutout link
    Then page title should be "Your store. Login"
    And close browser


  Scenario Outline: Login Data Driven
    Given user launch the Chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enters Email as "<email>" and password as "<password>"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on loutout link
    Then page title should be "Your store. Login"
    And close browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com |      123 |
