
@MagentoStoreModuleFeature

Feature: Magento Store Module Function Test

#****************     Habiba *****************
#Login
  Background:
      Given admin user is already in Magento admin login page
      When admin user enter valid username and password
      Then admin user able to login successfully

#*****************    Nijat     *******************

    @CreateNewOrder
    Scenario: Store Manager can create a new order
      Given   create page object
      When    a customer selected
      Then    create a new order
      And     verify create a new order

    @EditOrder
    Scenario: Store Manager can edit order
      Given   create page object
      When    a customer select for edit
      Then    edit a new order
      And     verify  edit order

    @CancelOrders
    Scenario: Store Manager can cancel order
      Given   create page object
      When    select a customer
      Then    cancel order
      And     verify  cancel order

      @CreateStoreView
      Scenario: Store manager can create store view





