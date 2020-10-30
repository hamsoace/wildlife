import models.Endangered;
import models.Sightings;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.*;

public class App{
    public static void main(String[] args) {
       // System.out.println("Nafanya Kazi!");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sightings> allSightings = Sightings.all();
            model.put("sightings", allSightings);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


    }
}