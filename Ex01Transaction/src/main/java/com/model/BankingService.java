package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bss")
@Transactional
public class BankingService {
	/**
	 * This class is a service class that provides various banking-related
	 * functions. The class has two methods, "doCredit" and "doDebit," both of which
	 * are transactional and annotated with "@Transactional". The "doCredit" method
	 * takes in an account ID and a credit amount and adds the credit amount to the
	 * account's balance. The "doDebit" method takes in an account ID and a debit
	 * amount and subtracts the debit amount from the account's balance. The
	 * "doDebit" method also throws an "InsufficientBalance" exception if the
	 * account does not have enough funds to perform the requested debit
	 * transaction. Overall, this class provides a useful set of banking-related
	 * functions that can be utilized by other components in a larger banking
	 * application. The use of Spring's transactional and dependency injection
	 * features makes this class easier to manage and maintain.Propogation is used
	 * here to control the flow of transactions while performing credit and debit
	 */

	@Autowired
	private AccountsDAO dao;

	@Transactional(propagation = Propagation.MANDATORY)
	public void doCredit(int accountid, int creditamount) throws NegativeValueException, NullException {

		AccountsDTO dto = dao.findByID(accountid);
		if (creditamount < 0) {
			throw new NegativeValueException("Enter a non negative value");
		} else if (creditamount == 0) {
			throw new NullException("Enter a non null value");
		}

		int amount = dto.getAmount();
		int newamount = amount + creditamount;
		System.out.println("Amount credited : " + newamount);
		dto.setAmount(newamount);
		dao.updateUser(dto);
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = { InsufficientBalance.class })
	public void doDebit(int accountid, int debitamount) throws InsufficientBalance {
		AccountsDTO dto = dao.findByID(accountid);
		int amount = dto.getAmount();
		if (amount < debitamount) {
			throw new InsufficientBalance("Not enough money to transfer....");
		}

		int newamount = amount - debitamount;
		System.out.println("Amount debited : " + newamount);
		dto.setAmount(newamount);
		dao.updateUser(dto);
	}
}