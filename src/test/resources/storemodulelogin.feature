@MagentoStoreModuleLoginFeature
  Feature: Magento StoreModule Login Function
    @Login
    Scenario: User can login with valid username and password
      Given admin user is already in Magento admin login page
      When admin user enter valid username and password
      Then admin user able to login successfully