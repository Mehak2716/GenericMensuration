package org.example.Measurements;

import org.example.Measurable.Addable;
import org.example.MeasurementsUnits.LengthUnit;

import java.util.spi.CalendarNameProvider;

public class Length extends Addable<LengthUnit> {

    private double value;
    private LengthUnit unit;
    public Length(double value, LengthUnit unit) {
        super(value, unit);
        this.value = value;
        this.unit = unit;
    }
}
