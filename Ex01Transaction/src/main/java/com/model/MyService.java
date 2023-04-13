package com.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyService {
	/**
	 * MyService is a service layer class that manages account-related operations.
	 * It is responsible for updating the amount associated with a specific account.
	 */

	@Autowired
	private AccountsDAO dao;

	public void doService(int accountid, int amount) {
		AccountsDTO dto = dao.findByID(accountid);
		dto.setAmount(amount);
		dao.updateUser(dto);
	}

	public AccountsDAO getDao() {
		return dao;
	}

	public void setDao(AccountsDAO dao) {
		this.dao = dao;
	}

}