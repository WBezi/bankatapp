package walid.bezi.bankatapp.domains;

import walid.bezi.bankatapp.exceptions.CurrencyException;
import walid.bezi.bankatapp.exceptions.IllegalAmountException;
import walid.bezi.bankatapp.exceptions.InsufficientlyProvisionnedAccountException;

/**
 * 
 * @author Walid.BEZI
 * 
 */
public class Account {
	private final String id;
	private final Client client;

	private double balance;
	private final Currency currency;

	public Account(String id, Client client, double initBalance,
			Currency initCurrency) {
		this.id = id;
		this.client = client;
		this.balance = initBalance;
		this.currency = initCurrency;
	}

	public String getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public double getBalanceValue() {
		return balance;
	}

	public Currency getBalanceCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return "Account of " + client.getName() + " with id " + id
				+ " has a current balance of " + balance + " "
				+ currency.name();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Account account = (Account) o;
		return id.equals(account.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	/**
	 * Withdraw money from balance if withdrawCurrency is the same as the
	 * account currency
	 * 
	 * @param moneyToWithdraw
	 * @param withdrawCurrency
	 * @throws CurrencyException
	 */
	public void withdraw(double moneyToWithdraw, Currency withdrawCurrency)
			throws CurrencyException {
		if (withdrawCurrency != currency) {
			throw new CurrencyException("Account " + id + " current: "
					+ balance + " " + currency + " - " + " withdraw: "
					+ moneyToWithdraw + " " + currency);
		}
		validate(moneyToWithdraw);
		assertAccountSufficientlyProvisionned(balance, moneyToWithdraw);
		balance = balance - moneyToWithdraw;
	}

	public void validate(double moneyToWithdraw) {
		if (moneyToWithdraw < 0)
			throw new IllegalAmountException();
	}

	private void assertAccountSufficientlyProvisionned(double amount,
			double moneyToWithdraw) {
		if (amount < moneyToWithdraw)
			throw new InsufficientlyProvisionnedAccountException();
	}
}