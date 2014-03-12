package edu.berkeley.ischool.aep;

/**
 * Created by jhess on 14.02.14.
 */
public class Conversion {

    // Units: 0 - teaspoon, 1 - tablespoon, 2 - ounce, 3 - cup, 4 - feet, 5 - yard, 6 - mile

    private double amount = 0.0;
    private int unit = 0;

    //constructor
    public Conversion(double am, int un){
        amount = am;
        unit = un;
    }


    public Conversion convertTo(int newUnit) {

        double tsp2tbsp = 3.0;
        double tbsp2ounce = 2.0;
        double oz2cup = 8.0;
        double ft2ya = 3.0;
        double ya2mi = 1760.0;

        double[] conversion_table = new double[5];
        conversion_table[0] = tsp2tbsp;
        conversion_table[1] = tbsp2ounce;
        conversion_table[2] = oz2cup;
        conversion_table[3] = ft2ya;
        conversion_table[4] = ya2mi;

        double amount_temp = this.amount;
        boolean down_conversion = false;

        int increment = 1;
        if(newUnit < this.unit) {
            down_conversion = true;
            increment = -1;
        }

        for(int i = this.unit; i != newUnit; i+=increment){

            if(down_conversion) amount_temp = amount_temp * conversion_table[i-2];
            else amount_temp = amount_temp / conversion_table[i-1];
        }

        return new Conversion(amount_temp, newUnit);

    }

    @Override
    public boolean equals(Object other) {
        if ( other == this) return true;
        if(!(other instanceof Conversion)) return false;
        return myEquals(other);
    }

    private boolean myEquals(Object other) {
        return (((Conversion)other).getAmount() - this.getAmount()  < 0.00001) && (((Conversion)other).getUnit() == this.getUnit());
    }

    @Override
    public int hashCode(){
        return 42;
    }

    @Override
    public String toString(){
        return "amount: " + amount + ", unit: " + unit;
    }

    public double getAmount() {
        return amount;
    }
public int getUnit() {
        return unit;
    }

}
