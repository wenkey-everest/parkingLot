package com.everest.parkinglot.models;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {
    @Test
    public void testingLevel(){
        Level level = new Level(6);
        assertEquals(level.getSpots().size(),6,"Slots in floor are not created with user input");
    }

}