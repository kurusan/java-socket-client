package com.bank.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SerializationClass {
	
	static ObjectInputStream objectInputStream;
	static ObjectOutputStream objectOutputStream;
	static DataOutputStream dataOutputStream;
	
	/**
	 * This method will perform the deserialization of all received objects by the client form the server
	 * @param socket
	 * @return Object - which we need to cast to get the specific Type
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deSerialization(Socket socket) throws IOException, ClassNotFoundException {
		objectInputStream = new ObjectInputStream(socket.getInputStream());		
        Object object = objectInputStream.readObject();
		return object;
	}
	
	/**
	 * This method will perform the serialization of all received objects by the client from the server
	 * @param socket
	 * @param object
	 * @throws IOException
	 */
	public static void serialization(Socket socket, Object object) throws IOException {
		objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		objectOutputStream.writeObject(object);
		objectOutputStream.flush();
	}
}
