package walid.bezi.bankatapp.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import walid.bezi.bankatapp.domains.Account;
import walid.bezi.bankatapp.domains.Client;
import walid.bezi.bankatapp.domains.Currency;

public class AccountTest {

	private Account account;

	@Before
	public void setUp() throws Exception {
		Client client = new Client("1", "pierre-jean");
		account = new Account("1", client, 100, Currency.EUR);
	}

	@Test
	public void testWithdraw10EURFrom100EURAccountShouldReturnAccountWith90EURBalance()
			throws Exception {
		// When
		account.withdraw(10, Currency.EUR);
		// Then
		assertEquals("The final balance should have been 90 euro",
				account.getBalanceValue(), 90, 1);
		assertEquals(account.getBalanceCurrency(), Currency.EUR);
	}

}
