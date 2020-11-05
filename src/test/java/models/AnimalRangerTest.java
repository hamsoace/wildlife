package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalRangerTest {
    private AnimalRanger newAnimalRanger(){
        return new AnimalRanger("Hamso");
    }

    @Test
    public void animalRanger_instantiatesCorrectly(){
        AnimalRanger animalRanger = newAnimalRanger();
        assertTrue(animalRanger instanceof AnimalRanger);
    }
}