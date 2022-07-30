@SalesModuleFeature
Feature: Magento UI Automation Sales Module

@SalesManagerViewCustomerShoppingCart
Scenario:  Sales manager can view customers shopping cart
  Given Sales manager at the Manage Customers page
  When Sales manager click on customer
  Then Sales manager at the Customer Information page and click on Shopping Cart to view shopping cart

#  **************************Esma**************************
 @SalesManagerViewInvoicesAndCommentsToInvoices
Scenario Outline: Sales Manager should be able to view invoices and add comments to invoice history
  Given sales manager is on the sales dashboard page
  When  sales manager can view invoices on the invoices page
  Then  sales manager should be able to view invoices
  And sales manager comments to invoices"<commentText>"
  Then sales manager should be able to comments to invoices

  Examples:
  |commentText|
  |payment completed|

   Scenario: Sales Manager should be able to create a new order
     Given sales manager is on the sales dashboard page
     When  sales manager can create new order
     Then sales manager should see success massage

   Scenario: Sales Manager should be able to edit orders with in store pickup
     Given   sales manager is on the sales dashboard page
     When    sales manager edit orders with in store pickup
     Then    verify edit orders success







