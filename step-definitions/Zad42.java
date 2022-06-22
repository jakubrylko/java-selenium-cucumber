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

public class Zad42 {

    WebDriver driver;

    @Before("@zad42")
    public void setUpScenario() {
        driver = new ChromeDriver();
    }

    @Given("I am on the automation practice homepage")
    public void onTheHomepage() {
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();

        String expectedUrl = "http://automationpractice.com/index.php";
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, currentUrl);
    }

    @When("I type {string} in the search box")
    public void typeInSearchBox(String search) {
        WebElement searchBox = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]"));
        searchBox.sendKeys(search);
    }

    @And("I click on the magnifier icon")
    public void clickOnMagnifier() {
        WebElement magnifier = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button"));
        magnifier.submit();
    }

    @Then("I can see 'enter keyword' message")
    public void enterKeywordMessage() {
        WebElement enterKeyword = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/p"));
        String enterKeywordString = enterKeyword.getText();

        Assertions.assertEquals("Please enter a search keyword", enterKeywordString);
    }

    @Then("I can see 'no results' message")
    public void noResultsMessage() {
        WebElement noResults = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/p"));
        String noResultsKeyword = noResults.getText();
        String noResultsString = "No results were found for your search";

        Assertions.assertTrue(noResultsKeyword.startsWith(noResultsString));
    }

    @Then("I can see dress list page")
    public void dressList() {
        WebElement productCount = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div[1]/div[2]/div[2]"));
        String productCountString = productCount.getText();

        Assertions.assertTrue(productCountString.startsWith("Showing"));
    }

    @After("@zad42")
    public void tearDownScenario () {
        driver.close();
    }

}
