package edu.berkeley.ischool.aep;

/**
 * Understands a four-sided figure with sides at right angles
 */
public class Rectangle {

    private double length = 0;
    private double width = 0;

    // constructor
    public Rectangle(double a, double b){
        length = a;
        width = b;
    }

    public static Rectangle createSquare(int side){
        return new Rectangle(side, side);
    }


    // getters
    public double get_length() {
        return length;
    }

    public double get_width() {
        return width;
    }

    public double get_area() {
        return length * width;
    }


    // setters
    public void set_length(double len){
        length = len;
    }

    public void set_width(double len){
        width = len;
    }
}
