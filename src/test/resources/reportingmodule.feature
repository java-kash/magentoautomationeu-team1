@MagentoReportingModuleTest
  Feature: Reporting Module Functions
    Scenario Outline: Reporting manager can see sales orders
      Given Reporting Manager at the dashboard page
      When Reporting manager navigate to sales ordered report page
      And Fills in "<fromDate>" "<toDate>" and clicks submit button
     Then Report is visible
      Examples:
      |fromDate|toDate|
      | 01/01/2000       |   01/01/2022   |
    Scenario Outline: Reporting manager can see sales refund orders
        Given Reporting Manager at the dashboard page
        When Reporting manager navigate to sales refund report page
        And Fills in "<fromDate>" "<toDate>" and clicks submit button
      Then Report is visible
      Examples:
        |fromDate|toDate|
        | 01/01/2000      |   01/01/2022   |


      Scenario: Reporting Manager should be able to see Shopping Cart - Abandoned carts Report
        Given Reporting Manager at the dashboard page
        When  see Shopping Cart - Abandoned carts Report
        Then  verify see Shopping Cart - Abandoned carts Report

      Scenario: Reporting Manager should be able to see Tags - Popular Report
        Given   Reporting Manager at the dashboard page
        When    see Tags - Popular Report
        Then    verify see Tags - Popular Report



        #*********************************Kadirdan*****************************

    Scenario: user navigates to Order Taxes Report Grouped by Tax Rate page
      Given Reporting Manager at the dashboard page
      Then Reporting navigates to "Dashboard" page
      When Reporting gets the title of the page
      Then Reporting module page title should be "Dashboard / Magento Admin"
      When Reporting hovers to click the "Reports"
      And Reporting hovers to click the "Sales"
      And Reporting hovers to click the "Tax"
      Then Reporting navigates to "Order Taxes Report Grouped by Tax Rate" page
      Given Reporting gets the title of the page
      Then Reporting module page title should be "Tax / Sales / Reports / Magento Admin"

    Scenario: user navigates to Downloads page
      Given Reporting Manager at the dashboard page
      Then Reporting navigates to "Dashboard" page
      Given Reporting gets the title of the page
      Then Reporting module page title should be "Dashboard / Magento Admin"
      When Reporting hovers to click the "Reports"
      And Reporting hovers to click the "Products"
      And Reporting hovers to click the "Downloads"
      Then Reporting navigates to "Downloads" page
      Given Reporting gets the title of the page
      Then Reporting module page title should be "Downloads / Products / Reports / Magento Admin"


      Scenario: Reporting Manager can see shopping cart Product in carts
        Given Reporting Manager at the dashboard page
        When see Shopping cart-Product in cart
        Then Vrify can see shopping cart-product in carts



      #*********************************Zohra*****************************
    @Reporting
    Scenario Outline: Reporting Manager can see Products Most Viewed Report
      Given Reporting Manager at the dashboard page
      When Reporting manager navigate to  most viewed page
      And Fills in "<fromDate>" "<toDate>" and clicks show report button
      Then Most viewed report is visible
      Examples:
        |fromDate|toDate|
        | 01/01/2021      |   01/01/2022   |
    @ProductReviewsReport
    Scenario: Reporting Manager can see  product reviews report
      Given Reporting Manager at the dashboard page
      When see product reviews report
      Then  verify see product reviews report

      @BestsellersReport
      Scenario: Reporting manager should be able to see Products Bestsellers Report
        Given Reporting Manager at the dashboard page
        When Reporting manager at the bestsellers page
        Then Reporting manager at the reports page
        Then Verify products bestsellers reports



      Scenario: Reporting Manager should be able tol see Tags - Customer Report
        Given Reporting Manager at the dashboard page
        When See Tags - Customer Report
        Then Verify Customer Reports Page


    Scenario Outline: Reporting Manager should be able to see  Sales - Total Ordered Report
      Given Reporting Manager at the dashboard page
      When  Open order page
      Then  show oredere reports with dates "<fromDate>" "<toDate>"
      Then verify table

      Examples:
        | fromDate   | toDate     |
        | 01/01/2021 | 01/01/2022 |
