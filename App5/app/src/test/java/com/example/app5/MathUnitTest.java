package com.example.app5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MathUnitTest {
    @Test
    public void addition_isCorrect(){
        Math math= new Math();
        assertEquals(5,math.add(2,3));
    }

    @Test
    public void subtraction_isCorrect(){
        Math math= new Math();
        assertEquals(-1,math.subtract(2,3));
    }

    @Test
    public void multiplication_isCorrect(){
        Math math= new Math();
        assertEquals(6,math.multiply(2,3));
    }
}