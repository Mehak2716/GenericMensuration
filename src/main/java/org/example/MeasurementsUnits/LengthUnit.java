package org.example.MeasurementsUnits;

import org.example.unitConverter.Converter;

public enum LengthUnit implements Converter {

        MM,
        CM,
        DM,
        M,
        DAM,
        HM,
        KM;


        @Override
        public double convert(double value, Enum e)
        {
            LengthUnit convertToUnit = (LengthUnit)e;
            int unitToConvertIndex=-1;
            int convertToUnitIndex=-1;

            for(int i = 0; i< LengthUnit.values().length; i++)
            {
                if(this == LengthUnit.values()[i])
                {
                    unitToConvertIndex=i;
                }

                if(convertToUnit == LengthUnit.values()[i])
                {
                    convertToUnitIndex=i;
                }

            }

            if(unitToConvertIndex==-1 || convertToUnitIndex==-1 )
                throw new IllegalArgumentException("Unit is invalid");


            int size = Math.abs(convertToUnitIndex-unitToConvertIndex);
            double coversionParameter= Math.pow(10,size);

            if(unitToConvertIndex<convertToUnitIndex)
            {
                return  value * (1/(double)coversionParameter);
            }

            return value* (coversionParameter);
        }
}
