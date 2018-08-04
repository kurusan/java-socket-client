package com.bank.controllers;

import java.io.IOException;

import com.bank.client.Client;

public class ClientController {
	
	private static Client client = null;
	
	public static Client getClient() {
		if(client == null) {
			try {
				return client = new Client();
			} catch (IOException e) {
				return null;
			}
		}
		else return client;
	}
}
