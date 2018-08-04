package com.bank.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowLoader {
	
	private void load(String location, String title) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource(location)); 
		Stage stage = new Stage(StageStyle.DECORATED);
	    Scene scene = new Scene(parent);
	    stage.setTitle(title);
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
	}
	
	public static WindowLoader getWindow() {
		return new WindowLoader();
	}
	
	public void loadMain() {
		try {
			load("/com/bank/views/main.fxml", "Client - Menu Principal");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadCustomer() {
		try {
			load("/com/bank/views/customer.fxml", "Client - Clients");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadAgency(){
		try {
			load("/com/bank/views/agency.fxml", "Client - Agences");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadAccount() {
		try {
			load("/com/bank/views/account.fxml", "CLient - Comptes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadOperation(){
		try {
			load("/com/bank/views/operation.fxml", "Client - Operations");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadSettings(){
		try {
			load("/com/bank/views/settings.fxml", "Client - Paramètre");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadSignIn(){
		try {
			load("/com/bank/views/auth/signin.fxml", "Client - Se connecter");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadHelp(){
		try {
			load("/com/bank/views/auth/help.fxml", "Client - Aide");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
