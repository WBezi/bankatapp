package walid.bezi.bankatapp.functionnal;
import static org.junit.Assert.assertEquals;
import walid.bezi.bankatapp.domains.Account;
import walid.bezi.bankatapp.domains.Client;
import walid.bezi.bankatapp.domains.Currency;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioWithdrawMoneyFromAccount {
	private Account currentAccount;

	@Given("^an existing client named \"(.*)\" with (\\d+\\.\\d+) (.*) in his account$")
	public void initAccount(String userName, double totalMoney,
			Currency currency) throws Throwable {
		Client client = new Client("1", userName);
		currentAccount = new Account("1", client, totalMoney, currency);
	}

	@When("^he withdraws (\\d+\\.\\d+) (.*) from his account$")
	public void clientWithdraws(double moneyWithdraw, Currency currency)
			throws Throwable {
		currentAccount.withdraw(moneyWithdraw, currency);
	}

	@Then("^the new balance is (\\d+\\.\\d+) (.*)$")
	public void verifyNewBalance(double balanceToVerify, Currency currency)
			throws Throwable {
		assertEquals(currentAccount.getBalanceValue(), balanceToVerify,1);
		assertEquals(currentAccount.getBalanceCurrency(), currency);
	}
}
