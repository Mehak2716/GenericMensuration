package org.example.Measurable;

import org.example.unitConverter.Converter;

public  abstract class ComparableUnits<T extends Converter>  {

    private double value;
    private T unit;

    public ComparableUnits(double value, T unit)
    {
        this.value = value;
        this.unit = unit;
    }
    public int compareTo(ComparableUnits<T> ToCompare)
    {
        double updatedValue = unit.convert(this.value,(Enum) ToCompare.unit);
        return Double.compare(updatedValue, ToCompare.value);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this)
            return true;

        if(!(obj instanceof ComparableUnits))
            return false;

        ComparableUnits<T> metric = (ComparableUnits<T>) obj;

        double updatedValue = unit.convert(this.value,(Enum) metric.unit);

        return updatedValue == metric.value;

    }
}
