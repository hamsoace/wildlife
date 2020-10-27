import DB.DB;

//import java.sql.Connection;
import org.sql2o.Connection;

import java.util.List;

public class Animal{

    private final String type;
    private String name;
    private int id;

    public Animal(String type, String name, int id) {
        this.type = type;
        this.name = name;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

   public static List<Animal> getAllAnimals(){
        String sql = "SELECT * FROM animal";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);

        }
   }
    //public String ANIMAL_TYPE = "Non-Endangered";


}
