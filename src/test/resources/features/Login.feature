Feature: Verify Login

  Scenario Outline: Verify login (valid data)
    Given user opens the LogIn Page
    When user enters valid login as <login> and password as <password>
    Then user sees Home Page with MyAccount button
    Examples:
      | login                     | password        |
      | "finaltestuser@final.com" | "finaltestuser" |

  Scenario Outline: Verify login (invalid data)
    Given user opens the LogIn Page
    When user enters invalid login as <login> and password as <password>
    Then user sees Error Message about login
    Examples:
      | login                     | password |
      | "final@final.com"         | "final"  |
      | "finaltestuser@final.com" | "final"  |
      | "final@final.com"         | ""       |
      | ""                        | "final"  |