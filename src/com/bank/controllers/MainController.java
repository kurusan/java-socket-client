package com.bank.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.bank.util.WindowLoader;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	@FXML
	private Button agencyButton;
	@FXML
	private Button customerButton;
	@FXML
	private Button accountButton;
	@FXML
	private Button operationButton;
	@FXML
	private MenuItem closeItem;
	@FXML
	private MenuItem settingsItem;
	@FXML
	private MenuItem agencyPannelItem;
	@FXML
	private MenuItem customerPannelItem;
	@FXML
	private MenuItem operationPannelItem;
	@FXML
	private MenuItem accountPannelItem;
	@FXML
	private MenuItem helpItem;
	
	public MainController() {}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initMenuAction();
	}
	
	@FXML
	public void agencyButtonListener() {
		WindowLoader.getWindow().loadAgency();
	}
	@FXML
	public void customerButtonListener() {
		WindowLoader.getWindow().loadCustomer();
	}
	@FXML
	public void accountButtonListener() {
		WindowLoader.getWindow().loadAccount();
	}
	@FXML
	public void operationButtonListener() {
		WindowLoader.getWindow().loadOperation();
	}
	
	public void initMenuAction(){
		closeItem.setOnAction(action -> {
			((Stage)agencyButton.getScene().getWindow()).close();
			WindowLoader.getWindow().loadSignIn();
	    });

		settingsItem.setOnAction(action -> {
			WindowLoader.getWindow().loadSettings();
	    });
		
		agencyPannelItem.setOnAction(action -> {
			WindowLoader.getWindow().loadAgency();
	    });
		
		accountPannelItem.setOnAction(action -> {
			WindowLoader.getWindow().loadAccount();
	    });
		
		operationPannelItem.setOnAction(action -> {
			WindowLoader.getWindow().loadOperation();
	    });
		
		customerPannelItem.setOnAction(action -> {
			WindowLoader.getWindow().loadCustomer();
	    });
		
		helpItem.setOnAction(action -> {
			WindowLoader.getWindow().loadHelp();
	    });

	}
}
