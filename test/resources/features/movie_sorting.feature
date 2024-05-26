Feature: Movie Sorting

  Scenario: Sort movies by 'Title'
    Given the user is on the movie list page
    When the user selects the 'Title' sorting option
    Then the last movie in the list should be 'The Phantom Menace'

  Scenario: Sort movies by 'Title' (alternate order)
    Given the user is on the movie list page
    When the user selects the 'Title' sorting option
    Then the first movie in the list should be 'Attack of the Clones'
