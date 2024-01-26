package org.example.MeasurementsUnits;

import org.example.unitConverter.Converter;

import java.util.function.Function;


public enum WeightUnit implements Converter {
    MG(l->l*0.001,l->l*1000),
    CG(l->l*0.01,l->l*100),
    DG(l->l*0.1,l->l*10),
    G(l->l*1,l->l*1),
    DAG(l->l*10,l->l*0.1),
    HG(l->l*100,l->l*0.01),
    KG(l->l*1000,l->l*0.001);


    Function<Double,Double> toBase;
    Function<Double,Double> fromBase;
    private WeightUnit(Function<Double,Double> baseFun,Function<Double,Double> fromBaseFun){
        this.toBase=baseFun;
        this.fromBase = fromBaseFun;
    }


    @Override
    public double convert(double value, Enum e) {
        double baseValue = this.toBase.apply(value);
        return ((WeightUnit) e).fromBase.apply(baseValue);

    }
}
