package com.javahongkong.bootcamp.exercise;

public class Transaction implements TransactionInterface {
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank
	 *                      The bank where the account is housed.
	 * @param accountNumber
	 *                      The customer's account number.
	 * @param attemptedPin
	 *                      The PIN entered by the customer.
	 * @throws Exception
	 *                   Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		// complete the function
		if (!bank.getAccount(accountNumber).validatePin(attemptedPin))
			throw new InvalidCredentialsException("Invalid Password!"); //Exception("Invalid Password");
		this.bank = bank;
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		// complete the function
		return this.bank.getAccount(this.accountNumber).getBalance();
	}

	public void credit(double amount) {
		// complete the function
		this.bank.getAccount(this.accountNumber).creditAccount(amount);
	}

	public boolean debit(double amount) {
		// complete the function
		if (this.bank.getAccount(this.accountNumber).getBalance() < amount)
			return false;
		this.bank.getAccount(this.accountNumber).debitAccount(amount);
		return true;
	}
}
