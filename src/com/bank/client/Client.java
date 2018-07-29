package com.bank.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

import com.bank.logic.Account;
import com.bank.logic.Agency;
import com.bank.logic.Customer;
import com.bank.logic.Operation;

public class Client {
	
public Socket socket;
private static RequestedService requestedService;
	
	/**
	 * Client constructor method. The constructor will initialize the socket parameter 
	 * by calling configuration file. Then instantiate requested service class to be allowed 
	 * to call service methods.
	 */
	public Client() {
		try {
			
			/* Retrieve properties file */
			Properties prop = new Properties();
			prop.load((InputStream)new FileInputStream("config.properties"));	
			
			socket = new Socket(prop.getProperty("SERVER_ADDRESS"),
								Integer.parseInt(prop.getProperty("SERVER_PORT")));
			requestedService = new RequestedService(socket);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/**
	 * 
	 * @author Kurusan
	 * This internal class contain client needed method to call from the requested service class
	 * Its internal to this class because we needed to join it to the client class for more eloquence. :)
	 *
	 */
	public class  Call {
		
		public void createAgency(Agency agency) {
			Client.requestedService.createAgency(agency);
		}
		
		public void createCustomer(Customer customer) {
			Client.requestedService.createCustomer(customer);
		}
		
		public void createOperation(Operation opration) {
			Client.requestedService.createOperation(opration);
		}
		
		public void createAccount(Account account) {
			Client.requestedService.createAccount(account);
		}
		
		public ArrayList<Agency> getAgencies(){
			return Client.requestedService.getAgencies();
		}
		
		public ArrayList<Account> getAccounts(){
			return Client.requestedService.getAccounts();
		}
		
		public ArrayList<Operation> getOperations(){
			return Client.requestedService.getOperations();
		}
		
		public ArrayList<Customer> getCustomers(){
			return Client.requestedService.getCustomers();
		}
		
		public int deleteOrUpdateCustomer(String action, Customer customer, String clause) {
			return Client.requestedService.deleteOrUpdateCustomer(action, customer, clause);
		}
		
		public int deleteOrUpdateAgency(String action, Agency agency, String clause) {
			return Client.requestedService.deleteOrUpdateAgency(action, agency, clause);
		}
		
		public int deleteOrUpdateAccount(String action, Account account, String clause) {
			return Client.requestedService.deleteOrUpdateAccount(action, account, clause);
		}
		
		public int deleteOrUpdateOperation(String action, Operation operation, String clause) {
			return Client.requestedService.deleteOrUpdateOperation(action, operation, clause);
		}
	}
	
	/**
	 * 
	 * @return new Call - which is client internal call class
	 */
	public Call call() {
		return new Call();
	}
	
}
