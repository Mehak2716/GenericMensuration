package orrg.example.Measurements;

import org.example.Measurable.Addable;

import org.example.Measurements.Length;
import org.example.Measurements.Volume;
import org.example.MeasurementsUnits.LengthUnit;
import org.example.MeasurementsUnits.VolumeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LengthTest {

    @Test
    public void compareLengthOf1MWith1MExpect0()
    {
        Length length1 = new Length(1, LengthUnit.M);
        Length length2 = new Length(1, LengthUnit.M);
        int result = length1.compareTo(length2);
        assertEquals(0,result);
        assertEquals(length1,length2);
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
    public void compareLengthOf1MWith1DMExpect1()
    {
        Length length1 = new Length(1, LengthUnit.M);
        Length length2 = new Length(1, LengthUnit.DM);
        int result = length1.compareTo(length2);
        assertEquals(1,result);
    }


    @Test
    public void compareLengthOf1DMWith1MExpectMinus1()
    {
        Length length1 = new Length(1, LengthUnit.DM);
        Length length2 = new Length(1, LengthUnit.M);
        int result = length1.compareTo(length2);
        assertEquals(-1,result);
    }

    @Test
    public void addLengthOf1MMWith1MMToGet2MM()
    {
        Length length1 = new Length(1.0, LengthUnit.MM);
        Length length2 = new Length(1.0, LengthUnit.MM);
        Addable result = length1.add(length2);
        assertEquals(new Length(2.0, LengthUnit.MM),result);
    }

    @Test
    public void addLengthOf1MMWith2MToGet2_001M()
    {
        Length length1 = new Length(1.0, LengthUnit.MM);
        Length length2 = new Length(2.0, LengthUnit.M);
        Addable actualLength =  length1.add(length2);
        Length expectedLength = new Length(2.001, LengthUnit.M);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void addLengthOf1MWith2DMToGet12DM()
    {
        Length length1 = new Length(1.0, LengthUnit.M);
        Length length2 = new Length(2.0, LengthUnit.DM);
        Addable  actualLength =  length1.add(length2);
        Length  expectedLength = new Length(12.0, LengthUnit.DM);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void subtractLengthOf1MMWith1MMToGet0MM()
    {
        Length length1 = new Length(1.0, LengthUnit.MM);
        Length length2 = new Length(1.0, LengthUnit.MM);
        Addable  result =  length1.subtract(length2);
        assertEquals(new Length(0.0, LengthUnit.MM),result);
    }

    @Test
    public void subtractLengthOf1MMWith2MToGet1_999M()
    {
        Length length1 = new Length(1.0, LengthUnit.MM);
        Length length2 = new Length(2.0, LengthUnit.M);
        Addable  actualLength =  length1.subtract(length2);
        Length expectedLength = new Length(1.999, LengthUnit.M);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void subtractLengthOf1KMWith2MExpectsIllegalArgumentException()
    {
        Length length1 = new Length(1.0, LengthUnit.KM);
        Length length2 = new Length(2.0, LengthUnit.M);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            length1.subtract(length2);
        });

        String expectedMessage = "Larger Value Cannot Be Subtracted From Smaller Value";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

}
