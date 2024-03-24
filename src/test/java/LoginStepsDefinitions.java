import PageDefinitions.LoginPage;
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

import static org.junit.Assert.assertEquals;

public class LoginStepsDefinitions {

    public WebDriver driver;
    public String baseUrl = "https://www.lidl.de/";
    public LoginPage loginPage;


    @Given("I open the website")
    public void iOpenTheWebsite() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }


    @And("I click on the My account section")
    public void iClickOnTheMyAccountSection() {
        loginPage.clickAgree();
        loginPage.clickAccount();
    }

    @When("I entered the emailAddress")
    public void iEnteredTheEmailAddress() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='field_EmailOrPhone']")));
        loginPage.clickEmailBox();
        loginPage.setEmail("andreea.salavastru14@gmail.com");
    }

    @And("I press Next button")
    public void iPressNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='color_primary size_default mode_block role_next']")));
        loginPage.clickNext();
    }

    @And("I entered the password")
    public void iEnteredThePassword() {
        loginPage.clickPasswordBox();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='field_Password']")));
        loginPage.clickEmailBox();
        loginPage.setPassword("Alfabetic1492!");
    }
    @And("I press Login button")
    public void iPressLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I am logged successfully")
    public void iAmLoggedSuccessfully() {
        String expectedUrl = "https://www.lidl.de/de/my-lidl";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @And("close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }

    @When("I insert the invalidEmailAddress")
    public void iInsertTheInvalidEmailAddress() {
        loginPage.setEmail("test@test.com");
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {

        String expectedErrorMessage = "Diese E-Mail-Adresse gehört zu keinem Lidl Konto. Versuche es erneut oder erstelle ein Konto.\n" +
                "\n";
        loginPage.getErrorMessage();
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }


}