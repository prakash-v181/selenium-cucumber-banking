Feature: Baking application
  I want to test banking application

  Background:
    Given User landed on Banking App
    Then User logged in with valid email and password
    
  @UpdateInfo
  Scenario: Update contact information
    Then User navigates to update contact information page
    Then User provides details "FirstName" "LastName" "Address" and "City"
    

 @RequestLoan
  Scenario Outline: Apply for loan
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
  Scenario: Verify Registstion Page
    Then User navigates to Registation information page
    Then User provide detailsss "Fname" "Lname" "Addr" "City" "State" "Zipcode" "PhoneNo" "Snn" "Usrname" "Cpass" and "Rpass"
    
   
   #@OpenNewAccount
   #Scenario: Verify open New Account Page
   #Then User navigates to Open New Account Page
   #User provide details for Open New Account "Account"
    
  #@StageSetUp
  #Scenario: Disabling the Newly added stage in the application
    #Then User navigates to Set Up menu and search for the stage "StageCode" and disable the stage
