package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Zad43 {

    WebDriver driver;
    Robot robot;

    @Before("@zad43")
    public void setUpScenario() {
        driver = new ChromeDriver();
    }

    @Given("I am on the automationpractice page")
    public void onThePage() {
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();

        String expectedUrl = "http://automationpractice.com/index.php";
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, currentUrl);
    }

    @And("I scroll down to the bottom of the page")
    public void scrollDown() throws AWTException {
        robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    @When("I enter {string} in the newsletter text field")
    public void enterString(String email) {
        WebElement newsletterField = driver.findElement(By.xpath("//*[@id=\"newsletter-input\"]"));
        newsletterField.sendKeys(email);
    }

    @And("I press on the arrow button")
    public void pressArrow() {
        WebElement arrow = driver.findElement(By.xpath("//*[@id=\"newsletter_block_left\"]/div/form/div/button"));
        arrow.click();
    }

    @Then("I can see {string} alert")
    public void seeAlert(String alert) {
        WebElement textAlert = driver.findElement(By.xpath("/html/body/div/div[2]/div/p"));
        String textAlertString = textAlert.getText();

        Assertions.assertTrue(textAlertString.endsWith(alert));
    }

    @After("@zad43")
    public void tearDownScenario() {
        driver.close();
    }
}
