@MagentoStoreModuleFeature

Feature: Magento Store Module Function Test

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

#   ***************** Esma ************************
  @AddStore
  Scenario Outline: store manager can create a store
    Given store manager is on the dashboard page
    When the user fills out a new store form "<storeName>"
    Then a new store should be created

    Examples:
      | storeName   |
      | masterStore |

#     ******Esma*************************

  @EditStore
  Scenario: store manager can create a store
    Given store manager is on the dashboard page
    When  the user edit the store
    Then store edit successfully
 #   ***************** Zohra ************************
  @addWebsite
  Scenario: Store Manager create website
    Given   store manager is on the dashboard page
    When    store manager should be able to create website
    Then   a new website should be created


  @editWebsite
  Scenario:store manager edit website
    Given store manager is on the dashboard page
    When  the user edit the website
    Then  website edit successfully


   @deleteWebsite
   Scenario:store manager delete website
     Given store manager is on the dashboard page
     When  the user delete the website
     Then  website delete successfully

  @viewAllStores
  Scenario: Store Manager can view all stores
    Given store manager is on the dashboard page
    When user clicks on manage product under Catalog link
    Then all stores succes display










    #*****************    Kadirdan     *******************
  @Kadirdan
  Scenario Outline: test Add , Edit and Delete Product Category functionality
    Given store manager is on the dashboard page
    When user gets the title of the page
    Then page title should be "Manage Currency Rates / System / Magento Admin"
    Then user gets page tab section
      | Sales   |
      | Catalog |
      | System  |
    And home page tab section count should be 3
    When user hovers to click the "Catalog"
    Then user gets Catalog tab section
      | Manage Products        |
      | Manage Categories      |
      | Attributes             |
      | URL Rewrite Management |
      | Search Terms           |
      | Reviews and Ratings    |
      | Tags                   |
      | Google Sitemap         |
    And Catalog tab's section count should be 8
    When user hovers to click the "Manage Categories"
    Then user navigates to "New Root Category"
    And user gets the title of the page
    And page title should be "New Category / Manage Categories / Categories / Catalog / Magento Admin"
    And user gets Category Information tabs
      | General Information |
      | Display Settings    |
      | Custom Design       |
      | Category Products   |
    And Category Information tabs count should be 4
    And user sees General Information form
    When user fills the form given sheet name "<SheetName>" and row number <RowNumber>
    And user clicks on Save Category button
    Then it shows a successful message "The category has been saved."
    And user sees New Category folder in the left Categories Side Column
    When user clicks on new Category which created before for editing
    And user changes any field on the form
    And user clicks on Save Category button
    Then it shows a successful message "The category has been saved."
    When user clicks on new Category which created before for editing
    And user clicks on Delete Category button
    And user clicks on the OK button from an alert pop up
    Then it shows a successful message "The category has been deleted."
    Examples:
      | SheetName                | RowNumber |
      | General_Information_Data | 0         |






  @CreateStoreView
  Scenario Outline: Store manager can create store view
    Given store manager is on the dashboard page
    When store manager create new store view  "<StoreViewName>" and  "<code>"
    Then verify create new store view
    Examples:
  | StoreViewName              | code   |
  | team122                    | ahhqghswedwe |

  @EditStoreView
  Scenario Outline: Store manager can edit Store View
    Given store manager is on the dashboard page
    When store manager edit store view  "<StoreViewName2>" and  "<code2>"
    Then verify edited store view
    Examples:
      | StoreViewName2            | code2   |
      | team123                    | agfwde |



