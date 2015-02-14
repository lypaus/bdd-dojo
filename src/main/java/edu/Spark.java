package edu;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import edu.model.AgendarCita;
import edu.model.LoginValidator;
import edu.model.PagoValidator;
import static spark.Spark.get;
import static spark.Spark.post;

public class Spark {
	
	private static LoginValidator loginValidator= new LoginValidator();
	private static PagoValidator pagoValidator = new PagoValidator();
	private static AgendarCita agendarcita = new AgendarCita();

    public static void main(String[] args) {

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("titulocalendario", "Agendamiento de citas");
            model.put("mensajecalendario", "Ingresar los datos del formulario");
            return new ModelAndView(model, "calendario.wm");
        }, new VelocityTemplateEngine());
        
        
        post("/resulCita", (request, response) -> {
        	
        	String fecha= request.queryParams("datepicker");
        	String hora = request.queryParams("hora");
        	String correo = request.queryParams("correo");
        	String tema = request.queryParams("correo");
        	
            Map<String, Object> model = new HashMap<>();
            if(agendarcita.agendarCita(fecha,hora,correo,tema)){
            	model.put("confirmarCita", "Su cita ha sido agendada el dia" + fecha +  " hora:" +  hora + ", puede verificar esta informacion al correo: " + correo);
            }
            return new ModelAndView(model, "resultCita.wm");
        }, new VelocityTemplateEngine());
        

        post("/login", (request, response) -> {
        	
        	String usuario = request.queryParams("usuario");
        	String password = request.queryParams("password");
        	
            Map<String, Object> model = new HashMap<>();
            if(loginValidator.validar(usuario, password)){
            	model.put("saludo", "Bienvenido a MiAbog.com, " + usuario);
            }
            return new ModelAndView(model, "login.wm");
        }, new VelocityTemplateEngine());
        
        
        	post("/pago", (request, response) -> {
        	
        	String usuario = "edwin";
        	String password = "87654321";
        	
            Map<String, Object> model = new HashMap<>();
            if(loginValidator.validar(usuario, password)){
            	model.put("saludo", "Bienvenido a MiAbog.com, " + usuario);
            }
            return new ModelAndView(model, "pago.wm");
        }, new VelocityTemplateEngine());
        	
        	
        	post("/confirmar", (request, response) -> {
            	
            String numero = request.queryParams("numeroP");
            String codigo = request.queryParams("codigoP");
            	
            Map<String, Object> model = new HashMap<>();
            if(pagoValidator.validarPago(numero,codigo)){
                model.put("saludo2", "El pago se ha realizado exitosamente" );
            }
            return new ModelAndView(model, "resultPago.wm");
            }, new VelocityTemplateEngine());
        	
        
        	
        	post("/crearUsuario", (request, response) -> {
            		
            Map<String, Object> model = new HashMap<>();
            
            return new ModelAndView(model, "crearUsuario.wm");
            }, new VelocityTemplateEngine());
        	
        	
        	
        	post("/confirmarCrear", (request, response) -> {
            	
        		String usuario = request.queryParams("usuarioC");
        		String password = request.queryParams("passwordC");
        		
                Map<String, Object> model = new HashMap<>();
                if(loginValidator.validar(usuario, password)){
                    model.put("saludo3", "Usuario Creado Corretamente, "+usuario );
                }
                return new ModelAndView(model, "resultCrear.wm");
                }, new VelocityTemplateEngine());

    }
    
    /**
    get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("welcome", "Bienvenido a MiAbog.com el mejor sitio de asesorias");
        return new ModelAndView(model, "index.wm");
    }, new VelocityTemplateEngine());

    post("/login", (request, response) -> {
    	
    	String usuario = request.queryParams("usuario");
    	String password = request.queryParams("password");
    	
        Map<String, Object> model = new HashMap<>();
        if(loginValidator.validar(usuario, password)){
        	model.put("saludo", "Bienvenido a MiAbog.com, " + usuario);
        }
        return new ModelAndView(model, "login.wm");
    }, new VelocityTemplateEngine());
    
    
    	post("/pago", (request, response) -> {
    	
    	String usuario = "edwin";
    	String password = "87654321";
    	
        Map<String, Object> model = new HashMap<>();
        if(loginValidator.validar(usuario, password)){
        	model.put("saludo", "Bienvenido a MiAbog.com, " + usuario);
        }
        return new ModelAndView(model, "pago.wm");
    }, new VelocityTemplateEngine());
    	
    	
    	post("/confirmar", (request, response) -> {
        	
        String numero = request.queryParams("numeroP");
        String codigo = request.queryParams("codigoP");
        	
        Map<String, Object> model = new HashMap<>();
        if(pagoValidator.validarPago(numero,codigo)){
            model.put("saludo2", "El pago se ha realizado exitosamente" );
        }
        return new ModelAndView(model, "resultPago.wm");
        }, new VelocityTemplateEngine());
    	
    
    	
    	post("/crearUsuario", (request, response) -> {
        		
        Map<String, Object> model = new HashMap<>();
        
        return new ModelAndView(model, "crearUsuario.wm");
        }, new VelocityTemplateEngine());
    	
    	
    	
    	post("/confirmarCrear", (request, response) -> {
        	
    		String usuario = request.queryParams("usuarioC");
    		String password = request.queryParams("passwordC");
    		
            Map<String, Object> model = new HashMap<>();
            if(loginValidator.validar(usuario, password)){
                model.put("saludo3", "Usuario Creado Corretamente, "+usuario );
            }
            return new ModelAndView(model, "resultCrear.wm");
            }, new VelocityTemplateEngine());
            

}
*/

}
