Feature: Search

  Scenario: Search the hotel
    Given Main Booking page opened
    When User input the name of hotel"Castle Inn"
    And User click button Search
    Then  hotel "Castle Inn"presents on page
    Then hotel has "8.5" rating
