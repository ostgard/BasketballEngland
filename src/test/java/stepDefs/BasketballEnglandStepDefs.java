package stepDefs;

import io.cucumber.java.After;
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

public class BasketballEnglandStepDefs {
    private WebDriver driver;

    public void waitAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
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
        driver.findElement(By.cssSelector("#member_emailaddress")).sendKeys("isak.carlsson@mailmetrash.com");
        driver.findElement(By.cssSelector("#member_confirmemailaddress")).sendKeys("isak.carlsson@mailmetrash.com");

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
        // Wait for success message to appear
        WebElement successMessage = new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.background-gray > h2.bold.gray.text-center.margin-bottom-40")));

        driver.findElement(By.cssSelector("div.background-gray > h2.bold.gray.text-center.margin-bottom-40"));

        // Verify success message is displayed
        assert successMessage.isDisplayed() : "Success message was not displayed";
    }
}