/**
 * Created by Dany on 30/05/2017.
 */
import freemarker.template.Configuration;
//import org.apache.velocity.app.Velocity;
//import org.apache.velocity.app.VelocityEngine;
import freemarker.template.TemplateExceptionHandler;
import spark.*;
import spark.template.freemarker.FreeMarkerEngine;
//import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.*;
import static spark.Spark.staticFiles;

public class Main {

    public static void main(String[] args) {

        // Properties p = new Properties();
        // p.setProperty("file.resource.loader.path", "/template");

        // VelocityEngine velocityEngine = new VelocityEngine();
        //velocityEngine.init(p);
        //Velocity.init(p);


       staticFiles.location("/publico");
       Configuration configuration = new Configuration();
       configuration.setClassForTemplateLoading(Main.class, "/template");
       configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
       configuration.setDefaultEncoding("UTF-8");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        get("/", (request, response)->{
            Map<String, Object> model = new HashMap <String, Object>();
            model.put("title", "Welcome");
            return new ModelAndView(model, "welcome.ftl");

                }, freeMarkerEngine);

        get("/estudiante/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap <String, Object>();
            int id=0;
            try{
                id = Integer.parseInt(request.params("id"));
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            try{
                Estudiante.getEstudiantes().remove(Estudiante.getEstudiantes().get(id-1));
            }catch (Exception ex){
                ex.printStackTrace();
            }
            response.redirect("/");
            return null;
        });

        get("/estudiante/agregar", (request, response)->{
           Map<String, Object> model = new HashMap<String, Object>();
           model.put("title", "Agregar estudiante");
           return new ModelAndView(model, "AnadirEstudiante.ftl");
        }, freeMarkerEngine);

        post("/estudiante/agregar",(request, response)->{
            Map<String, Object>model = new HashMap<>();
            int matricula=0;
            String error="";
            try{
                matricula = Integer.parseInt(request.queryParams("matricula"));
            }catch (NumberFormatException ex){
                error="Error al entrar la matricula";
            }
            String apellido = request.queryParams("apellido");
            String nombre = request.queryParams("nombre");
            String telefono = request.queryParams("telefono");
            model.put("title", "Registrar estudiante");


            if(apellido!=null && nombre!=null && telefono!=null && matricula!=0){
                Estudiante estudiante= new Estudiante(matricula, nombre,apellido,telefono);

                Estudiante.setEstudiantes(estudiante);
                response.status(201);
                model.put("nombre", nombre);
                model.put("apellido", apellido);
                model.put("info", "registro");
                response.redirect("/estdiante/listar");
                return "";
            }
            else {
                response.redirect("/estdiante/listar");
                return "";
            }
        });

        get("/estdiante/listar", (request,response)->{
            Map<String, Object>model = new HashMap<String, Object>();
            model.put("title", "Listar Estudiante");
            int count =1;

                Map estud = new HashMap();
                Map<String, Object> lista = new HashMap<String, Object>();

                for(Estudiante estudiante : Estudiante.getEstudiantes()){
                    estud.put("nombre", estudiante.getNombre());
                    estud.put("apellido", estudiante.getApellido());
                    estud.put("matricula", estudiante.getMatricula());
                    estud.put("telefono", estudiante.getTelefono());

                    lista.put(Integer.toString(count), estud);
                            count++;
                            estud=new HashMap();
           }
                model.put("estudiantes", lista);
            return new ModelAndView(model, "ListarEstudiante.ftl");
        }, freeMarkerEngine );


    get("/estudiante/:id/update", (request, response) -> {
        int id=0;
        String id_backup="";

        try{
            id= Integer.parseInt(request.params("id"));
            System.out.println(id);
        }catch (NumberFormatException ex){
            id_backup = request.params("id");
            System.out.println(id_backup);
        }
        Map<String, Object>model = new HashMap<String, Object>();

        Map est = new HashMap();
        est.put("nombre", Estudiante.getEstudiantes().get(id-1).getNombre());
        est.put("apellido", Estudiante.getEstudiantes().get(id-1).getApellido());
        est.put("matricula", Estudiante.getEstudiantes().get(id-1).getMatricula());
        est.put("telefono", Estudiante.getEstudiantes().get(id-1).getTelefono());
        est.put("id", id-1);
        model.put("estudiante", est);
        model.put("title", "Modificar Estudiante");
        return new ModelAndView(model, "ModificarEstudiante.ftl");
    }, freeMarkerEngine);

    post("/estudiante/modificar", ((request, response) -> {
        Map<String, Object>model = new HashMap<>();
        int matricula=0;
        String error="";
        try{
            matricula = Integer.parseInt(request.queryParams("matricula"));
        }catch (NumberFormatException ex){
            error="Error al entrar la matricula";
        }
        String apellido = request.queryParams("apellido");
        String nombre = request.queryParams("nombre");
        String telefono = request.queryParams("telefono");
        int id = Integer.parseInt(request.queryParams("id"));
        model.put("title", "Modificar estudiante");


        if(apellido!=null && nombre!=null && telefono!=null && matricula!=0){

            Estudiante.getEstudiantes().get(id).setTelefono(telefono);
            Estudiante.getEstudiantes().get(id).setNombre(nombre);
            Estudiante.getEstudiantes().get(id).setMatricula(matricula);
            Estudiante.getEstudiantes().get(id).setApellido(apellido);

            response.redirect("/estdiante/listar");
            return "";
        }
        else {
            response.redirect("/estdiante/listar");
           return "";
        }

    }));

    }

}
