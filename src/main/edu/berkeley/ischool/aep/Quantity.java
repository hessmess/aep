package edu.berkeley.ischool.aep;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by jonashess on 14/02/14.
 */
//Understands conversion
public class Quantity {

    private double value;


    public enum Units { INCHES, FEET, YARDS, MILES, TBSP,TSP,OZ,CUP;}
    private Units unit;
    private HashMap<String,Double> convertLengthHashMap = new HashMap<String, Double>();
    private HashMap<String,Double> convertVolumeHashMap = new HashMap<String, Double>();

    public Quantity(double value, Units unit){
        this.value = value;
        this.unit = unit;

        this.convertLengthHashMap.put("INCHES_FEET",1.0/12);
        this.convertLengthHashMap.put("FEET_INCHES",12.0);
        this.convertLengthHashMap.put("INCHES_INCHES",1.0);

        this.convertLengthHashMap.put("YARDS_INCHES",36.0);
        this.convertLengthHashMap.put("MILES_INCHES",36.0*176.0);


        this.convertLengthHashMap.put("FEET_YARD", 1.0/3);
        this.convertLengthHashMap.put("YARDS_FEET", 3.0);
        this.convertLengthHashMap.put("YARDS_MILES", 1.0/176);
        this.convertLengthHashMap.put("MILES_YARDS", 176.0);
        this.convertVolumeHashMap.put("TSP_TSP", 1.0);

        this.convertVolumeHashMap.put("TBSP_TSP", 3.0);
        this.convertVolumeHashMap.put("OZ_TSP", 6.0);
        this.convertVolumeHashMap.put("CUP_TSP", 48.0);

        this.convertVolumeHashMap.put("TSP_TBSP", 1.0/3.0);
        this.convertVolumeHashMap.put("OZ_TBSP", 2.0);
        this.convertVolumeHashMap.put("TBSP_OZ", 1.0/2.0);
        this.convertVolumeHashMap.put("OZ_CUP", 1.0/8);
        this.convertVolumeHashMap.put("CUP_OZ", 8.0);


    }

    private Quantity convert(String strConvertTo) {

        String key =String.valueOf(this.unit) + "_" + strConvertTo;
        double mult = 0.0;
        if(this.convertLengthHashMap.containsKey(key)){
            mult = this.convertLengthHashMap.get(String.valueOf(this.unit) + "_" + strConvertTo);
        }
        else{
            mult = this.convertVolumeHashMap.get(String.valueOf(this.unit) + "_" + strConvertTo);
        }

        return new Quantity(this.value * mult, Units.valueOf(strConvertTo));

    }

    @Override
    public boolean equals(Object other) {
        if ( other == this) return true;
        if(!(other instanceof Quantity)) return false;
        Quantity convertedQty = ((Quantity) other).convert(String.valueOf(this.unit));
        if(this.value == convertedQty.value && this.unit == convertedQty.unit) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return this.value +" " + this.unit;
    }




}

/*

3 ft = 1yd
176 yd = 1 mi
1 tbsp = 3 tspns
1 oz = 2 tbspns
8 oz = 1 cup


212 F  = 100 C
32 F = 0 C
C -> F  *9, /5, +32
F ->C -32, *5, /9


 */
