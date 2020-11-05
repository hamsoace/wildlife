package DB;

import org.sql2o.Sql2o;

public class DB {

    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife", "moringa", "Access");
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-54-82-208-124.compute-1.amazonaws.com:5432/dfbmuvkfgi9lim", "jpzedxiflxpjcd", "766817b62fa365c1d15394f7f45b0cad8bedc35f7339c6152f366b19d5488248");

}
