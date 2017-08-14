/**
 * 
 */
package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

/**
 * Customer service definition
 * @author Mihai-Tudor Popescu
 *
 */
public interface CustomerService {
	/**
	 * Method for fetching the customers from the data sources
	 * @return the list of customers
	 */
	public List<Customer> getCustomers();
	
	/**
	 * Method for saving a customer
	 * @param theCustomer
	 */
	public void saveCustomer(Customer theCustomer);
	
	/**
	 * Method for getting a customer by id
	 * @param id to look for
	 * @return the fetched Customer object
	 */
	public Customer getCustomer(int id);
	
	/**
	 * Method for deleting the customer by id
	 * @param id of the customer to delete
	 */
	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String theSearchName);
}
