@MagentoReportingModuleTest
  Feature: Reporting Module Functions
    Scenario Outline: Reporting manager can see sales orders
      Given Reporting Manager at the dashboard page
      When Reporting manager navigate to sales ordered report page
      And Fills in "<fromDate>" "<toDate>" and clicks submit button
     Then Report is visible
      Examples:
      |fromDate|toDate|
      | 01/01/2021       |   01/01/2022   |
    Scenario Outline: Reporting manager can see sales refund orders
        Given Reporting Manager at the dashboard page
        When Reporting manager navigate to sales refund report page
        And Fills in "<fromDate>" "<toDate>" and clicks submit button
      Then Report is visible
      Examples:
        |fromDate|toDate|
        | 01/01/2000      |   01/01/2022   |