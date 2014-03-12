package edu.berkeley.ischool.aep;

/**
 * Created by jhess on 31.01.14.
 */
public class Chance{


    private double probability = 0;
    private double anotherProbability = 0;

    // constructor
    Chance(double prob){
        probability = prob;
    }

    Chance(double probEventA, double probEventB){
        probability = probEventA;
        anotherProbability = probEventB;
    }

    // getters
    Chance not(){
        return new Chance(1 - probability);
    }

    double getProb(){
        return probability;
    }

    @Override
    public boolean equals(Object other) {
        if ( other == this) return true;
        if(!(other instanceof Chance)) return false;
        return myEquals(other);
    }

    private boolean myEquals(Object other) {
        return ((Chance)other).getProb() - this.getProb() < 0.00001;
    }

    @Override
    public int hashCode(){
        return 42;
    }

    @Override
    public String toString(){
        return "value"+ probability;
    }


    public Chance and(Chance c) {
        return new Chance(probability*c.probability);
    }


    public Chance or(Chance c) {
        return new Chance((this.not().and(c.not())).not().probability);
    }


}
