På https://membership.basketballengland.co.uk/NewSupporterAccount 
kan man registrera sig som användare<br>
Här är testfall som testar denna
registreringsfunktion genom automatisering
via Cucumber och Selenium

Testfallen täcker:  <br>
❖ Skapa användare – allt går som förväntat
och ett konto skapas<br>
❖ Skapa användare – efternamn saknas<br>
❖ Skapa användare – lösenord matchar inte<br>
❖ Skapa användare – terms and conditions är
inte godkänt

Verifiering sker på varje scenario med Junit assert<br>
Feature-filen är skapad enligt BDD och innehålla en tydlig beskrivning<br>
Feature-filen är kopplad till Selenium Webdriver-kod som utför testandet
