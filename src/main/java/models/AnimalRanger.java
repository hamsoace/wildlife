package models;

import DB.DB;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class AnimalRanger {
    private int id;
    private String name;

    public AnimalRanger(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

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

    public void save(){
        String sql = "INSERT INTO animalRangers(name) VALUES (:name)";
        try (Connection con = DB.sql2o.open()){
            this.id = (int) con.createQuery(sql, true)
            .addParameter("name",this.name)
            .executeUpdate().getKey();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    public static List<AnimalRanger> all(){
        try (Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animalRangers")
                    .executeAndFetch(AnimalRanger.class);
        }
    }

    public static AnimalRanger find(int searchId){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animalRangers WHERE id=:id")
            .addParameter("id", searchId).executeAndFetchFirst(AnimalRanger.class);
        }
    }

    public List<Sightings> mySightings(){
        String sql = "SELECT * FROM sightings WHERE rangerid = :id";
        try (Connection con = DB.sql2o.open()){
            return con.createQuery(sql).addParameter("id", this.id)
                    .executeAndFetch(Sightings.class);
        }
    }

    public void delete(){
        try (Connection con = DB.sql2o.open()){
            con.createQuery("DELETE FROM animalRangers WHERE id=:id")
                    .addParameter("id", this.id).executeUpdate();
        }
    }

}
