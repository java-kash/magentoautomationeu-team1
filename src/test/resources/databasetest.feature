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

  @VerifyNewlyAddedOrder
  Scenario: Verify that newly added orders should be in the database
    Given connect to data base server
    When The newly added order is exist
    Then Verify Newly added order in database server




  Scenario: Verify that newly added sub categories should be in the database
    Given connect to data base server
    When I get sub category information
    Then sub category is visible at database

  @VerifyNewlyAddedStock
  Scenario: verify-that-newly-added-stock-should-be-in-the-database-abdukerim
    Given connect to data base server
    When  I Got stock information
    Then Verify Newly Added stock in database
