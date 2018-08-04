package com.bank.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.bank.util.WindowLoader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AuthController implements Initializable {
	
	@FXML
	private TextField loginTextField;
	@FXML
	private TextField passwordTextField;
	@FXML
	private Button signinButton;
	@FXML
	private Button paramsButton;
	@FXML
	private Button cancelButton;
	
	boolean connected = false;
	
	public AuthController() {}
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}	
	
	@FXML
	public void loginListener(ActionEvent event){
		
		String login = loginTextField.getText();
		String password = passwordTextField.getText();
		
		new Thread(new Runnable() {
		    public void run() {
		    	if(ClientController.getClient()!=null) {
		    		if(isAuth(login, password)) {
		    			((Stage)loginTextField.getScene().getWindow()).close();
		    			connected = true;
		    		}
		    		else {
		    			loginTextField.getStyleClass().add("wrong-credentials");
		    			passwordTextField.getStyleClass().add("wrong-credentials");
		    		}
		    	}
		    }
		}).start();
		
		if(connected) {
			WindowLoader.getWindow().loadMain();
		}
		else {
			WindowLoader.getWindow().loadSettings();
		}
	}
	
	@FXML
	public void cancelListener(ActionEvent event){
		System.exit(0);
	}
	
	@FXML
	public void settingsListener(MouseEvent event){
		WindowLoader.getWindow().loadSettings();
	}
	
	public boolean isAuth(String login, String password) {
		/*if(client.call().auth(login, password)) {
			return true;
		}
		else{
			return false;
		}*/
		return true;
	}


}
