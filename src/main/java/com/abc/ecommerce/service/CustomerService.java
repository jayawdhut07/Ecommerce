package com.abc.ecommerce.service;


import java.util.List;

import com.abc.ecommerce.entity.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(int customerId);

	public void deleteCustomer(int customerId);

	public Customer updateCustomer(Customer customer);

}
