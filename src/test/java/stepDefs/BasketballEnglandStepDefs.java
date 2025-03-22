package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    //        driver.quit();
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
        driver.findElement(By.cssSelector("#member_emailaddress")).sendKeys("isak.carlsson5@mailmetrash.com");
        driver.findElement(By.cssSelector("#member_confirmemailaddress")).sendKeys("isak.carlsson5@mailmetrash.com");

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

//    @When("Jag klickar pa Confirm and Join knappen")
//    public void jagKlickarPaConfirmAndJoinKnappen() {
//        // Submit form
//        waitAndClick(By.cssSelector("div.form-actions.noborder > input.btn.btn-big.red[type='submit']"));
//    }


    @When("Jag klickar pa Confirm and Join knappen")
    public void jag_klickar_pa_confirm_and_join_knappen() {
        // Print URL before clicking
        System.out.println("URL before clicking: " + driver.getCurrentUrl());

        // Submit form
        WebElement submitButton = driver.findElement(By.name("join"));

//        By.cssSelector("input[value='CONFIRM AND JOIN']"));
//        driver.findElement(By.name("join")).click();
        //cssSelector("div.form-actions.noborder > input.btn.btn-big.red[type='submit']"

        System.out.println("Submit button found: " + submitButton.isDisplayed());

        // Try JavaScript click instead
        try {
            submitButton.click();
            System.out.println("Regular click performed");
        } catch (Exception e) {
            System.out.println("Regular click failed: " + e.getMessage());
            // Try JavaScript click as fallback
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
            System.out.println("JavaScript click performed");
        }

        // Wait a moment and print URL after clicking
        try {
            Thread.sleep(3000);
            System.out.println("URL after clicking: " + driver.getCurrentUrl());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("En sida med meddelande om lyckad registrering visas")
    public void enSidaMedMeddelandeOmLyckadRegistreringVisas() {
        // Wait for the red button to appear, which indicates successful registration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn.red.margin-bottom-20"))
        );
        //      (By.cssSelector("h2.bold.gray.text-center.margin-bottom-40")));


        // Verifiera att knappen är synlig
        assert successMessage.isDisplayed() : "Success message was not displayed";

        //        System.out.println("Success message text: " + successMessage.getText());
    }


}