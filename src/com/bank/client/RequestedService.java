package com.bank.client;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import com.bank.logic.Account;
import com.bank.logic.Agency;
import com.bank.logic.Customer;
import com.bank.logic.Operation;

/**
 * This class performs communication between the client and server by sending serialized objects 
 * and receiving serialized object which it will deserialize to get specific object.
 * Methods are declared on service interfaces which contain more explanation about them.
 * @author kurusan
 *
 */
public class RequestedService implements RequestedServiceI{
	
	private Socket socket;
	
	public RequestedService(Socket socket){
		this.socket = socket;
	}

	@Override
	public void createAgency(Agency agency) {
		try {
			SerializationClass.serialization(socket, "createAgency");
			SerializationClass.serialization(socket, agency);
		} catch (IOException e) {
			
		}
	}

	@Override
	public void createCustomer(Customer customer) {
		try {
			SerializationClass.serialization(socket, "createCustomer");
			SerializationClass.serialization(socket, customer);
		} catch (IOException e) {
			
		}
		
	}

	@Override
	public void createAccount(Account account) {
		try {
			SerializationClass.serialization(socket, "createAccount");
			SerializationClass.serialization(socket, account);
		} catch (IOException e) {
			
		}
	}

	@Override
	public void createOperation(Operation operation) {
		try {
			SerializationClass.serialization(socket, "createOperation");
			SerializationClass.serialization(socket, operation);
		} catch (IOException e) {
			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Agency> getAgencies() {
		try {
			SerializationClass.serialization(socket, "getAgencies");
			return (ArrayList<Agency>)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Customer> getCustomers() {
		try {
			SerializationClass.serialization(socket, "getCustomers");
			return (ArrayList<Customer>)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Account> getAccounts() {
		try {
			SerializationClass.serialization(socket, "getAccounts");
			return (ArrayList<Account>)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Operation> getOperations() {
		try {
			SerializationClass.serialization(socket, "getOperations");
			return (ArrayList<Operation>)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Customer> getCustomersByAgency(String agencyName) {
		try {
			SerializationClass.serialization(socket, "getCustomersByAgency");
			SerializationClass.serialization(socket, "agencyName");
			return (ArrayList<Customer>)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Account> getAccountsByCustomer(String customerID) {
		try {
			SerializationClass.serialization(socket, "getAccountsByCustomer");
			SerializationClass.serialization(socket, "customerID");
			return (ArrayList<Account>)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Operation> getOperationsByAccount(String accountID) {
		try {
			SerializationClass.serialization(socket, "getOperationByAccount");
			SerializationClass.serialization(socket, "accountID");
			return (ArrayList<Operation>)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			
		}
		return null;
	}

	@Override
	public String getAccountStat(String temp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteOrUpdateAgency(String action, Agency agency, String clause) {
		try {
			SerializationClass.serialization(socket, action+"Agency");
			SerializationClass.serialization(socket, agency);
			SerializationClass.serialization(socket, clause);
			return (Integer)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			
		}
		return 0;
	}

	@Override
	public int deleteOrUpdateAccount(String action, Account account, String clause) {
		try {
			SerializationClass.serialization(socket, action+"Account");
			SerializationClass.serialization(socket, account);
			SerializationClass.serialization(socket, clause);
			return (Integer)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			
		}
		return 0;
	}

	@Override
	public int deleteOrUpdateOperation(String action, Operation operation, String clause) {
		try {
			SerializationClass.serialization(socket, action+"Operation");
			SerializationClass.serialization(socket, operation);
			SerializationClass.serialization(socket, clause);
			return (Integer)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			
		}
		return 0;
	}

	@Override
	public int deleteOrUpdateCustomer(String action, Customer customer, String clause) {
		try {
			SerializationClass.serialization(socket, action+"Customer");
			SerializationClass.serialization(socket, customer);
			SerializationClass.serialization(socket, clause);
			return (Integer)SerializationClass.deSerialization(socket);
		} catch (IOException | ClassNotFoundException e) {
			
		}
		return 0;
	}


}
