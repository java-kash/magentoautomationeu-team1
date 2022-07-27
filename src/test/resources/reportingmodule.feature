@MagentoReportingModuleTest
  Feature: Reporting Module Functions
    Scenario: Reporting manager can see sales orders
      Given Reporting Manager at the dashboard page
      When Reporting manager navigate to sales ordered report page
      And Fills in the required information and clicks submit button
      |01/00/2000|
