package orrg.example.MeasurementsUnits;

import org.example.Measurable.Addable;
import org.example.MeasurementsUnits.LengthUnit;
import org.example.MeasurementsUnits.VolumeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VoulmeTest {

    @Test
    public void compareVolumeOf1LWith1LExpect0()
    {
        Addable<VolumeUnit> volume1 = new Addable(1, VolumeUnit.L);
        Addable<VolumeUnit> volume2 = new Addable(1, VolumeUnit.L);
        int result = volume1.compareTo(volume2);
        assertEquals(0,result);
    }

    @Test
    public void compareLengthOf1MWithVolumeOf1L_ExpectException()
    {
        Addable<LengthUnit> length1 = new Addable(1, LengthUnit.M);
        Addable<VolumeUnit> volume1 = new Addable(1, VolumeUnit.L);
        Throwable exception = assertThrows(ClassCastException.class, () -> {
            length1.compareTo(volume1);
        });
        assertEquals(ClassCastException.class,exception.getClass());
    }

    @Test
    public void compareVolumeOf1LWith1DLExpect1()
    {
        Addable<VolumeUnit> volume1 = new Addable(1, VolumeUnit.L);
        Addable<VolumeUnit> volume2 = new Addable(1, VolumeUnit.DL);
        int result = volume1.compareTo(volume2);
        assertEquals(1,result);
    }

    @Test

    public void compareVolumeOf1DLWith1LExpectMinus1()
    {
        Addable<VolumeUnit> volume1 = new Addable(1, VolumeUnit.DL);
        Addable<VolumeUnit> volume2 = new Addable(1, VolumeUnit.L);
        int result = volume1.compareTo(volume2);
        assertEquals(-1,result);
    }


    @Test
    public void addVolumeOf1MLWith1MLToGet2ML()
    {
        Addable<VolumeUnit> volume1 = new Addable(1.0, VolumeUnit.ML);
        Addable<VolumeUnit> volume2 = new Addable(1.0, VolumeUnit.ML);
        Addable<VolumeUnit> result = volume1.add(volume2);
        assertEquals(new Addable(2.0, VolumeUnit.ML),result);
    }

    @Test
    public void addVolumeOf1LWith2DLToGet12DL()
    {
        Addable<VolumeUnit> volume1 = new Addable(1.0,VolumeUnit.L);
        Addable<VolumeUnit> volume2 = new Addable(2.0, VolumeUnit.DL);
        Addable<VolumeUnit>  actualLength = volume1.add(volume2);
        Addable<VolumeUnit>  expectedLength = new Addable(12, VolumeUnit.DL);
        assertEquals(actualLength, expectedLength);
    }

    @Test
    public void subtractVolumeOf1MLWith1MLToGet0ML()
    {
        Addable<VolumeUnit> volume1 = new Addable(1.0, VolumeUnit.ML);
        Addable<VolumeUnit> volume2 = new Addable(1.0, VolumeUnit.ML);
        Addable<VolumeUnit>  result = volume1.subtract(volume2);
        assertEquals(new Addable(0.0, VolumeUnit.ML),result);
    }

}
