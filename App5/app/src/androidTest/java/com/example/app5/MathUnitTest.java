package com.example.app5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class MathUnitTest {
    @Test
    public void addition_isCorrect(){
        Math math= new Math();
        assertEquals(5,math.add(2,3));
    }

    public void subtraction_isCorrect(){
        Math math= new Math();
        assertEquals(-1,math.add(2,3));
    }

    public void multiplication_isCorrect(){
        Math math= new Math();
        assertEquals(6,math.add(2,3));
    }
}