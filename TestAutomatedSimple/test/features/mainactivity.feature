Feature: MyActivity feature

  Scenario: As a valid user I can control the first edit text
    Given I should see "ciao belli"
    Then I clear input field with id "editText1"
    Then I enter text "ale udin!" into field with id "editText1"
    Then I should see "ale udin!"
    Then I wait for 2 seconds

  Scenario: As a valid user I want to multiply two values
    Given I should see "0"
    Then I enter text "22" into field with id "multiply1EditText"
    Then I enter text "12" into field with id "multiply2EditText"
    Then I press view with id "multiplyButton"
    Then I should see "264"
    Then I wait for 2 seconds  