Feature: Movie Details

  Scenario: View 'The Empire Strikes Back' details
    Given the user is on the movie list page
    When the user selects 'The Empire Strikes Back'
    Then the 'Species' list should include 'Wookie'

  Scenario: Verify 'Camino' is not part of 'The Phantom Menace'
    Given the user is on the movie list page
    When the user selects 'The Phantom Menace'
    Then 'Camino' should not be listed as a planet
