Feature: Verify SignUp

  Scenario Outline: Verify signUp (invalid data)
    Given user opens the SignUp Page
    When user enters invalid sign up data <firstName> <lastName> <email> <password> <confirmPassword>
    Then user sees Error Message about signup
    Examples:
      | firstName | lastName | email           | password | confirmPassword |
      | ""        | ""       | ""              | ""       | ""              |
      | ""        | ""       | ""              | ""       | "User"          |
      | ""        | ""       | ""              | "User"   | ""              |
      | ""        | ""       | ""              | "User"   | "User"          |
      | ""        | "User"   | ""              | ""       | ""              |
      | ""        | "User"   | ""              | ""       | "User"          |
      | ""        | "User"   | ""              | "User"   | ""              |
      | ""        | "User"   | ""              | "User"   | "User"          |
      | "User"    | ""       | ""              | ""       | ""              |
      | "User"    | ""       | ""              | ""       | "User"          |
      | "User"    | ""       | ""              | "User"   | ""              |
      | "User"    | ""       | ""              | "User"   | "User"          |
      | "User"    | "User"   | ""              | ""       | ""              |
      | "User"    | "User"   | ""              | ""       | "User"          |
      | "User"    | "User"   | ""              | "User"   | ""              |
      | "User"    | "User"   | ""              | "User"   | "User"          |
      | ""        | ""       | "user@user.com" | ""       | ""              |
      | ""        | ""       | "user@user.com" | ""       | "User"          |
      | ""        | ""       | "user@user.com" | "User"   | ""              |
      | ""        | ""       | "user@user.com" | "User"   | "User"          |
      | ""        | "User"   | "user@user.com" | ""       | ""              |
      | ""        | "User"   | "user@user.com" | ""       | "User"          |
      | ""        | "User"   | "user@user.com" | "User"   | ""              |
      | ""        | "User"   | "user@user.com" | "User"   | "User"          |
      | "User"    | ""       | "user@user.com" | ""       | ""              |
      | "User"    | ""       | "user@user.com" | ""       | "User"          |
      | "User"    | ""       | "user@user.com" | "User"   | ""              |
      | "User"    | ""       | "user@user.com" | "User"   | "User"          |
      | "User"    | "User"   | "user@user.com" | ""       | ""              |
      | "User"    | "User"   | "user@user.com" | ""       | "User"          |
      | "User"    | "User"   | "user@user.com" | "User"   | ""              |
      | "User"    | "User"   | "user@user.com" | "User"   | "User"          |