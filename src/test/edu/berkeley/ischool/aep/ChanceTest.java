package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Created by jhess on 31.01.14.
 */
public class ChanceTest {

    @Test

    public void ProbabilityShouldBe5In6 (){


        Chance coinToss = new Chance(0.5);
        Chance dieThrow = new Chance(1/6);
      //  assertEquals(coinToss, coinToss);
       // assertFalse(dieThrow.equals(coinToss));
     //   assertEquals(new Chance(0.5), coinToss);
        assertEquals(new Chance(1-1/6), dieThrow.not());


    }

    @Test public void EqualsShouldWorkAccordingToContract(){

        Chance coinToss = new Chance(0.5);
        double Test = 1.0;
        Test = Test*2;

        System.out.println(Test);

    }

/*    @Test
    public void probabliltiyOfEventAAndEventBShouldBe1In36(){

        Chance twoDiceThrow = new Chance(1.0/6.0,1.0/6.0);
        assertEquals(new Chance(1.0/36), twoDiceThrow.and());
        assertEquals(new Chance(1-1.0/36), twoDiceThrow.and().not());
    }*/

    @Test
    public void probabilitzOfAOrBshouldBe2In6(){
        Chance firstDiceThrow = new Chance(1.0/6);
        Chance secondDiceThrow = new Chance(1.0/6);

        assertEquals(new Chance(1.0 / 3.0 - 1.0 / 36.0), firstDiceThrow.or(secondDiceThrow));
      
    }

}
