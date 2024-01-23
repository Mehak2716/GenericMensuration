package orrg.example.MeasurementsUnits;

import org.example.Measurable.ComparableUnits;
import org.example.MeasurementsUnits.TemperatureUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureTest {
    @Test
    public void compare1Fto1FExpects0()
    {
        ComparableUnits<TemperatureUnit> temperature1 = new ComparableUnits(1,TemperatureUnit.F);
        ComparableUnits<TemperatureUnit> temperature2 = new ComparableUnits(1,TemperatureUnit.F);
        int result = temperature1.compareTo(temperature2);
        assertEquals(0,result);
    }

    @Test
    public void compare41Fto12CExpectsMinus1()
    {
        ComparableUnits<TemperatureUnit> temperature1 = new ComparableUnits(41, TemperatureUnit.F);
        ComparableUnits<TemperatureUnit> temperature2 = new ComparableUnits(12,TemperatureUnit.C);
        int result = temperature1.compareTo(temperature2);
        assertEquals(-1,result);
    }

    @Test
    public void conmpare1Cto1CExpects0()
    {
        ComparableUnits<TemperatureUnit> temperature1 = new ComparableUnits(1,TemperatureUnit.C);
        ComparableUnits<TemperatureUnit> temperature2 = new ComparableUnits(1,TemperatureUnit.C);
        int result = temperature1.compareTo(temperature2);
        assertEquals(0,result);
    }

    @Test
    public void conmpare12Cto41FExpects1()
    {
        ComparableUnits<TemperatureUnit> temperature1 = new ComparableUnits(12,TemperatureUnit.C);
        ComparableUnits<TemperatureUnit> temperature2 = new ComparableUnits(50,TemperatureUnit.F);
        int result = temperature1.compareTo(temperature2);
        assertEquals(1,result);
    }
}
