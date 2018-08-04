package com.bank.client;

import java.util.List;

import com.bank.logic.Account;
import com.bank.logic.Agency;
import com.bank.logic.Customer;
import com.bank.logic.Operation;


public interface RequestedServiceI {
	
	public boolean auth(String login, String password);
	
	/* These four methods are called when creation is required*/
	/**
	 * Call this method when created Agency is needed
	 * @param agency
	 */
	public void createAgency(Agency agency);
	
	/**
	 * Call this method when created Customer is needed
	 * @param customer
	 */
	public void createCustomer(Customer customer);
	
	/**
	 * Call this method when created Account is needed
	 * @param account
	 */
	public void createAccount(Account account);
	
	/**
	 * Call this method when created Operation is needed
	 * @param operation
	 */
	public void createOperation(Operation operation);
	
	/* These methods are called when select is required*/
	public List <Agency> getAgencies();
	
	public List <Customer> getCustomers();
	
	public List <Account> getAccounts();
	
	public List <Operation> getOperations();

	public List <Customer> getCustomersByAgency(String agencyName);
	
	public List <Agency> getAgencyByID(String agencyID);
	
	public List <Agency> getAgencyByName(String agencyName);

	public List <Account> getAccountsByCustomer(String customerID);
	
	public List <Operation> getOperationsByAccount(String accountID);

	public String getAccountStat(String temp);
	
	public int deleteOrUpdateAgency( String action, Agency agency, String clause);
	
	public int deleteOrUpdateAccount(String action, Account account, String clause);
	
	public int deleteOrUpdateOperation(String action,Operation operation, String clause);
	
	public int deleteOrUpdateCustomer(String action, Customer customer, String clause);
	

}
