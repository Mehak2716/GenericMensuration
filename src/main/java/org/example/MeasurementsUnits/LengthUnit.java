package org.example.MeasurementsUnits;

import org.example.unitConverter.Converter;

import java.util.function.Function;

public enum LengthUnit implements Converter {

        MM(l->l*0.001,l->l*1000),
        CM(l->l*0.01,l->l*100),
        DM(l->l*0.1,l->l*10),
        M(l->l*1,l->l*1),
        DAM(l->l*10,l->l*0.1),
        HM(l->l*100,l->l*0.01),
        KM(l->l*1000,l->l*0.001);


        Function<Double,Double> toBase;
        Function<Double,Double> fromBase;
        private LengthUnit(Function<Double,Double> baseFun,Function<Double,Double> fromBaseFun){
            this.toBase=baseFun;
            this.fromBase = fromBaseFun;
        }


        @Override
        public double convert(double value, Enum e) {
                double baseValue = this.toBase.apply(value);
                return ((LengthUnit) e).fromBase.apply(baseValue);

        }
}
