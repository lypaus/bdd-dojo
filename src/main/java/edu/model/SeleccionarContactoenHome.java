package edu.model;

import java.util.HashMap;

public class SeleccionarContactoenHome {
	
	private static final HashMap<String, String> userData = new HashMap<String, String>();
	{
		userData.put("Calendario", "1");
		userData.put("Chat", "2");
	}
	public boolean selccionaOpcion(String Opcion) {
		String passwordInDatabase = userData.get(Opcion);
		return passwordInDatabase.equals(Opcion);
	}

}
