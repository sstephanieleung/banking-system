package com.javahongkong.bootcamp.exercise;

import java.util.LinkedHashMap;

public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts; // object reference

	private static long serialAccountNumber = 0;

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		return this.accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		CommercialAccount newCompany = new CommercialAccount(company,serialAccountNumber++, pin,
				startingDeposit);
		this.accounts.put(newCompany.getAccountNumber(), newCompany);
		return newCompany.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		ConsumerAccount newConsumer = new ConsumerAccount(person, serialAccountNumber++, pin, startingDeposit);
		this.accounts.put(newConsumer.getAccountNumber(), newConsumer);
		return newConsumer.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		if (!this.accounts.containsKey(accountNumber))
			return false;
		return this.accounts.get(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		if (!this.accounts.containsKey(accountNumber))
			return -1.0d;
		return this.accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		if (this.accounts.containsKey(accountNumber))
			this.accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		if (!this.accounts.containsKey(accountNumber))
			return false;
		if(this.accounts.get(accountNumber).getBalance() < amount)
			return false;
		this.accounts.get(accountNumber).debitAccount(amount);
		return true;
	}
}
