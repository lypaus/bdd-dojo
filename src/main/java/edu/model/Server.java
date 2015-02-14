package edu.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Server{
 /**
  * @param args
  * @throws IOException 
  */
 
 private Socket s;
 private ServerSocket ss;
 private DataInputStream ois=null;
 private DataOutputStream oos=null; 
 Scanner teclado=new Scanner(System.in);
 
 public void ejecutarConexion() {
  Thread t=new Thread(new Runnable(){
   @Override
   public void run() {
    // TODO Auto-generated method stub
    while(true){
     try {
      levantarConexion();//Levantamos
      flujos();//Abrimos flujos
            recibirDatos();//Recibimos datos
     }finally{
      cerrarConexion();//Cerramos conexiones
     }
    }
   }
   
  });t.start();
 }
 
 public void levantarConexion() {
     try{
      ss=new ServerSocket(5050);//Creamos el ServerSocket
  }catch(BindException be){
   mostrarTexto("El servicio ya esta en funcionamiento....\n");
   System.exit(0);
  }catch(UnknownHostException uhe){
   mostrarTexto("Host Desconocido \n");
   System.exit(0);
  } catch (IOException e) {
   // TODO Auto-generated catch block
   mostrarTexto("Error al crear el Servidor");
   System.exit(0);
  }
  mostrarTexto("Esperando conexión entrante....\n");
  try {
   s=ss.accept();//Aceptamos conexiones
  } catch (IOException e) {
   // TODO Auto-generated catch block
   mostrarTexto("Error al aceptar al cliente");
  }
  mostrarTexto("Conexión establecida con :"+s.getInetAddress().getHostName()+"\n");
 }
 
 public void flujos() {
  try {
   ois=new DataInputStream(s.getInputStream());//Abro el flujo de entrada
   oos=new DataOutputStream(s.getOutputStream());//Abro el flujo de salida
   oos.flush();//limpio el flujo
  } catch (IOException e) {
   // TODO Auto-generated catch block
   mostrarTexto("Error en la apertura de flujos");
  }
 }
 
 public void recibirDatos()  {
  String st="";
   try {
    do{
     st=(String)ois.readUTF();//Leo y almaceno los datos que me envian
     if(!st.equals("CLIENTE: fin"))mostrarTexto(st+"\n");//Muestro por pantalla
    }while(!st.equals("CLIENTE: fin"));
   } catch (IOException e) {
    // TODO Auto-generated catch block
    cerrarConexion();
   }
 }
 
 public void enviar(String s){
  try {
   oos.writeUTF("SERVER: "+s);//Mando los datos al cliente
   oos.flush();//Limpio el flujo de salida
  } catch (IOException e) {
   // TODO Auto-generated catch block
   mostrarTexto("Se ha producido un error al enviar los datos....\n");
  }
 }
 
 public void mostrarTexto( String s){
  System.out.print(s);
 }
 
 public void cerrarConexion() {
  try {
   ois.close();//Cierro el flujo de entrada
   oos.close();//Cierro el flujo de salida
   s.close();//Cierro el Socket
   mostrarTexto("Conversación finalizada....\n");
   System.exit(0);
  } catch (IOException e) {
   // TODO Auto-generated catch block
   mostrarTexto("Conversación finalizada....\n");
   System.exit(0);
  }
 }
 public void escribirDatos(){
  while(true){
   enviar(teclado.nextLine());//Mando los datos leidos por teclado
  }
 }
 public static void main(String[] args) throws IOException {
  // TODO Auto-generated method stub
  Server s=new Server();
  s.ejecutarConexion();
  s.escribirDatos();
 }
}
