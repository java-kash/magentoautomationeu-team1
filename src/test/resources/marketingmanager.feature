@MagentoMarketingModuleFeature
Feature:  Marketing Module Function Test

# Background:
# Given Marketing manager  is already in Magento admin login page
#   When Marketing manager  enter valid username and password
#   Then Marketing manager able to login successfully

  Scenario Outline: Marketing Manager can add new Catalog Price Rule
    Given Marketing manager on the dashboard page
    When  Click on the Catalog Price Rules
    And Marketing manager add new rule"<ruleName>"
    Then Marketing manager add new catalog price rule
    Examples:
      | ruleName |
      | Team1    |
