package models;

import DB.DB;
import org.sql2o.Sql2oException;
import org.sql2o.Connection;
//import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NonEndangered extends Animal{
    private static final String DB_TYPE = "Non Endangered";

    public NonEndangered(String name, String health, String age){
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = DB_TYPE;
    }

    public static List<NonEndangered> all(){
        String sql = "SELECT * FROM animals where type = :type";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("type", DB_TYPE)
                    .executeAndFetch(NonEndangered.class);
        }
    }

    public static NonEndangered find(int searchId){
        String sql = "SELECT * FROM animals where (id=:id AND type = :type)";
        try (Connection con = DB.sql2o.open()){
            return con.createQuery(sql).addParameter("id", searchId)
                    .addParameter("type", DB_TYPE)
                    .executeAndFetchFirst(NonEndangered.class);
        }
    }
}