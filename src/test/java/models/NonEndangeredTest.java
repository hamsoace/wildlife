package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonEndangeredTest {
    private NonEndangered newNonEndangered(){
        return new NonEndangered("Panda", "Malnourished", "Old");
    }

    @Test
    public void nonEndangered_instantiatesCorrectly_true(){
        NonEndangered nonEndangered = newNonEndangered();
        assertTrue(nonEndangered instanceof  NonEndangered);
    }

    @Test
    public void getName_returnAnimalsName(){
        NonEndangered nonEndangered = newNonEndangered();
        assertEquals("Panda", nonEndangered.getName());
    }

    @Test
    public void getAge_returnAnimalsAge(){
        NonEndangered nonEndangered = newNonEndangered();
        assertEquals("Old", nonEndangered.getAge());
    }

    @Test
    public void getHealth_returnAnimalsHealth(){
        NonEndangered nonEndangered = newNonEndangered();
        assertEquals("Malnourished", nonEndangered.getHealth());
    }

    @Test
    public void getStatus_returnAnimalsStatus(){
        NonEndangered nonEndangered = newNonEndangered();
        assertEquals("Non Endangered", nonEndangered.getType());
    }
}