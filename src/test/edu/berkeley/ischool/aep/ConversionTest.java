package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jhess on 14.02.14.
 */


// Units: 0 - teaspoon, 1 - tablespoon, 2 - ounce, 3 - cup, 4 - feet, 5 - yard, 6 - mile

public class ConversionTest {
    @Test
    public void conversionshouldreturn3feetisequalto1yard () {
        Conversion conversion = new Conversion(3.0,4);
        assertEquals(new Conversion(1.0,5), conversion.convertTo(5));
        assertEquals(1.0, conversion.convertTo(5).getAmount());
    }

}


