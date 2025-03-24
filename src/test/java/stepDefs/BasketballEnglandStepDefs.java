package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BasketballEnglandStepDefs {
    private WebDriver driver;

    public void waitAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void assertTrue(String s, boolean b) {
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("Create an account sidan finns")
    public void createAnAccountSidanFinns() {
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        // Verify page is loaded
        waitAndClick(By.xpath("(//form[@id='signup_form'])"));
    }

    @When("Jag fyller i registreringsformularet med giltig information")
    public void jag_fyller_i_registreringsformularet_med_giltig_information() {

        // Fyller i namn
        driver.findElement(By.cssSelector("#member_firstname")).sendKeys("Isak");
        driver.findElement(By.cssSelector("#member_lastname")).sendKeys("Carlsson");

        // Email
        driver.findElement(By.cssSelector("#member_emailaddress")).sendKeys("isak.carlsson16@mailmetrash.com");
        driver.findElement(By.cssSelector("#member_confirmemailaddress")).sendKeys("isak.carlsson16@mailmetrash.com");

        // Password
        driver.findElement(By.cssSelector("#signupunlicenced_password")).sendKeys("AirJordan23!");
        driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword")).sendKeys("AirJordan23!");

        // Checkboxes for terms
        driver.findElement(By.cssSelector("label[for=sign_up_25] > span.box")).click();
        driver.findElement(By.cssSelector("label[for=sign_up_26] > span.box")).click();
        driver.findElement(By.cssSelector("label[for=fanmembersignup_agreetocodeofethicsandconduct] > span.box")).click();

        // Ange Date of birth
        driver.findElement(By.cssSelector("#dp")).sendKeys("26/12/1999");
    }

    @When("Jag klickar pa Confirm and Join knappen")
    public void jagKlickarPaConfirmAndJoinKnappen() {
        // Submit form
        waitAndClick(By.cssSelector("div.form-actions.noborder > input.btn.btn-big.red[type='submit']"));
    }

    @Then("En sida med meddelande om lyckad registrering visas")
    public void enSidaMedMeddelandeOmLyckadRegistreringVisas() {
        // Wait for the red button to appear, synlig på sidan som verifierar en lyckad registrering
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn.red.margin-bottom-20"))
        );
        // Verifiera att knappen är synlig
        assert successMessage.isDisplayed() : "Success message was not displayed";
    }


    @When("Jag fyller i registreringsformularet men utelämnar efternamn")
    public void jagFyllerIRegistreringsformularetMenUtelamnarEfternamn() {
        // Fyller i namn - men utelämnar efternamn
        driver.findElement(By.cssSelector("#member_firstname")).sendKeys("Isak");

        // Email
        driver.findElement(By.cssSelector("#member_emailaddress")).sendKeys("isak6@mailmetrash.com");
        driver.findElement(By.cssSelector("#member_confirmemailaddress")).sendKeys("isak6@mailmetrash.com");

        // Password
        driver.findElement(By.cssSelector("#signupunlicenced_password")).sendKeys("AirJordan23!");
        driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword")).sendKeys("AirJordan23!");

        // Checkboxes for terms
        driver.findElement(By.cssSelector("label[for=sign_up_25] > span.box")).click();
        driver.findElement(By.cssSelector("label[for=sign_up_26] > span.box")).click();
        driver.findElement(By.cssSelector("label[for=fanmembersignup_agreetocodeofethicsandconduct] > span.box")).click();

        // Ange Date of birth
        driver.findElement(By.cssSelector("#dp")).sendKeys("26/12/1999");
    }

    @And("Jag klickar på Registrera-knappen")
    public void jagKlickarPåRegistreraKnappen() {
        // Hitta och klicka på registreringsknappen
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
    }

    @Then("Ett felmeddelande visas om att efternamn krävs")
    public void ettFelmeddelandeVisasOmAttEfternamnKravs() {
        // Vänta på att felmeddelandet visas
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(), 'Last Name is required')]")));

        // Verifiera att felmeddelandet innehåller rätt text
        assert errorMessage.isDisplayed() : "Felmeddelande om efternamn visades inte";
        assert errorMessage.getText().contains("required") : "Felmeddelandet innehåller inte förväntad text: " + errorMessage.getText();
    }


    @When("Jag fyller i registreringsformularet med olika värden i lösenordsfälten")
    public void jagFyllerIRegistreringsformularetMedOlikaVardenILosenordsfalten() {
        // Fyller i namn
        driver.findElement(By.cssSelector("#member_firstname")).sendKeys("Isak");
        driver.findElement(By.cssSelector("#member_lastname")).sendKeys("Carlsson");

        // Email
        driver.findElement(By.cssSelector("#member_emailaddress")).sendKeys("isak.carlsson26@mailmetrash.com");
        driver.findElement(By.cssSelector("#member_confirmemailaddress")).sendKeys("isak.carlsson26@mailmetrash.com");

        // Password
        driver.findElement(By.cssSelector("#signupunlicenced_password")).sendKeys("AirJordan23!");
        driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword")).sendKeys("Air");

        // Checkboxes for terms
        driver.findElement(By.cssSelector("label[for=sign_up_25] > span.box")).click();
        driver.findElement(By.cssSelector("label[for=sign_up_26] > span.box")).click();
        driver.findElement(By.cssSelector("label[for=fanmembersignup_agreetocodeofethicsandconduct] > span.box")).click();

        // Ange Date of birth
        driver.findElement(By.cssSelector("#dp")).sendKeys("26/12/1999");
    }

    @Then("Ett felmeddelande visas om att lösenorden inte stämmer överens")
    public void ettFelmeddelandeVisasOmAttLosenordenInteStammerOverens() {
        // Vänta på att felmeddelandet visas
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span.warning.field-validation-error > span")));

        // Assert textinnehållet i felmeddelandet
        String expectedErrorText = "Password did not match";
        assertEquals("Felmeddelande ska innehålla korrekt text", expectedErrorText, errorMessage.getText());
    }


    @When("Jag fyller i registreringsformularet men markerar inte rutan för användarvillkor")
    public void jagFyllerIRegistreringsformularetMenMarkerarInteRutanForAnvandarvillkor() {
        // Fyller i namn
        driver.findElement(By.cssSelector("#member_firstname")).sendKeys("Isak");
        driver.findElement(By.cssSelector("#member_lastname")).sendKeys("Carlsson");

        // Email
        driver.findElement(By.cssSelector("#member_emailaddress")).sendKeys("isak.carlsson36@mailmetrash.com");
        driver.findElement(By.cssSelector("#member_confirmemailaddress")).sendKeys("isak.carlsson36@mailmetrash.com");

        // Password
        driver.findElement(By.cssSelector("#signupunlicenced_password")).sendKeys("AirJordan23!");
        driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword")).sendKeys("AirJordan23!");

        // Checkboxes for terms

        // Ange Date of birth
        driver.findElement(By.cssSelector("#dp")).sendKeys("26/12/1999");
    }

    @Then("Ett felmeddelande visas om att användarvillkoren måste godkännas")
    public void ettFelmeddelandeVisasOmAttAnvandarvillkorenMasteGodkannas() {
        // Vänta på att felmeddelandet visas
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span.warning.field-validation-error > span")));
        // Assert Kontrollera textinnehållet i felmeddelandet
        String actualErrorText = errorMessage.getText();
        assertTrue("Felmeddelandet ska innehålla text om användarvillkor",
                actualErrorText.toLowerCase().contains("accept")
        );
    }
}