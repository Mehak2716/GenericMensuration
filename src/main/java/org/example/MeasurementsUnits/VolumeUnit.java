package org.example.MeasurementsUnits;

import org.example.unitConverter.Converter;

import java.util.function.Function;


public enum VolumeUnit implements Converter {
    ML(l->l*0.001,l->l*1000),
    CL(l->l*0.01,l->l*100),
    DL(l->l*0.1,l->l*10),
    L(l->l*1,l->l*1),
    DAL(l->l*10,l->l*0.1),
    HL(l->l*100,l->l*0.01),
    KL(l->l*1000,l->l*0.001);


    Function<Double,Double> toBase;
    Function<Double,Double> fromBase;
    private VolumeUnit(Function<Double,Double> baseFun,Function<Double,Double> fromBaseFun){
        this.toBase=baseFun;
        this.fromBase = fromBaseFun;
    }


    @Override
    public double convert(double value, Enum e) {
        double baseValue = this.toBase.apply(value);
        return ((VolumeUnit) e).fromBase.apply(baseValue);

    }
}
