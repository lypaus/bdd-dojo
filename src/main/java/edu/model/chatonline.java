package edu.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;



public class chatonline {
	
	
	public boolean enviarmensaje(String correo,String mensaje){
		 //Server s=new Server();
		  //s.ejecutarConexion();
		  //s.escribirDatos(); 
		Cliente c=new Cliente();
		  c.ejecutarConexion();
		  c.escribirDatos(mensaje);
		
		if(isEmail(correo)){
		  return true;
		}return false;
	
	}
	
	public void calculartiempo(){
		JLabel tiempo;
	    boolean cronometroActivo;
	    cronometroActivo = true;
  
    
		    tiempo = new JLabel( "00:00:000" );
	        tiempo.setFont( new Font( Font.SERIF, Font.BOLD, 50 ) );
	        tiempo.setHorizontalAlignment( JLabel.CENTER );
	        tiempo.setForeground( Color.BLUE );
	        tiempo.setBackground( Color.WHITE );
	        tiempo.setOpaque( true );
	        //add( tiempo, BorderLayout.CENTER );
	        
	        Integer minutos = 0 , segundos = 0, milesimas = 0;
	        //min es minutos, seg es segundos y mil es milesimas de segundo
	        String min="", seg="", mil="";
	        try
	        {
	            //Mientras cronometroActivo sea verdadero entonces seguira
	            //aumentando el tiempo
	            while( cronometroActivo )
	            {
	                Thread.sleep( 4 );
	                //Incrementamos 4 milesimas de segundo
	                milesimas += 4;
	                 
	                //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
	                //y las milesimas de segundo de nuevo a 0
	                if( milesimas == 5000 )
	                {
	                	cronometroActivo = false;
	                	 tiempo.setText( "00:00:000" );
	                }
	 
	                //Esto solamente es estetica para que siempre este en formato
	                //00:00:000
	                if( minutos < 1 ) min = "0" + minutos;
	                else min = minutos.toString();
	                if( segundos < 10 ) seg = "0" + segundos;
	                else seg = segundos.toString();
	                 
	                if( milesimas < 10 ) mil = "00" + milesimas;
	                else if( milesimas < 100 ) mil = "0" + milesimas;
	                else mil = milesimas.toString();
	                 
	                //Colocamos en la etiqueta la informacion
	                tiempo.setText( min + ":" + seg + ":" + mil );                
	            }
	        }catch(Exception e){}
	        //Cuando se reincie se coloca nuevamente en 00:00:000
	       
	}

public boolean isEmail(String correo) {
		
		if (correo.matches("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,4}$")){
			return true;
			}else{
			return false;
			}

    }
	
}
