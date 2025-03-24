Feature: Som ett basket fan vill jag kunna registrera ett medlemsskap hos Basketball England för att komma åt deras medlemssidor


  Background:
    Given Create an account sidan finns

  Scenario: Lyckad registrering av medlemsskap
    When Jag fyller i registreringsformularet med giltig information
    * Jag klickar pa Confirm and Join knappen
    Then En sida med meddelande om lyckad registrering visas

  Scenario: Registrering misslyckas - efternamn saknas
    When Jag fyller i registreringsformularet men utelämnar efternamn
    * Jag klickar pa Confirm and Join knappen
    Then Ett felmeddelande visas om att efternamn krävs


  Scenario: Registrering misslyckas - lösenord matchar inte
    When Jag fyller i registreringsformularet med olika värden i lösenordsfälten
    * Jag klickar pa Confirm and Join knappen
    Then Ett felmeddelande visas om att lösenorden inte stämmer överens


  Scenario: Registrering misslyckas - användarvillkor inte godkända
    When Jag fyller i registreringsformularet men markerar inte rutan för användarvillkor
    * Jag klickar pa Confirm and Join knappen
    Then Ett felmeddelande visas om att användarvillkoren måste godkännas



