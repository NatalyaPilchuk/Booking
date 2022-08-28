Feature: Search

  Scenario: Search the hotel
    Given Main Booking page opened
    When User input the name of hotel"404 Rooms Wilanowska"
    And User click button Search
    Then  hotel "404 Rooms Wilanowska"presents on page
    Then hotel have right rating
