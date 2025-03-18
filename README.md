På https://membership.basketballengland.co.uk/NewSupporterAccount 
kan man registrera sig som användare
Här är skrivet testfall som testar denna
registreringsfunktion genom automatisering
via Cucumber och Selenium

Testfallen täcker:
❖ Skapa användare – allt går som förväntat
och ett konto skapas
❖ Skapa användare – efternamn saknas
❖ Skapa användare – lösenord matchar inte
❖ Skapa användare – terms and conditions är
inte godkänt

Verifiering sker på varje scenario med Junit assert
Feature-filen är skapad enligt BDD och innehålla en tydlig beskrivning
Feature-filen är kopplad till Selenium Webdriver-kod som utför testandet
