package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {
    private Endangered newEndageredAnimal(){
        return new Endangered("BullFrog", "Healthy", "Young");
    }

    @Test
    public void endangeredAnimals_instantiatesCorrectly_true(){
        Endangered endangered = newEndageredAnimal();
        assertTrue(endangered instanceof Endangered);
    }

    @Test
    public void getName_returnAnimalsName(){
        Endangered endangered = newEndageredAnimal();
        assertEquals("BullFrog", endangered.getName());
    }
}