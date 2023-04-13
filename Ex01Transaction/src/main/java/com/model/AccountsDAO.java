package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("acdo")
public class AccountsDAO {
	/**
	 * Accounts DAO serves as a Data Access Object (DAO) for the AccountsDTO
	 * class.The "SessionFactory" object is auto-wired .The "findByID" method takes
	 * an integer parameter "accountid" that represents the unique identifier of an
	 * "AccountsDTO" object. The method then retrieves the object from the database
	 * using Hibernate's "getCurrentSession" method and returns it.The "updateUser"
	 * method takes an "AccountsDTO" object as a parameter and uses Hibernate's
	 * "persist" method to save any changes made to the object in the database. The
	 * "getFactory" and "setFactory" methods are getter and setter methods for the
	 * "SessionFactory" object. on the whole, this class provides a simple and
	 * efficient way to perform CRUD operations on the "AccountsDTO" class using
	 * Hibernate and Spring.
	 */
	@Autowired
	private SessionFactory factory;

	public AccountsDTO findByID(int accountid) {
		Session session = factory.getCurrentSession();
		AccountsDTO dto = session.get(AccountsDTO.class, Integer.valueOf(accountid));
		return dto;
	}

	public void updateUser(AccountsDTO dto) {
		Session session = factory.getCurrentSession();
		session.persist(dto);
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}