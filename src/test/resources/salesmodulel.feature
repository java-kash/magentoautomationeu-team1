@SalesModuleFeature
Feature: Magento UI Automation Sales Module

@SalesManagerViewCustomerShoppingCart
Scenario:  Sales manager can view customers shopping cart
  Given Sales manager at the Manage Customers page
  When Sales manager click on customer
  Then Sales manager at the Customer Information page and click on Shopping Cart to view shopping cart
