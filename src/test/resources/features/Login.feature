Feature: Login functionality for a mobile application

  Scenario Outline: Login with different user types
    Given I launch the mobile application
    And   I go to the login page
    When I enter "<username>" and "<password>" on the login screen
    And I click on the login button
    Then I should see the "<expectedOutcome>"

    Examples:
      | username          | password | expectedOutcome                                             |
      | alice@example.com | 10203040 | Sorry, this user has been locked out.                       |
      | 1@2.com           | f-o-o    | Provided credentials do not match any user in this service. |
      |                   |          | Username is required                                        |
      | bob@example.com   |          | Password is required                                        |
      | bob@example.com   | 10203040 | Products                                                    |
