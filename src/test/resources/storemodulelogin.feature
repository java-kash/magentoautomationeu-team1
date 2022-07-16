@MagentoStoreModuleLoginFeature
  Feature: Magento StoreModule Login Function
#    @StoreModuleLogin
    Background:
#    Scenario: User can login with valid username and password
      Given admin user is already in Magento admin login page
      When admin user enter valid username and password
      Then admin user able to login successfully
@Esma
    Scenario Outline: store manager can create a store
      Given store manager is on the dashboard page
      When the user fills out a new store form "<storeName>"
      Then a new store should be created

      Examples:
        |storeName|
        |masterStore|


