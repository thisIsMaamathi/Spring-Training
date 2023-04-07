package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bss")
@Transactional
public class BankingService {
	
	@Autowired
	private AccountsDAO dao;
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void doCredit(int acid, int cramt) {
		AccountsDTO dto=dao.findByID(acid);
		int amt=dto.getAmount();
		int newamt=amt+cramt;
		System.out.println("Amount credited : " + newamt);
		dto.setAmount(newamt);
		dao.updateUser(dto);
	}
	
	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = {InsufficientBalance.class})
	public void doDebit(int acid,int dramt)throws InsufficientBalance {
		AccountsDTO dto=dao.findByID(acid);
		int amt=dto.getAmount();
		if(amt<dramt) {
			throw new InsufficientBalance("Not enough money to transfer....");
		}
		int newamt=amt-dramt;
		System.out.println("Amount debited : " + newamt);
		dto.setAmount(newamt);
		dao.updateUser(dto);
	}
}