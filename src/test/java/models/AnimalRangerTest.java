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

    @Test
    public void getName_returnAnimalRangerName_true(){
        AnimalRanger animalRanger = newAnimalRanger();
        assertEquals("Hamso", animalRanger.getName());
    }

    @Test
    public void save_getAnimalRangerId(){
        AnimalRanger animalRanger = newAnimalRanger();
        int idBefore = animalRanger.getId();
        animalRanger.save();
        assertNotEquals(idBefore, animalRanger.getId());
    }
}