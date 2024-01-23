package org.example.MeasurementsUnits;

import org.example.unitConverter.Converter;


public enum TemperatureUnit implements Converter {
    F{
        @Override
        public double convert(double value, Enum e) {
            TemperatureUnit tempUnit = (TemperatureUnit) e;
            if(tempUnit == TemperatureUnit.C){
                return (value - 32) * (5/(double)9);
            }

            return value;
        }

    },
    C {
        @Override
        public double convert(double value, Enum e) {
            TemperatureUnit tempUnit = (TemperatureUnit) e;
            if(tempUnit == TemperatureUnit.F){
                return (value *  (9/(double)5))+32;
            }
            return value;
        }

    };
}
