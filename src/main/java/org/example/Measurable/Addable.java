package org.example.Measurable;

import org.example.unitConverter.Converter;

public class Addable<T extends Converter> extends ComparableUnits {
    private double value;
    private T unit;

    public Addable(double value, T unit)
    {
        super(value,unit);
        this.value = value;
        this.unit = unit;
    }

    public Addable<T> add(Addable<T> metricToAdd){
        double updatedValue = unit.convert(this.value,(Enum) metricToAdd.unit);

        double addResult = updatedValue + metricToAdd.value;
        return new Addable(addResult, metricToAdd.unit);
    }


    public Addable<T> subtract(Addable<T> metricToSubtract){

        double updatedValue = unit.convert(this.value, (Enum) metricToSubtract.unit);

        if(updatedValue > metricToSubtract.value)
            throw new IllegalArgumentException("Larger Value Cannot Be Subtracted From Smaller Value");

        double subtractResult =  metricToSubtract.value - updatedValue;
        return new Addable(subtractResult, metricToSubtract.unit);
    }

}
