package com.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MyService {
	
	@Autowired
	private AccountsDAO dao;
	
	public void doService(int acid, int amount) {
		AccountsDTO dto = dao.findByID(acid);
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