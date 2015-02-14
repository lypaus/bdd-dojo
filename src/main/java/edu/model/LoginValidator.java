package edu.model;

import java.util.HashMap;

public class LoginValidator {
	
	private static final HashMap<String, String> userData = new HashMap<String, String>();
	{
		userData.put("johana", "12345");
		userData.put("hernando", "12345678");
		userData.put("jorge", "54321");
		userData.put("edwin", "87654321");
	}

	public boolean validar(String nombre, String password) {
		String passwordInDatabase = userData.get(nombre);
		return passwordInDatabase.equals(password);
	}
	
	public boolean validarExiste(String nombre){
		String usuarioInDatabase = userData.get(nombre);
		return !usuarioInDatabase.equals("");
	}

}
