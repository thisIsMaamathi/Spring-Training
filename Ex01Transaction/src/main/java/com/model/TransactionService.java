package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("tss")
@Transactional
public class TransactionService {
/**
 * The class "TransactionService" is a service layer class that provides the functionality of money transfer between two bank accounts.
The class has a dependency on "BankingService" which is autowired using the "@Autowired" annotation.
The "moneyTransfer" method transfers the specified amount from one account to another by performing credit and debit transactions using the "doCredit" and "doDebit" methods of the "bank" object respectively.
The propagation attribute controls 
If there is insufficient balance in the debit account, then the method will throw the "InsufficientBalance" exception.

 */
	@Autowired
	private BankingService bank;

	public BankingService getBss() {
		return bank;
	}

	public void setBss(BankingService bank) {
		this.bank = bank;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void moneyTransfer(int creditid, int debitid, int amount) throws InsufficientBalance,NullException,NegativeValueException {
		bank.doCredit(creditid, amount);
		bank.doDebit(debitid, amount);
	}
}