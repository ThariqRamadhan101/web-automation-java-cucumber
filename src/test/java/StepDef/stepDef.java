package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class stepDef {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("login page saucedemo")
    public void login_page_saucedemo() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        Thread.sleep(1000);
    }

    @When("input username {string}")
    public void inputUsername(String username) {
        driver.findElement(By.name("user-name")).sendKeys(username);
    }

    @And("input password {string}")
    public void inputPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("click login button")
    public void click_login_button() {
        driver.findElement(By.name("login-button")).sendKeys(Keys.ENTER);
    }

    @Then("user directed to products page")
    public void user_directed_to_products_page() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        driver.close();
        driver.quit();
    }

    @Then("user is showed error message")
    public void user_is_showed_error_message() {
        WebElement button = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        String buttonText = button.getText();

        Assert.assertTrue("Button is not displayed.", button.isDisplayed());
        Assert.assertTrue("Button text does not contain the expected message.", buttonText.contains("Epic sadface: Username and password do not match any user in this service"));

        driver.close();
        driver.quit();
    }

    @Given("user already in page saucedemo")
    public void user_already_in_page_saucedemo() throws InterruptedException {
        login_page_saucedemo();
        inputUsername("standard_user");
        inputPassword("secret_sauce");
        click_login_button();
    }

    @When("click burger button")
    public void click_burger_button() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("click logout button")
    public void click_logout_button() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("user directed to login page")
    public void user_directed_to_login_page() {
        Assert.assertTrue("login button is not displayed.", driver.findElement(By.name("login-button")).isDisplayed());

        driver.close();
        driver.quit();
    }

    @When("click add to cart button")
    public void clickAddToCartButton() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("click cart button")
    public void clickCartButton() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @And("click checkout button")
    public void clickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("fill information form with firstname {string} lastname {string} zippostal code {string}")
    public void fillInformationFormWithFirstnameLastnameZippostalCode(String firstName, String lastName, String postalCode) {
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.name("postalCode")).sendKeys(postalCode);
    }

    @And("click Continue")
    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @And("click Finish")
    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user directed to checkout complete page")
    public void userDirectedToCheckoutCompletePage() {
        Assert.assertTrue("Page does not contain the expected message.",  driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText().contains("Thank you for your order!"));

        driver.close();
        driver.quit();
    }
}
