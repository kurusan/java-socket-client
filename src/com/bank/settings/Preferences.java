package com.bank.settings;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.apache.commons.codec.digest.DigestUtils;

import com.bank.util.AlertHelper;
import com.google.gson.Gson;

public class Preferences {
	
	public static final String CONFIG_FILE = "config.properties";

	String SERVER_ADDRESS;
	int SERVER_PORT;
	
	
	public Preferences() {
		SERVER_ADDRESS = "localhost";
		SERVER_PORT = 55000;
	}

	public String getSERVER_ADDRESS() {
		return SERVER_ADDRESS;
	}


	public void setSERVER_ADDRESS(String sERVER_ADDRESS) {
		SERVER_ADDRESS = sERVER_ADDRESS;
	}


	public int getSERVER_PORT() {
		return SERVER_PORT;
	}


	public void setSERVER_PORT(int sERVER_PORT) {
		SERVER_PORT = sERVER_PORT;
	}
	
	public static void initConfig() {
		Writer writer = null;
		try {
			Preferences preference = new Preferences();
			Gson gson = new Gson();
			writer = new FileWriter(CONFIG_FILE);
			gson.toJson(preference, writer);
		} catch (IOException e) {
			e.printStackTrace();
			Logger.getLogger(Preferences.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				writer.close();
			}catch(IOException e) {
				Logger.getLogger(Preferences.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}
	
	public static Preferences getPreferences() {
		Gson gson = new Gson();
		Preferences preferences = null;
		try {
			preferences = gson.fromJson(new FileReader(CONFIG_FILE), Preferences.class);
		}catch(IOException e) {
			initConfig();
			Logger.getLogger(Preferences.class.getName()).log(Level.SEVERE, null, e);
		}
		return preferences;
	}
	
	public static void setPreferences(Preferences preferences) {
		Writer writer = null;
		try {
			Gson gson = new Gson();
			writer = new FileWriter(CONFIG_FILE);
			gson.toJson(preferences, writer);
			
			AlertHelper.showSimpleAlerte("Effectué", "Paramètre mis à jour!");
		} catch (IOException e) {
			e.printStackTrace();
			Logger.getLogger(Preferences.class.getName()).log(Level.SEVERE, null, e);
			AlertHelper.showErrorMessage("Erreur", "Impossible de sauvegarder le fichier !");
		} finally {
			try {
				writer.close();
			}catch(IOException e) {
				Logger.getLogger(Preferences.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}
	
	
}
