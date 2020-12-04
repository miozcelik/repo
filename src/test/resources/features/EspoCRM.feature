@espo
Feature: EspoCRM Page Verification

  Scenario:Validating function names
    Given user navigates to "https://demo.espocrm.com/?lang=en_US#"
    When the user opens the home page
    Then the user should see the function names
      | 0    | 1        | 2        | 3     | 4             | 5       | 6      | 7            | 8        | 9        | 10     | 11    | 12       | 13    |
      | Home | Accounts | Contacts | Leads | Opportunities | Reports | Quotes | Sales Orders | Invoices | Products | Emails | Cases | Calendar | Tasks |