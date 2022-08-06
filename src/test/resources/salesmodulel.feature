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
    @Sales-Manager-should-be-able-to-create-a-new-order
   Scenario: Sales Manager should be able to create a new order
     Given sales manager is on the sales dashboard page
     When  sales manager can create new order
     Then sales manager should see success massage

    @SalesManagershouldbeabletocancelorder
     Scenario: Sales Manager should be able to cancel  order
       Given sales manager is on the sales dashboard page
       When sales manager can cancel order
       Then sales manager should see cancel success massage


   Scenario: Sales Manager should be able to edit orders with in store pickup
     Given   sales manager is on the sales dashboard page
     When    sales manager edit orders with in store pickup
     Then    verify edit orders success


     #  **************************Kadirdan**************************

  Scenario: Sales Manager should be able to add and view new credit memos
    Given sales manager is on the sales dashboard page
    Given Sales navigates to "Dashboard" page
    When Sales gets the title of the page
    Then Sales module page title should be "Dashboard / Magento Admin"
    When Sales hovers to click the "Sales"
    And Sales hovers to click the "Orders"
    Given Sales navigates to "Orders" page
    When Sales gets the title of the page
    Then Sales module page title should be "Orders / Sales / Magento Admin"
    When user selects Pending or Processing sections in Status drop down
    And Sales clicks on "Search" button
    And user clicks on any order in the list table
    Given Sales navigates to "Order View" page
    When Sales clicks on "Invoice" button
    And user gets the Credit Memos number on the table
    And Sales clicks on "Submit Invoice" button
    Then Sales should be able to see success message "The invoice has been created."
    When Sales clicks on "Credit Memo" button
    And Sales clicks on "Refund Offline" button
    Then Sales should be able to see success message "The credit memo has been created."
    When Sales hovers to click the "Dashboard"
    Given Sales navigates to "Dashboard" page
    When Sales gets the title of the page
    Then Sales module page title should be "Dashboard / Magento Admin"
    And Sales hovers to click the "Sales"
    And Sales hovers to click the "Credit Memos"
    Given Sales navigates to "Credit Memos" page
    When Sales gets the title of the page
    Then Sales module page title should be "Credit Memos / Sales / Magento Admin"
    When user enters order number in the Order field
    And Sales clicks on "Search" button
    Then user should be able to see new Credit Memos in the table list



  Scenario: Sales Manager should be able to add and view new credit memos
   Scenario Outline: Sales Manager should be able to update( history and tracking information) shipments
    Given sales manager is on the sales dashboard page
    When sales manager can update tracking and history information shipments"<CommentText>"
    Then sales manager should be able to comments to shipments
    Examples:
     |CommentText|
     |shipment delivered|

     @UpdateShoppingCart
     Scenario: Sales manager should be able to update an existing shopping cart
       Given sales manager is on the sales dashboard page
       When Sales manager is on the customer page
       Then Sales manager can update an existing shopping cart
       Then verify update shopping cart


