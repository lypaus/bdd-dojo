package edu;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import edu.model.AgendarCita;
import edu.model.LoginValidator;
import edu.model.PagoValidator;
import edu.model.chatonline;
import static spark.Spark.get;
import static spark.Spark.post;

public class Spark {
	
	private static LoginValidator loginValidator= new LoginValidator();
	private static PagoValidator pagoValidator = new PagoValidator();
	private static AgendarCita agendarcita = new AgendarCita();
	private static chatonline chatonline2 = new chatonline();

    public static void main(String[] args) {

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("mensajedeopcion", "Binevenido al home de miAbog.com");
            //model.put("mensajecalendario", "Ingresar los datos del formulario");
            return new ModelAndView(model, "home.wm");
        }, new VelocityTemplateEngine());
        
        get("/calendario", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("titulocalendario", "Agendamiento de citas");
            model.put("mensajecalendario", "Ingresar los datos del formulario");
            return new ModelAndView(model, "calendario.wm");
        }, new VelocityTemplateEngine());
        
        get("/chat", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "chatonline.wm");
        }, new VelocityTemplateEngine());
        
        post("/enviarmensaje", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String mensaje = request.queryParams("mensaje");
            String correo = request.queryParams("correo");
            chatonline2.enviarmensaje(correo, mensaje);
            return new ModelAndView(model, "chatonline.wm");
        }, new VelocityTemplateEngine());
        
        
        post("/resulCita", (request, response) -> {
        	
        	String fecha= request.queryParams("datepicker");
        	String hora = request.queryParams("hora");
        	String correo = request.queryParams("correo");
        	String tema = request.queryParams("correo");
        	
            Map<String, Object> model = new HashMap<>();
            try {
				if(agendarcita.agendarCita(fecha,hora,correo,tema)){
					model.put("confirmarCita", "Su cita ha sido agendada el dia: " + fecha +  "\n hora:" +  hora + ",\n puede verificar esta informacion al correo: " + correo);
				}else{
					model.put("confirmarCita", "Favor ingrese correctamente los datos");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return new ModelAndView(model, "resultCita.wm");
        }, new VelocityTemplateEngine());
        
        
        
    }

}
