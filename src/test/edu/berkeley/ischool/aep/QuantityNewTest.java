package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by rahmaniacc on 2/14/14.
 */
public class QuantityNewTest {

    @Test
    public void threeFeetShouldEqualOneYard(){
        assertEquals(new ArithmeticQuantity(Unit.YARDS, 1.0), new ArithmeticQuantity(Unit.FEET, 3));
    }

    @Test
    public void oneMileShouldEqual1760Yard(){
        assertEquals(new ArithmeticQuantity(Unit.MILES, 1.0), new ArithmeticQuantity(Unit.YARDS, 1760));
    }

    @Test
    public void oneCupShouldEqualEightOz(){
        assertEquals(new ArithmeticQuantity(Unit.CUP, 1.0), new ArithmeticQuantity(Unit.OZ, 8));
    }

    @Test
    public void oneTbspShouldEqualThreeTsp(){
        assertEquals(new ArithmeticQuantity(Unit.TBSP, 1.0),new ArithmeticQuantity(Unit.TSP, 3));
    }

    @Test
    public void twoInchesAddTwoInchesEqualsFourInches(){
        new ArithmeticQuantity(Unit.INCHES, 2).add(new ArithmeticQuantity(Unit.INCHES, 2));
    }

    @Test
    public void twoTbspAddOneOzEqualsTwelveTsp(){
        assertEquals(new ArithmeticQuantity(Unit.TSP, 12.0), new ArithmeticQuantity(Unit.TBSP, 2).add(new ArithmeticQuantity(Unit.OZ, 1)));
        assertEquals(new ArithmeticQuantity(Unit.TSP, 12.0),
                new ArithmeticQuantity(Unit.OZ, 1).add(new ArithmeticQuantity(Unit.TBSP, 2)));

        assertEquals(new ArithmeticQuantity(Unit.TSP, 1.0), new ArithmeticQuantity(Unit.FEET, 1));
    }

    @Test(expected = RuntimeException.class)
    public void twoOzPlusOneFootShouldThrowException() throws Exception {
        assertEquals(new ArithmeticQuantity(Unit.FEET, 2),
                new ArithmeticQuantity(Unit.FEET, 1).add(new ArithmeticQuantity(Unit.OZ, 2)));
    }

    @Test
    public void tenCelsiusShouldEqualFiftyFahrenheit(){
        assertEquals(new ArithmeticQuantity(Unit.FAHRENHEIT, 50), new ArithmeticQuantity(Unit.CELSIUS, 10));
    }

    @Test
    public void oneFahrenheitShouldEqualMinusSeventeenCelsius(){
        assertEquals(new ArithmeticQuantity(Unit.CELSIUS, -17.22), new ArithmeticQuantity(Unit.FAHRENHEIT, 1));
    }

    @Test
    public void TwoFeetShouldBeBetterThanOneFeet(){
        assertTrue(new ScaledQuantity(2.0,Unit.FEET).IsBetterThan(new ScaledQuantity(1.0,Unit.FEET)));

    }

    @Test
    public void TwoFeetShouldNotBeBetterThanTwoFeet(){
        assertFalse(new ScaledQuantity(2.0, Unit.FEET).IsBetterThan(new ScaledQuantity(2.0, Unit.FEET)));

    }

    @Test
    public void TwoFeetShouldBeBetterThanTwelveInches(){
        assertTrue(new ScaledQuantity(2.0,Unit.FEET).IsBetterThan(new ScaledQuantity(12.0,Unit.INCHES)));

    }

    @Test(expected =  RuntimeException.class)
    public void ShouldNotCompareFeetWithOz(){
        assertTrue(new ScaledQuantity(2.0,Unit.FEET).IsBetterThan(new ScaledQuantity(1.0,Unit.OZ)));
    }

    public void HundredFahrenheitShouldBeBetterThanZeroCelsius(){
        assertTrue(new ScaledQuantity(100.0,Unit.FAHRENHEIT).IsBetterThan(new ScaledQuantity(0.0,Unit.CELSIUS)));
    }

//Best Quantity
//Given  series of quanitites, find which is the best.
}
