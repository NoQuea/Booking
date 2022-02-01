Feature: Hotel search
  Scenario: Search hotel for me
    Given I want to search for "Minsk"
    When I do search
    Then Results page should contain "IT Time Hotel"
    And rating should be "8,4"

