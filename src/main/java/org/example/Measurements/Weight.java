package org.example.Measurements;

import org.example.Measurable.Addable;
import org.example.MeasurementsUnits.LengthUnit;
import org.example.MeasurementsUnits.WeightUnit;

public class Weight extends Addable<WeightUnit> {
    private double value;
    private WeightUnit unit;
    public Weight(double value, WeightUnit unit) {
        super(value, unit);
        this.value = value;
        this.unit = unit;
    }
}
