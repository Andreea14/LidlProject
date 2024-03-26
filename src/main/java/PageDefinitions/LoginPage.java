package PageDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
    public WebDriver driver;

    private By agree=By.xpath("//button[@id='onetrust-accept-btn-handler']");
    private By accountClick =By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[1]/div[2]/div/div[1]/nav/ol/li[5]/ol/li[1]/a/span/span");
    private By emailField = By.xpath("//input[@id='field_EmailOrPhone']");
    private By submitButton=By.xpath("//button[@id='button_btn_submit_email']");

    private By passwordBox=By.xpath("//input[@id='field_Email']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By buttonSubmit = By.xpath("//button[@id='button_submit']");
    private By loginButton = By.xpath("//button[@id='button_btn_submit_email']");
    private By errorMessage = By.xpath("//*[@id=\"login-form\"]/div/section/div/div/div[3]/div/div[1]/div[2]/div[2]/p");

     private By forgotPassword=By.xpath("//*[@id=\"login-form\"]/div/section/div/div/div[3]/div/div[1]/div[3]/a");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAgree() {
        driver.findElement(agree).click();
    }

    public void clickAccount() {
        driver.findElement(accountClick).click();
    }
    public void clickEmailBox() {
        driver.findElement(emailField).click();
    }
    public void setEmail(String email) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }
    public void clickNext() {
        driver.findElement(submitButton).click();
    }

    public void clickPasswordBox() {
        driver.findElement(passwordField).click();
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(buttonSubmit).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPassword).click();
    }


}