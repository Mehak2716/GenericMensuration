package orrg.example.MeasurementsUnits;

import org.example.Measurable.Addable;

import org.example.MeasurementsUnits.LengthUnit;
import org.example.MeasurementsUnits.VolumeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LengthTest {

    @Test
    public void compareLengthOf1MWith1MExpect0()
    {
        Addable<LengthUnit> length1 = new Addable(1, LengthUnit.M);
        Addable<LengthUnit> length2 = new Addable(1, LengthUnit.M);
        int result = length1.compareTo(length2);
        assertEquals(0,result);
        assertEquals(length1,length2);
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
    public void compareLengthOf1MWith1DMExpect1()
    {
        Addable<LengthUnit> length1 = new Addable(1, LengthUnit.M);
        Addable<LengthUnit> length2 = new Addable(1, LengthUnit.DM);
        int result = length1.compareTo(length2);
        assertEquals(1,result);
    }


    @Test
    public void compareLengthOf1DMWith1MExpectMinus1()
    {
        Addable<LengthUnit> length1 = new Addable(1, LengthUnit.DM);
        Addable<LengthUnit> length2 = new Addable(1, LengthUnit.M);
        int result = length1.compareTo(length2);
        assertEquals(-1,result);
    }

    @Test
    public void addLengthOf1MMWith1MMToGet2MM()
    {
        Addable<LengthUnit> length1 = new Addable(1.0, LengthUnit.MM);
        Addable<LengthUnit> length2 = new Addable(1.0, LengthUnit.MM);
        Addable<LengthUnit> result = length1.add(length2);
        assertEquals(new Addable(2.0, LengthUnit.MM),result);
    }

    @Test
    public void addLengthOf1MMWith2MToGet2_001M()
    {
        Addable<LengthUnit> length1 = new Addable(1.0, LengthUnit.MM);
        Addable<LengthUnit> length2 = new Addable(2.0, LengthUnit.M);
        Addable<LengthUnit> actualLength =  length1.add(length2);
        Addable<LengthUnit> expectedLength = new Addable(2001, LengthUnit.MM);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void addLengthOf1MWith2DMToGet12DM()
    {
        Addable<LengthUnit> length1 = new Addable(1.0, LengthUnit.M);
        Addable<LengthUnit> length2 = new Addable(2.0, LengthUnit.DM);
        Addable<LengthUnit>  actualLength =  length1.add(length2);
        Addable<LengthUnit>  expectedLength = new Addable(12, LengthUnit.DM);
        assertEquals(actualLength, expectedLength);
    }

    @Test
    public void subtractLengthOf1MMWith1MMToGet0MM()
    {
        Addable<LengthUnit> length1 = new Addable(1.0, LengthUnit.MM);
        Addable<LengthUnit> length2 = new Addable(1.0, LengthUnit.MM);
        Addable<LengthUnit>  result =  length1.subtract(length2);
        assertEquals(new Addable(0.0, LengthUnit.MM),result);
    }

    @Test
    public void subtractLengthOf1MMWith2MToGet1_999M()
    {
        Addable<LengthUnit> length1 = new Addable(1.0, LengthUnit.MM);
        Addable<LengthUnit> length2 = new Addable(2.0, LengthUnit.M);
        Addable<LengthUnit>  actualLength = length1.subtract(length2);
        Addable<LengthUnit>  expectedLength = new Addable(1.999, LengthUnit.M);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void subtractLengthOf1KMWith2MExpectsIllegalArgumentException()
    {
        Addable<LengthUnit> length1 = new Addable(1.0, LengthUnit.KM);
        Addable<LengthUnit> length2 = new Addable(2.0, LengthUnit.M);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            length1.subtract(length2);
        });

        String expectedMessage = "Larger Value Cannot Be Subtracted From Smaller Value";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

}
