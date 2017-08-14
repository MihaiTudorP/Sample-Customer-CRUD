/**
 * 
 */
package com.luv2code.springdemo.service.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		System.out.println(this.getClass().getSimpleName() + ": Fetching the customers from the DAO.");
		// get the data set from the DAO(s) and return it
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		System.out.println(this.getClass().getSimpleName() + ": Saving the customer using the DAO.");
		// save the customer using the DAO
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		System.out.println(this.getClass().getSimpleName() + ": Getting a customer by id using the DAO.");
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		System.out.println(this.getClass().getSimpleName() + ": Deleting the customer with id = " + id + " using the DAO.");
		customerDAO.deleteCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		// get the matching customer list from the DAO
		return customerDAO.searchCustomers(theSearchName);
	}
	
}
