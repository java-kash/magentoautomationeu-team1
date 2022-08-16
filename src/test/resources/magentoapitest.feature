 @MagentoApiTest
   Feature: Get Post Put request Api Test For Magento Application controller
     Scenario Outline: User should be able to Get All Customers information
       Given User Should be able Get Request information
       When User Should be able to send request get"<customers>" information
       Then User Should be get information about the Customer
       Examples:
       |customers|
       |customers|

       Scenario Outline: User should be able to update a customer group
         Given User should be able to send request for update specific "<customer_Group>" information.
         Then User should get response '<code>' .
         Examples:
        | customer_Group|code|
         |customergroup/110|    204|



