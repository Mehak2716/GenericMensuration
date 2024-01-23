package org.example.Measurements;

import org.example.Measurable.ComparableUnits;
import org.example.MeasurementsUnits.LengthUnit;
import org.example.MeasurementsUnits.TemperatureUnit;

public class Temperature extends ComparableUnits<TemperatureUnit> {

    private double value;
    private TemperatureUnit unit;
    public Temperature(double value, TemperatureUnit unit) {
        super(value, unit);
        this.value = value;
        this.unit = unit;
    }
}
