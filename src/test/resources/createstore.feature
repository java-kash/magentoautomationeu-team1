@CreateStore
Feature: store manager can create a store

  Background:
  Given admin user is already in Magento admin login page
  When admin user enter valid username and password
  Then admin user able to login successfully


  Scenario Outline: store manager can create a store
    Given store manager is on the dashboard page
    When the user fills out a new store form "<storeName>"
    Then a new store should be created

    Examples:
    |storeName|
    |masterStore|