package orrg.example.Measurements;

import org.example.Measurable.Addable;
import org.example.Measurements.Length;
import org.example.Measurements.Volume;
import org.example.MeasurementsUnits.LengthUnit;
import org.example.MeasurementsUnits.VolumeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VoulmeTest {

    @Test
    public void compareVolumeOf1LWith1LExpect0()
    {
        Volume volume1 = new Volume(1, VolumeUnit.L);
        Volume volume2 = new Volume(1, VolumeUnit.L);
        int result = volume1.compareTo(volume2);
        assertEquals(0,result);
    }

    @Test
    public void compareLengthOf1MWithVolumeOf1L_ExpectException()
    {
        Length length1 = new Length(1, LengthUnit.M);
        Volume volume1 = new Volume(1, VolumeUnit.L);
        Throwable exception = assertThrows(ClassCastException.class, () -> {
            length1.compareTo(volume1);
        });
        assertEquals(ClassCastException.class,exception.getClass());
    }

    @Test
    public void compareVolumeOf1LWith1DLExpect1()
    {
        Volume volume1 = new Volume(1, VolumeUnit.L);
        Volume volume2 = new Volume(1, VolumeUnit.DL);
        int result = volume1.compareTo(volume2);
        assertEquals(1,result);
    }

    @Test

    public void compareVolumeOf1DLWith1LExpectMinus1()
    {
        Volume volume1 = new Volume(1, VolumeUnit.DL);
        Volume volume2 = new Volume(1, VolumeUnit.L);
        int result = volume1.compareTo(volume2);
        assertEquals(-1,result);
    }


    @Test
    public void addVolumeOf1MLWith1MLToGet2ML()
    {
        Volume volume1 = new Volume(1.0, VolumeUnit.ML);
        Volume volume2 = new Volume(1.0, VolumeUnit.ML);
        Addable result = volume1.add(volume2);
        assertEquals(new Volume(2.0, VolumeUnit.ML),result);
    }

    @Test
    public void addVolumeOf1LWith2DLToGet12DL()
    {
        Volume volume1 = new Volume(1.0,VolumeUnit.L);
        Volume volume2 = new Volume(2.0, VolumeUnit.DL);
        Addable actualLength = volume1.add(volume2);
        Volume  expectedLength = new Volume(12, VolumeUnit.DL);
        assertEquals(actualLength, expectedLength);
    }

    @Test
    public void subtractVolumeOf1MLWith1MLToGet0ML()
    {
        Volume volume1 = new Volume(1.0, VolumeUnit.ML);
        Volume volume2 = new Volume(1.0, VolumeUnit.ML);
        Addable  result = volume1.subtract(volume2);
        assertEquals(new Volume(0.0, VolumeUnit.ML),result);
    }

}
