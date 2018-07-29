package com.bank.controllers.auth;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;

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
	
	
	public AuthController() {}
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}	
	
	@FXML
	public void loginListener(ActionEvent event){
		String login = loginTextField.getText();
		String password = DigestUtils.shaHex(passwordTextField.getText());
		
		if(isAuth(login, password)) {
			((Stage)loginTextField.getScene().getWindow()).close();
			loadMain();
		}
		else {
			loginTextField.getStyleClass().add("wrong-credentials");
			passwordTextField.getStyleClass().add("wrong-credentials");
		}
	}
	
	@FXML
	public void cancelListener(ActionEvent event){
		System.exit(0);
	}
	
	@FXML
	public void settingsListener(MouseEvent event){
		loadSettings();
	}
	
	void loadMain() {
		try {
			WindowLoader.getWindow().load("/com/bank/views/main.fxml", "SunuBank");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void loadSettings(){
		try {
			WindowLoader.getWindow().load("/com/bank/views/settings.fxml", "Paramètre");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isAuth(String login, String password) {
		return false;
	}


}
