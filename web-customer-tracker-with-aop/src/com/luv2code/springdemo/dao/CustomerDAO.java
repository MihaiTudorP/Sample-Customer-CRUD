/**
 * 
 */
package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

/**
 * DAO interface for retrieving the Customer entities
 * @author Mihai-Tudor Popescu
 *
 */
public interface CustomerDAO {
	/**
	 * Method for retrieving the customers from the db
	 * @return the list of Customer objects from the db
	 */
	public List<Customer> getCustomers();

	/**
	 * Method for saving a customer to the database
	 * @param theCustomer
	 */
	public void saveCustomer(Customer theCustomer);
	
	/**
	 * Method to fetch the customer from the database by id
	 * @param id to look for
	 * @return the fetched Customer object
	 */
	public Customer getCustomer(int id);
	
	/**
	 * Method to delete the customer by id
	 * @param id to look for
	 */
	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String theSearchName);
}
