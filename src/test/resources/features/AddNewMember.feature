Feature: Som ett basket fan vill jag kunna registrera ett medlemsskap hos Basketball England för att komma åt deras medlemssidor


  Background:
    Given Create an account sidan finns

  Scenario: Lyckad registrering av medlemsskap
    When Jag fyller i registreringsformuläret med giltig information
    Then En sida med meddelande om lyckad registrering visas



    #When Jag fyller i Date of birth genom att ange "26/12/1999"
#    And Jag fyller i First Name "Isak"
 #   * Jag fyller i Last Name "Carlsson"
  #  * Jag fyller i Email Address "isak.carlsson@mailmetrash.com"
   # * och Confirm Email Address "isak.carlsson@mailmetrash.com"
    #* jag väljer ett lösenord "AirJordan23!"
    #* Skriver in mitt lösenord igen "AirJordan23!"
    #* Jag godkänner Terms and Conditions
    #* Jag intygar att jag är över 18 år
    #* Jag godkänner Code of conduct
    #* Jag klickar på Confirm and Join knappen
   # Then En sida med meddelande om lyckad registrering visas



