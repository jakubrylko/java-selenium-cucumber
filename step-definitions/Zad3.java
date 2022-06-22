package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zad3 {

    WebDriver driver;

    @Before("@zad3")
    public void setUpScenario() {
        driver = new ChromeDriver();
    }

    @Given("I am on the wikipedia homepage")
    public void onTheHomepage() {
        driver.get("https://www.wikipedia.org");
        driver.manage().window().maximize();
    }

    @When("I type {string} in the search bar")
    public void typeInTheSearchBar(String search) {
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        searchBar.sendKeys(search);
    }

    @And("I click on the magnifier")
    public void clickOnMagnifier() {
        WebElement magnifier = driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i"));
        magnifier.submit();
    }

    @Then("I can see {string} heading")
    public void checkHeading(String heading) {
        WebElement firstHeading = driver.findElement(By.id("firstHeading"));
        Assert.assertTrue(firstHeading.getText().startsWith(heading));
    }

    @After("@zad3")
    public void tearDownScenario() {
        driver.close();
    }
}
