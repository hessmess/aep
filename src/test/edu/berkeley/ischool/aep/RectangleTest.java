package edu.berkeley.ischool.aep;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created by jhess on 24.01.14.
 */
public class RectangleTest {

    @Test
    public void shouldreturnten() {
        Rectangle rectangle = new Rectangle(5, 2);
        assertEquals(10.0, rectangle.get_area());
    }
}