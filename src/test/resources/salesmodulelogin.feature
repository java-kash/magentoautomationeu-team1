@SalesModuleLoginFeature
Feature: Magento UI Automation Sales Module Login Function

  @Login
    @Background:
  Scenario Outline: User can login to the application with valid username and password
    Given Sales Manager is already in Magento admin login page
    When admin user enter valid "<username>" and "<password>" for sales module
    Then admin user able to successfully login to the sales module dashboard page.

    Examples:
      | username     | password       |
      | salesmanager | automation123! |
@SalesManagerViewCustomerShoppingCart
Scenario: Sales manager can view customers shopping cart
  Given Sales manager at the Manage Customers page
  When Sales manager click on customer
  Then Sales manager at the Customer Information page and click on Shopping Cart to view shopping cart
