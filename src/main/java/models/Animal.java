package models;

import DB.DB;
import org.sql2o.Sql2oException;
import org.sql2o.Connection;
//import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class Animal{
    public int id;
    public String name;
    public String health;
    public String age;
    public String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals(name, health, age, type) VALUES (:name, :health, :age, :type)";
            this.id = (int) con.createQuery(sql, true).addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("type", this.type)
                    .executeUpdate().getKey();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    public static List<String> allAnimalNames(){
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT name FROM animals").executeAndFetch(String.class);
        }
    }
}