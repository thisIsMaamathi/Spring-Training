package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
/**
 * 
 * @author maamathikrishnan
 *
 */
public class AccountsDTO {
	/**
	 * 
	 * The AccountsDTO class is the data transfer object for accounts containing the
	 * account ID and amount. This class is mapped to the accounts table in the
	 * database using JPA annotations. The class provides getter and setter methods
	 * for the id and amount fields,
	 * 
	 */

	@Id
	private int id;
	private int amount;

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AccountsDTO [id=" + id + ", amount=" + amount + "]";
	}

}
