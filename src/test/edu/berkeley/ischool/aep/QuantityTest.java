package edu.berkeley.ischool.aep;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by jonashess on 14/02/14.
 */
public class QuantityTest {
    @Test
    public void threeFeetShouldEqualOneYard(){

        assertEquals(new Quantity(Unit.YARDS, 1.0), new Quantity(Unit.FEET, 3.0));
    }

    @Test
    public void someYardsShouldEqualOneMile(){
        assertEquals(new Quantity(Unit.YARDS, 1760.0), new Quantity(Unit.MILES, 1.0));
    }

    @Test
    public void threeTeaspoonsEqualsOneTablespoon(){
        assertEquals(new Quantity(Unit.TBSP, 1.0), new Quantity(Unit.TSP, 3.0));
    }

    @Test
    public void oneOunceEqualsTwoTablespoons(){
        assertEquals(new Quantity(Unit.OZ, 1.0), new Quantity(Unit.TBSP, 2.0));
    }

    @Test
    public void sixTeaspoonsEqualsOneOunce(){
        assertEquals(new Quantity(Unit.OZ, 1.0), new Quantity(Unit.TSP,6.0));
    }

    @Test
    public void TwoInchesPlusTwoInchesEqualsFourInches(){
        assertEquals(new Quantity(Unit.INCHES, 4.0), Quantity.add(new Quantity(Unit.INCHES, 2.0), new Quantity(Unit.INCHES, 2.0)));
    }

    @Test
    public void TwoTablespoonsPlusOneOunceEqualsTwelveTeaspoons(){

        assertEquals(new Quantity(Unit.TSP, 12.0), Quantity.add(new Quantity(Unit.TBSP, 2.0), new Quantity(Unit.OZ, 1.0)));
    }

    @Test(expected = RuntimeException.class)
    public void addOneOunceAndTwoFeetShouldException(){
        assertEquals(new Quantity(Unit.FEET, 1), Quantity.add(new Quantity(Unit.FEET, 2.0), new Quantity(Unit.OZ, 1.0)));
    }

    @Test
    public void twoOneTwelveFahrenheitEqualsHundredCelsius(){
        assertEquals(new Quantity(Unit.FAHRENHEIT, 212.0), new Quantity(Unit.CELSIUS, 100.0));
    }
}
