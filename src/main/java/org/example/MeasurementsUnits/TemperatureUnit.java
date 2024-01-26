package org.example.MeasurementsUnits;

import org.example.unitConverter.Converter;

import java.util.function.Function;


public enum TemperatureUnit implements Converter {

    F(l->(l-32)*(5/(double)9),l->(l*(9/(double)5))+32),
    C(l->l*1,l->l*1);
//    C {
//        @Override
//        public double convert(double value, Enum e) {
//            TemperatureUnit tempUnit = (TemperatureUnit) e;
//            if(tempUnit == TemperatureUnit.F){
//                return (value *  (9/(double)5))+32;
//            }
//            return value;
//        }
//
//    };


    Function<Double,Double> toBase;
    Function<Double,Double> fromBase;
    private TemperatureUnit(Function<Double,Double> baseFun,Function<Double,Double> fromBaseFun){
        this.toBase=baseFun;
        this.fromBase = fromBaseFun;
    }


    @Override
    public double convert(double value, Enum e) {
        double baseValue = this.toBase.apply(value);
        return ((TemperatureUnit) e).fromBase.apply(baseValue);

    }
}
