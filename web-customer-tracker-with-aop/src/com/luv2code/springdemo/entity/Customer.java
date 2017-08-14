/**
 * 
 */
package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Column(name="first_name")
	private String firstName;
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	//@Pattern(regexp = "[a-zA-Z0-9.-]@[a-zA-Z0-9.-].[a-zA-Z0-9.-]")
	@Column(name="email")
	private String email;

	/**
	 * No-arg constructor
	 */
	public Customer() {
		System.out.println(this.getClass().getSimpleName() + ": Inside the no-arg constructor. Initialized a new empty entity.");
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Customer(String firstName, String lastName, String email) {
		System.out.println(this.getClass().getSimpleName() + ": Inside the parameter constructor.");
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		System.out.println(this.getClass().getSimpleName() + ": Generated entity - " + this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
