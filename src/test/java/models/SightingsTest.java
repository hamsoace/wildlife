package models;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class SightingsTest {

    private Sightings newSightings(){
        return new Sightings("Monkey",1, "Nairobi");
    }

    @Test
    public void sightings_instantiatesCorrectly(){
        Sightings sightings = newSightings();
        assertTrue(sightings instanceof Sightings);
    }

    @Test
    public void getLocation_returnSightingsLocation_true(){
        Sightings sightings = newSightings();
        assertEquals("Nairobi", sightings.getLocation());
    }

    @Test
    public void getRangerId_returnRangerId_true(){
        Sightings sightings = newSightings();
        assertEquals(1,sightings.getRangerId());
    }

    @Test
    public void getTimestamp_returnRangerId_true(){
        Sightings sightings = newSightings();
        Timestamp testTimestamp = new Timestamp(new Date().getTime());
        DateFormat dateFormat = DateFormat.getDateInstance();
        assertEquals(dateFormat.format(testTimestamp), dateFormat.format(sightings.getTimestamp()));
    }

    @Test
    public void getAnimalId_returnAnimalName_true(){
        Sightings sightings = newSightings();
        assertEquals("Monkey", sightings.getAnimalName());
    }

}