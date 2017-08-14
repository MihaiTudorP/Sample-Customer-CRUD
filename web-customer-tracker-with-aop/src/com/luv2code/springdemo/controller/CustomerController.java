/**
 * 
 */
package com.luv2code.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject the customer DAO
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get the customers from the DAO
		List<Customer> customers = customerService.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers", customers);
		
		// display the customers
		System.out.println(this.getClass().getSimpleName() + ": Displaying the customer list.");
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		System.out.println(this.getClass().getSimpleName() + ": Displaying the customer adding form.");
		// create the model attribute to bind the form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-add-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		System.out.println(this.getClass().getSimpleName() + ": Inside the saveCustomer method. Customer details: " + theCustomer);
		
		// if the object is not valid, return the user to the input form, otherwise save the customer and return the user to the list
		if (theBindingResult.hasErrors()) {
			System.out.println(this.getClass().getSimpleName() + ": Errors in the received customer data. Returning the user to the form.");
			System.out.println(theBindingResult);
			return "customer-add-form";
		}
		
		System.out.println(this.getClass().getSimpleName() + ": Saving the new customer. Details: " + theCustomer);
		
		// saving the customer using the customer service
		customerService.saveCustomer(theCustomer);
		return "redirect:list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
		System.out.println(this.getClass().getSimpleName() + ": Inside the showFormForUpdate method.");
		
		// get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		// set the customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to the form	
		System.out.println(this.getClass().getSimpleName() + ": Displaying the customer update form.");
		return "customer-add-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		System.out.println(this.getClass().getSimpleName() + ": Inside the deleteCustomer method. Customer id: " + theId);
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:list";
	}
	
	@PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
    }
}
