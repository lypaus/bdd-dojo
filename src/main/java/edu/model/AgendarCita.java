package edu.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgendarCita {

	
	private static final HashMap<String, String> userData = new HashMap<String, String>();
	{
		userData.put("johana", "12345");
		userData.put("hernando", "12345678");
		userData.put("jorge", "54321");
		userData.put("edwin", "87654321");
	}

	public boolean agendarCita(String fecha, String hora,String correo, String tema){
		if (fecha.equals("") || hora.equals("") || correo.equals("") || tema.equals("") ){
			return false;
		} else {
			
			if(isFechaValida(fecha) && isHoraValida(hora)){
				if(isEmail(correo)){
				return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
			
		}
		
	}
	
	public static boolean isFechaValida(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	
	public static boolean isHoraValida(String hora) {
        try {
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm", Locale.getDefault());
            formatoHora.setLenient(false);
            formatoHora.parse(hora);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	
	public boolean isEmail(String correo) {
		
		if (correo.matches("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,4}$")){
			return true;
			}else{
			return false;
			}

    }
}
