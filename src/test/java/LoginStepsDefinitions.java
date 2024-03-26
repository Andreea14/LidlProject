import PageDefinitions.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        loginPage.clickPasswordBox();
        loginPage.setPassword("Alfabetic1492!");
    }
    @And("I press Login button")
    public void iPressLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I am logged successfully")
    public void iAmLoggedSuccessfully() {
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, driver.getCurrentUrl());
        System.out.println("Login successfully");
    }

    @And("close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }

    @When("I insert the invalidEmailAddress")
    public void iInsertTheInvalidEmailAddress() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='field_EmailOrPhone']")));
        loginPage.clickEmailBox();
        loginPage.setEmail("test123@test.com");
    }

    @When("I insert the invalid password")
    public void iInsertTheInvalidPassword() {
        loginPage.clickPasswordBox();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='field_Password']")));
        loginPage.setPassword("test2334");
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-form\"]/div/section/div/div/div[3]/div/div[1]/div[2]/div[2]/p")));
        String expectedErrorMessage = "Falsches Passwort. Versuche es erneut oder tippe auf \"Passwort vergessen\", um es zu ändern.";
        loginPage.getErrorMessage();
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Then("check the error message displayed")
    public void checkTheErrorMessageDisplayed() {
        String expectedErrorMessageEmpty = "E-Mail oder Handynummer sind erforderlich.";
        loginPage.getErrorMessage();
        assertEquals(expectedErrorMessageEmpty, loginPage.getErrorMessage());
    }

    @And("I press Forgot password button")
    public void iPressForgotPasswordButton() {
        loginPage.clickForgotPasswordButton();
    }
}