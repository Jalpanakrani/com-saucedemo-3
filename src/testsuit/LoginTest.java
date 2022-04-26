package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValid() {
        //Enter valid username
        //WebElement username = driver.findElement(By.id("user-name"));
        clickOnElement(By.id("user-name"));
        //sending field invalid username
        sendTextToElement(By.name("user-name"), "user-name");
        // Find the invalid password field element
        clickOnElement(By.name("password"));
        //Sending invalid Password to password field element
        sendTextToElement(By.name("user-name"), "secret_sauce");
        //find login button and click on LoginInButton
        clickOnElement(By.linkText("login-button"));
        //This is from requirement
        String expectedMessage = "PRODUCTS";
        //find the PRODUCTS text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        //validate actual and expected message
        org.junit.Assert.assertEquals("Not navigagte to login page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductAreDisplayedOnPage() {
        //Enter valid username
        //WebElement username = driver.findElement(By.id("user-name"));
        //sending field invalid username
        //username.sendKeys("standard_user");
        clickOnElement(By.id("user-name"));
        // Find the invalid password field element
        // WebElement passwordField = driver.findElement(By.name("password"));
        //     Sending invalid Password to password field element
        // passwordField.sendKeys("secret_sauce");
        clickOnElement(By.name("password"));
        sendTextToElement(By.name("password"), "secret_sauce");
        //find login button and click on LoginInButton
        // WebElement LoginInbutton = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        // LoginInbutton.click();

        //This is from requirement
        String expectedMessage = "6 Products are displayed on the page";
        //invalid email or password text element and get the text
        // WebElement actualMessageElement = driver.findElement(By.xpath("//div[@id='']"));
        // String actualMessage = actualMessageElement.getText();
        // System.out.println(actualMessage);
        String actualMessage = getTextFromElement(By.xpath("//div[@id='']"));
        //validate actual and expected message
        Assert.assertEquals("Products p0age", expectedMessage, actualMessage);

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = getTextFromElement(By.className("button button-primary g-recaptcha"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


