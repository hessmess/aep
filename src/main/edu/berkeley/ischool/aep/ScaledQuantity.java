package edu.berkeley.ischool.aep;

/**
 * Created by jhess on 21.02.14.
 */
public class ScaledQuantity {
    protected final Unit unit;
    protected final double value;

    public ScaledQuantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        ScaledQuantity otherQuantity =  (ScaledQuantity) other;
        double otherValue = otherQuantity.unit.convertTo(otherQuantity.value, this.unit);
        return Math.abs(this.value - otherValue) < 0.01;

    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    @Override
    public int hashCode(){
        long longBits = Double.doubleToLongBits(value);
        return (int) (longBits ^ (longBits >>> 32));
    }

    public boolean IsBetterThan(ScaledQuantity scaledQuantity) {
        if (this.unit.isConvertibleTo(scaledQuantity.unit)) {
            double otherValue = scaledQuantity.unit.convertTo(scaledQuantity.value, this.unit);
            return this.value > otherValue;

        }
        else {
            throw new RuntimeException("Cannot compare " + this.unit + " with " + scaledQuantity.unit);
        }

    }
}
