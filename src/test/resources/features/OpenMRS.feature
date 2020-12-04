@smoke
Feature: OpenMRS page login tests


  @techtorialTag @thebestScenerio @neverFails
  Scenario: Successful login
    When  user navigates to home page
    And user logs in to Registration Desk using "admin" and "Admin123"
    Then verify if user is 'Super User (admin)'

  @regression @sanity @manual @sit @dev
  Scenario: Find patient
    Given user logged in to demo.openmrs.org
    When user searches for 123 patient on Find Patient Record page
    Then no records found

  @muhammed
  Scenario: Login with cucumber datatable (variant 1)
    When user navigates to open MRS home page
    And user logs in using following data:
      | departmentName    | username | password |
      | Registration Desk | admin    | Admin123 |

    Then user is logged in as "Super User (admin)"

  Scenario: Login as admin with cucumber datatable(variant 2)
    When user navigates to open MRS home page
    And user logs in using following data with different table:
      | departmentName | Registration Desk |
      | username       | admin             |
      | password       | Admin123          |

  #  Then user logged in as "Super User (admin)"

  @datatable
  Scenario: Register a patient
    Given user logged in to demo.openmrs.org as admin
    When user registers a new patient with following information:
      | GivenName | FamilyName | Gender | Birthday | BirthMonth | BirthYear | Address     | City    | State | Country | PostalCode | PhoneNumber | RelativeName |
      | Priya     | Khan       | Female | 17       | July       | 1985      | 123 Main st | Chicago | IL    | USA     | 60000      | 12345678    | Reyhan       |
    Then new patient is registered


  @newFormat
  Scenario: Register a patient variant 2
    Given user logged in to demo.openmrs.org as admin
    When user registers a new patient with following information in a new format:
      | GivenName   | Priya      |
      | FamilyName  | Khan       |
      | Gender      | Female     |
      | BirthDay    | 13         |
      | BirthMonth  | 12         |
      | BirthYear   | 1993       |
      | Address     | AustinTX   |
      | City        | Austin     |
      | State       | Texas      |
      | Country     | USA        |
      | PostalCode  | 78748      |
      | PhoneNumber | 5552522525 |

    Then verify new patient is registered


  @outline
  Scenario Outline: Register a patient variant 3
    Given user is logged in to demo.openmrs.org as admin
    When user creates a new patient with following data: "<GivenName>", "<FamilyName>", "<Gender>"
    And with extra information: "<Birthday>", "<BirthMonth>", <BirthYear>
    And with address: "<Address>", "<City>", "<State>", "<Country>", and "<PostalCode>"
    Then new patient has been registered with "<GivenName>" and "<FamilyName>"
    And address of new patient is "<Address>", "<City>", "<State>"

    Examples:
      | GivenName | FamilyName | Gender | Birthday | BirthMonth | BirthYear | Address     | City    | State | Country | PostalCode | PhoneNumber | RelativeName |
      | John      | Smith      | Male   |          | July       | 1985      | 123 Main st | Chicago | IL    | USA     | 60000      | 12345678    | Reyhan       |
      | Priya     | Khan       | Female | 17       | July       | 1985      | 123 Main st | Chicago | IL    | USA     | 60000      | 12345678    | Reyhan       |
      | John      | Smith      | Male   |          | July       | 1985      |             | Chicago | IL    | USA     | 60000      | 12345678    | Reyhan       |
      | Jack      | Green      | Male   | 30       | September  | 1964      |             | Chicago | IL    | USA     | 60000      | 12345678    | Reyhan       |
      | John      | Smith      | Male   |          | July       | 1985      | 1           | Chicago | IL    | USA     | 60000      | 12345678    | Reyhan       |

  @login
  Scenario Outline: Login negative tests
    Given user navigated to demo.openmrs.org
    When user tries to login with "<username>" and "<password>" <location>"
    Then "<error message>" is shown
    And user is still on login page

    Examples:

      | username   | password | location | error message                                |
      | adminnn    | Admin123 | Pharmacy | Invalid username/password. Please try again. |
      | admin      |          | Pharmacy | Invalid username/password. Please try again. |
      |            | Admin123 | Pharmacy | Invalid username/password. Please try again. |
      | techtorial | techno   | Pharmacy | Invalid username/password. Please try again. |
      |            |          | Pharmacy | Invalid username/password. Please try again. |
      | a          | 12345    | Pharmacy | Invalid username/password. Please try again. |
      |            | ##@@!@   | Pharmacy | Invalid username/password. Please try again. |











