/**
 * 
 */
package com.luv2code.springdemo.dao.implementations;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

/**
 * Customer DAO implementation
 * @author Mihai-Tudor Popescu
 *
 */

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.luv2code.sprindemo.dao.CustomerDAO#getCustomers()
	 */
	@Override
	public List<Customer> getCustomers() {
		System.out.println(this.getClass().getSimpleName() + ": Fetching the customers from the database.");

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// create the query and fetch the data
		List<Customer> customers = session.createQuery("from Customer order by lastName, firstName asc", Customer.class).getResultList();

		System.out.println(this.getClass().getSimpleName() + ": Customer list fetched. Size: " + customers.size());

		// return the data
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		System.out.println(this.getClass().getSimpleName() + ": Saving the customer in the database.");

		// get the session
		Session session = sessionFactory.getCurrentSession();
		// save the customer
		session.saveOrUpdate(theCustomer);

		System.out.println(this.getClass().getSimpleName() + ": Customer saved successfully.");
	}

	@Override
	public Customer getCustomer(int id) {
		System.out.println(this.getClass().getSimpleName() + ": Getting the customer with id " + id + " from the database.");
		// get the session
		Session session = sessionFactory.getCurrentSession();
		// fetch the customer
		Customer theCustomer = session.get(Customer.class, id);

		// display the status message
		if (theCustomer != null)
			System.out.println(this.getClass().getSimpleName() + ": Fetched: " + theCustomer);
		else
			System.out.println(this.getClass().getSimpleName() + ": The specified customer was not found.");

		// Return it to the caller
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		System.out.println(this.getClass().getSimpleName() + ": Deleting the customer with id " + id + " from the database.");
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// delete using primary key
		Query q = session.createQuery("delete from Customer where id=:customerId");
		q.setParameter("customerId", id);
		q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		}
		else {
			// theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("from Customer", Customer.class);  
		}

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results        
		return customers;

	}

}
