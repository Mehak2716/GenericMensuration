package org.example.Measurements;

import org.example.Measurable.Addable;
import org.example.MeasurementsUnits.LengthUnit;
import org.example.MeasurementsUnits.VolumeUnit;

public class Volume extends Addable<VolumeUnit> {

    private double value;
    private VolumeUnit unit;
    public Volume(double value, VolumeUnit unit) {
        super(value, unit);
        this.value = value;
        this.unit = unit;
    }
}
