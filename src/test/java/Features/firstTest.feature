Feature: First test

    Scenario: sign up new user
        Given I see myStore page
        When I click sign in link
        And I create new email
        And I fill all fields from account
        And Click Register button
        Then I see my account page

    Scenario: Sign up the user
        Given I see myStore page
        When I click sign in link
        And I sign in the user
        Then I see my account page