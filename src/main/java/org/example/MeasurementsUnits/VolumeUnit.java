package org.example.MeasurementsUnits;

import org.example.unitConverter.Converter;


public enum VolumeUnit implements Converter {
    ML,
    CL,
    DL,
    L,
    DAL,
    HL,
    KL;

    @Override
    public double convert(double value, Enum e)
    {
        VolumeUnit convertToUnit = (VolumeUnit) e;
        int unitToConvertIndex=-1;
        int convertToUnitIndex=-1;

        for(int i=0;i<VolumeUnit.values().length;i++)
        {
            if(this == VolumeUnit.values()[i])
            {
                unitToConvertIndex=i;
            }

            if(convertToUnit == VolumeUnit.values()[i])
            {
                convertToUnitIndex=i;
            }

        }

        if(unitToConvertIndex==-1 || convertToUnitIndex==-1 )
            throw new IllegalArgumentException("WeightUnit is invalid");


        int size = Math.abs(convertToUnitIndex-unitToConvertIndex);
        double coversionParameter= Math.pow(10,size);

        if(unitToConvertIndex<convertToUnitIndex)
        {
            return  value * (1/(double)coversionParameter);
        }

        return value* (coversionParameter);
    }
}
