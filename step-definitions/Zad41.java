package Definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zad41 {

    WebDriver driver;

    @Before("@zad41")
    public void setUpScenario() {
        driver = new ChromeDriver();
    }

    @Given("I am on the automationpractice homepage")
    public void onTheHomepage() {
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();

        String expectedUrl = "http://automationpractice.com/index.php";
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, currentUrl);
    }

    @When("I click on the \"Women\" button")
    public void womenButton() {
        WebElement womenButton = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));

        String womenButtonString = womenButton.getText();
        Assertions.assertEquals("WOMEN", womenButtonString);

        womenButton.click();
    }

    @When("I click on the \"Dresses\" button")
    public void dressesButton() {
        WebElement dressesButton = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));

        String dressesButtonString = dressesButton.getText();
        Assertions.assertEquals("DRESSES", dressesButtonString);

        dressesButton.click();
    }

    @When("I click on the \"T-shirts\" button")
    public void tshirtsButton() {
        WebElement tshirtsButton = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a"));

        String tshirtsButtonString = tshirtsButton.getText();
        Assertions.assertEquals("T-SHIRTS", tshirtsButtonString);

        tshirtsButton.click();
    }

    @Then("I can see the {string} section")
    public void categoryHeading(String section) {
        String pageTitle = driver.getTitle();

        Assertions.assertTrue(pageTitle.startsWith(section));
    }

    @After("@zad41")
    public void tearDownScenario() {
        driver.close();
    }
}
