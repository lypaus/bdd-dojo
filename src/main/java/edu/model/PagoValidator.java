package edu.model;

import java.util.HashMap;

public class PagoValidator {

	private static final HashMap<String, String> userData = new HashMap<String, String>();
	{
		userData.put("1234567890", "edwin");
	}
	
	public boolean validarPago(String numeroTarjeta, String codigo) {
		String codigoInDatabase = userData.get(numeroTarjeta);
		return codigoInDatabase.equals(codigo);
	}
}
