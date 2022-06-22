package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Zad2 {

    private Options.Zad2 account;
    private boolean isWithdrawPossible;

    @Before
    public void setUpScenario() {
        isWithdrawPossible = false;
    }

    @After
    public void tearDownScenario() {
        isWithdrawPossible = true;
    }

    @Given ("There is {int} PLN on the account")
    public void startingAccountBalance(int accountBalance) {
        account = new Options.Zad2(accountBalance);
    }

    @When("I withdraw {int} PLN")
    public void moneyWithdraw(int withdraw) {
        isWithdrawPossible = account.withdraw(withdraw);
    }

    @When("I transfer {int} PLN")
    public void transferMoney(int money) {
        account.transfer(money);
    }

    @Then("The operation should not be possible")
    public void withdrawNotPossbile() {
        Assert.assertFalse(isWithdrawPossible);
    }

    @Then("The operation should be possible")
    public void withdrawPossbile() {
        Assert.assertTrue(isWithdrawPossible);
    }

    @Then("The account balance is {int} PLN")
    public void finalAccountBalance(int accountBalance) {
        Assert.assertEquals(accountBalance, account.getAccountBalance());
    }
}
