@DataBaseTest
  Feature: Data Base Test

    @VerifyNewlyAddedCustomers
      Scenario: Verify that newly added customers should be in the database
      Given      connect to data base server
      When       is customer exist
      Then       Verify Newly Added Customers in data base server






