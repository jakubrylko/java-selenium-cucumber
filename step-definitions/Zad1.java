package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Zad1 {

    private Options.Zad1 checkout;

    @Before
    public void setUpScenario() {
        checkout = new Options.Zad1();
    }

    @After
    public void tearDownScenario() {
        checkout = null;
    }

    @Given("the price of a {string} is {int}c")
    public void thePriceOfAIsC(String name, int price) {
        checkout.addItem(name, price);
    }

    @When("I checkout {string} {int}")
    public void iCheckoutApplecount(String name, int count) {
        checkout.scanItems(name, count);
    }

    @Then("the total price should be {int}c")
    public void theTotalPriceShouldBeTotalC(int sumTotal) {
        Assert.assertEquals(sumTotal, checkout.totalCart());
    }

    @Given("empty product list")
    public void emptyProductList() {
        checkout.reset();
    }
}