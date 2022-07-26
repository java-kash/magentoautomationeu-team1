@MagentoMarketingModuleFeature
Feature:  Marketing Module Function Test

  Scenario Outline: Marketing Manager can add new Catalog Price Rule
    Given Marketing manager on the dashboard page
    When  Click on the Catalog Price Rules
    And Marketing manager add new rule"<ruleName>"
    Then Marketing manager add new catalog price rule
    Examples:
      | ruleName |
      | Team1    |


  Scenario: Marketing Manager can update existing Catalog Price Rule
    Given   Marketing manager on the dashboard page
    When    Catalog Price Rule Page Open
    Then    update existing Catalog Price Rule
    And     verify existing Catalog Price Rule updated

    Scenario: Marketing Manager can update pending reviews
      Given Marketing manager on the dashboard page
      When Marketing manager should be able edit pending reviews
      Then Marketing manager can update pending reviews

      Scenario Outline:Marketing Manager can add new Newsletter template
        Given   Marketing manager on the dashboard page
        When Marketing manager add new newsletter template"<Template Name>" and "<Template Subject>" and"<Sender Name>"
        Then Marketing manager can see her new added template "<My template name>"
        Examples:
          | Template Name|Template Subject|Sender Name|My template name|
          |QA Engineer|Testers Team|Lisa|QA Engineer|


    #   ***************** Zohra ************************
@AddNewShoppingCartPricePule
  Scenario:Marketing Manager can add new  shopping cart price rule
    Given Marketing manager on the dashboard page
    When Marketing manager should be able add new shopping cart price rule
    Then a new shopping cart price rule should be added

  Scenario: Marketing Manager can update existing Cart Price Rule
    Given Marketing manager on the dashboard page
    When Marketing manager should be able update existing
    Then Marketing manager should be updated


    Scenario Outline:Marketing manager can update an existing newsletter template
      Given Marketing manager on the dashboard page
      When Marketing manager Update "<Template Name>" and "<Template Content>"
      Then Marketing manager able to see his updated new template content "<Template Name>"
      Examples:
        |Template Name|Template Content|Template Name|
        |QA Engineer|This is my new Content|QA Engineer|