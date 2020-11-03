import models.AnimalRanger;
import models.Endangered;
import models.NonEndangered;
import models.Sightings;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import models.Animal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.*;

public class App{
    static int getHerokuAssignedPort(){
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null){
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args) {
       // System.out.println("Nafanya Kazi!");

        staticFileLocation("/public");
        port(getHerokuAssignedPort());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sightings> allSightings = Sightings.all();
            model.put("sightings", allSightings);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("endangered", Endangered.all());
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/nonendangered", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nonendangered", NonEndangered.all());
            return new ModelAndView(model, "nonendangered.hbs");
        },new HandlebarsTemplateEngine());

        get("/location/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", Sightings.all());
            return new ModelAndView(model, "location-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/location/new", (request, response) -> {
            Map<String, Object>model = new HashMap<>();
            String rangerName = request.queryParams("rangerName").trim();
            String animalName = request.queryParams("animalName").trim();
            String animalAge = request.queryParams("animalAge").trim();
            String animalHealth = request.queryParams("animalHealth").trim();
            String location = request.queryParams("location").trim();
            String animalType = request.queryParams("animalType").trim();

            AnimalRanger newRanger = new AnimalRanger(rangerName);
            newRanger.save();

            if(animalType.equalsIgnoreCase("Endangered")){
                Endangered endangeredAnimal = new Endangered(animalName, animalHealth,animalAge);
                endangeredAnimal.save();
                Sightings newSightings = new Sightings(endangeredAnimal.getName(), newRanger.getId(),location);
                newSightings.save();
            }else{
                NonEndangered nonEndangered = new NonEndangered(animalName,animalHealth,animalAge);
                nonEndangered.save();
                Sightings newSightings = new Sightings(nonEndangered.getName(), newRanger.getId(), location);
                newSightings.save();
            }
            return new ModelAndView(model, "complete.hbs");

        }, new HandlebarsTemplateEngine());

        get("/location", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("location", Sightings.all());
            return  new ModelAndView(model, "location.hbs");
        }, new HandlebarsTemplateEngine());

        get("/location/:location/details", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String filter = request.params("location");
            model.put("location", filter);
            model.put("sightings", Sightings.getAllSightingsInLocation(filter));
            return new ModelAndView(model, "location-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/rangers/:id/details", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(request.params("id"));
            AnimalRanger foundRanger = AnimalRanger.find(id);
            List<Sightings> mySightings = foundRanger.mySightings();
            model.put("rangers", foundRanger);
            model.put("sightings", mySightings);
            return new ModelAndView(model, "rangers-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/rangers", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("rangers", AnimalRanger.all());
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        get("rangers/:id/location/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(request.params("id"));
            AnimalRanger specificRanger = AnimalRanger.find(id);
            model.put("specificRanger", specificRanger);
            model.put("sightings", Sightings.all());
            return  new ModelAndView(model, "location-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/rangers/:id/location/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(request.params("id"));
            AnimalRanger specificRanger = AnimalRanger.find(id);
            String animalName = request.queryParams("animalName").trim();
            String animalAge = request.queryParams("animalAge").trim();
            String animalHealth = request.queryParams("animalHealth").trim();
            String location = request.queryParams("location").trim();
            String animalType = request.queryParams("animalType").trim();

            if (animalType.equalsIgnoreCase("Endangered")){
                Endangered endangered = new Endangered(animalName, animalHealth, animalAge);
                endangered.save();
                Sightings newSightings = new Sightings(endangered.getName(), specificRanger.getId(), location);
                newSightings.save();
            }else{
                NonEndangered nonEndangered = new NonEndangered(animalName, animalHealth, animalAge);
                nonEndangered.save();
                Sightings newSightings = new Sightings(nonEndangered.getName(), specificRanger.getId(), location);
                newSightings.save();
            }
            return new ModelAndView(model,"complete.hbs");
        }, new HandlebarsTemplateEngine());

    }
}