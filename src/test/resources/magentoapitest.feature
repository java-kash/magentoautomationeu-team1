 @MagentoApiTest
   Feature: Get Post Put request Api Test For Magento Application controller
     Scenario Outline: User should be able to Get All Customers information
       Given User Should be able Get Request information
       When User Should be able to send request get"<customers>" information
       Then User Should be get information about the Customer
       Examples:
       |customers|
       |customers|

