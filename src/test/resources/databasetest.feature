@DataBaseTest
Feature: Data Base Test

  @VerifyNewlyAddedCustomers
  Scenario: Verify that newly added customers should be in the database
    Given      connect to data base server
    When       is customer exist
    Then       Verify Newly Added Customers in data base server


  Scenario: Verify that newly added store view should be in the database
    Given connect to data base server
    When I get store view information
    Then Store view is visible at database

  Scenario: Verify the newly added tax rule should be in the database
    Given connect to data base server
    When I get tax rule information
    Then Tax rule is visible at database

