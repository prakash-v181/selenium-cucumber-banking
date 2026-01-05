Feature: Baking application

  I want to test banking application

    Background:

    Given User landed on Banking App 

    @RegistationpageInfo

    Scenario: Verify Registstion Page

      Then User navigates to Registation information page

      Then User provide detailsss "Fname" "Lname" "Addr" "City" "State" "Zipcode" "PhoneNo" "Snn" "Usrname" "Cpass" and "Rpass"

     Then User updated code in the properties file