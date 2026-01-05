Feature: Banking application
  I want to test banking application

  Background:
    Given User landed on Banking App
    And User logged in with valid email and password

  @UpdateInfo
  Scenario: Update contact information
    Then User navigates to update contact information page
    Then User provides details "FirstName" "LastName" "Address" and "City"

  @RequestLoan
  Scenario: Apply for loan
    Then User navigates to Request Loan page
    Then User provide details "LoanAmount" and "DownPayment"

  @BillPayInfo
  Scenario: Apply for Bill
    Then User navigates to bill pay information page
    Then User provide detailss "PPayee_Name" "AAddress" "CCity" "SState" "ZZipCode" "PPhone_No" "AAccount" "VVerify_Account" and "AAmount"

  @AccountOverViewInfo
  Scenario: Verify account overview page
    Then User navigates to Accunt Over View page
    Then User enters valid details "Month" and "Type"

  @RegistationpageInfo
  Scenario: Verify Registration Page
    Then User navigates to Registation information page
    Then User provide detailsss "Fname" "Lname" "Addr" "City" "State" "Zipcode" "PhoneNo" "Snn" "Usrname" "Cpass" and "Rpass"
