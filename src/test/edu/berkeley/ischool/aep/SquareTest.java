package edu.berkeley.ischool.aep;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created by jhess on 24.01.14.
 */
public class SquareTest {

    @Test
    public void areashouldreturn16() {
        Square square = new Square(4);
        assertEquals(16.0, square.get_area());

    }
}