package models;

import DB.DB;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Sightings {
    private String animalName;
    private int rangerId;
    private String location;
    private Timestamp timestamp;
    private int id;

    public Sightings(String animalName, int rangerId, String location) {
        this.animalName = animalName;
        this.rangerId = rangerId;
        this.location = location;
        this.timestamp = new Timestamp(new Date().getTime());
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return animalName.equals(sightings.animalName) && rangerId == sightings.rangerId
                && rangerId == sightings.rangerId && Objects.equals(location, sightings.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, location, rangerId);
    }

    public String getAnimalName() {
        return animalName;
    }

    public int getRangerId() {
        return rangerId;
    }

    public String getLocation() {
        return location;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public String getReadableTimestamp(){
        return DateFormat.getDateTimeInstance().format(getTimestamp());
    }

    public void save(){
        String sql = "INSERT INTO sightings(animalname, location, timestamp, rangerid) VALUES (:animalName, :location, :timestamp, :rangerid)";
        try (Connection con = DB.sql2o.open()){
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName", this.animalName)
                    .addParameter("location", this.location)
                    .addParameter("timestamp", this.timestamp)
                    .addParameter("rangerid", this.rangerId)
                    .executeUpdate().getKey();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    public String getRangerName(){
        return AnimalRanger.find(rangerId).getName();
    }

    public static List<Sightings> all(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings")
                    .executeAndFetch(Sightings.class);
        }
    }

    public static Sightings find(int searchId){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings WHERE id=:id")
                    .addParameter("id", searchId)
                    .executeAndFetchFirst(Sightings.class);
        }
    }

    public static List<String> getAllLocations(){
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT location FROM sightings")
                    .executeAndFetch(String.class);
        }
    }

    public static List<Sightings> getAllSightingsInLocation(String locationFilter){
        try (Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings WHERE location = :location")
                    .addParameter("location", locationFilter)
                    .executeAndFetch(Sightings.class);
        }
    }
}
