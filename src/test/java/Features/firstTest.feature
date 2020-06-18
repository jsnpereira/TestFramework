Feature: First test

    Scenario: sign up new user
        Given I see welcome page
        And I click sign in link
        And I click sign up link
        When I fill the username and password on fields
        And I click sign up button
        Then I see address book page



