package de.starwit.example.testexample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MathControllerTest {

    @Test    
    void testAdd() {
        MathController testee = new MathController();
        assertEquals(5, testee.add(2, 3));
        assertEquals(10, testee.add(-10, 20));

        // Because floating point data types cannot represent any decimal number, we have to check for lower accuracy here
        float MIN_ACCURACY = 0.00001f;
        assertTrue(() -> {
            return Math.abs(testee.add(0.0001f, 0.00001f) - 0.00011f) < MIN_ACCURACY;
        });
    }

    @Test    
    void testExactAdd() {
        MathController testee = new MathController();
        assertEquals("5", testee.addExact("2", "3"));
        assertEquals("10", testee.addExact("-10", "20"));

        assertEquals("0.00011", testee.addExact("0.0001", "0.00001"));
    }
}
