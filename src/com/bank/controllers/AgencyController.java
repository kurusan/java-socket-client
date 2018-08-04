package com.bank.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.bank.logic.Agency;
import com.bank.util.DialogHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class AgencyController implements Initializable {
	
	@FXML
	private StackPane rootPane;
	@FXML
	private TableView<Agency> agencyTableView;
	@FXML
	private TableColumn<Agency, String> nameColumn;
	@FXML
	private TableColumn<Agency, String> addressColumn;
	@FXML
	private TableColumn<Agency, String> actionColumn;
	@FXML
	private TableColumn<Agency, String> IDColumn;
	@FXML
	private TextField idSearchTextField;
	@FXML
	private TextField nameSearchTextField;
	@FXML
	private Text nameText;
	@FXML
	private Text addressText;
	@FXML
	private TextField addNameTextField;
	@FXML
	private TextField addAddressTextField;
	@FXML
	private Button addAgencyButton;
	
	private ObservableList<Agency> data;
	
	
	public AgencyController() {}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(ClientController.getClient()!= null) {
			IDColumn.setCellValueFactory(new PropertyValueFactory<Agency, String>("agID"));
			nameColumn.setCellValueFactory(new PropertyValueFactory<Agency, String>("agName"));
			addressColumn.setCellValueFactory(new PropertyValueFactory<Agency, String>("agAddress"));
			actionColumn.setCellValueFactory(new PropertyValueFactory<Agency, String>(""));
			
			data = getInitialTableData();
			agencyTableView.setItems(data);
		  
			agencyTableView.setVisible(true);
			
		}
		else{
			DialogHelper.showSimpleDialog(rootPane, "Impossible de joindre le serveur!");
		}
	}
	
	@FXML
	public void addAgencyButtonListener() {
		String agName = addNameTextField.getText();
		String agAddress = addNameTextField.getText();
		
		Agency agency = new Agency(agName, agAddress);
		ClientController.getClient().call().createAgency(agency);
		DialogHelper.showSimpleDialog(rootPane, "Agence ajouté!");
	}
	
	@FXML
	public void idSearchListener() {
		String id = idSearchTextField.getText();
		
		ArrayList<Agency> ag = ClientController.getClient().call().getAgencyByID(id);
		if( ag.size() != 0) {
			Iterator<Agency> it = ag.iterator();
			Agency agency;
			while(it.hasNext()) {
				agency = it.next();
				nameText.setText(agency.getAgName());
				addressText.setText(agency.getAgAddress());
			}
		}
	}
	
	@FXML
	public void nameSearchListener() {
		String name = nameSearchTextField.getText();
		ArrayList<Agency> ag = ClientController.getClient().call().getAgencyByName(name);
		if( ag.size() != 0) {
			Iterator<Agency> it = ag.iterator();
			Agency agency;
			while(it.hasNext()) {
				agency = it.next();
				nameText.setText(agency.getAgName());
				addressText.setText(agency.getAgAddress());
			}
		}
	}
	
	private ObservableList<Agency> getInitialTableData() {
		ArrayList<Agency> list = ClientController.getClient().call().getAgencies();
		return (ObservableList<Agency>) FXCollections.observableList(list);
	}

}
