package orrg.example.MeasurementsUnits;

import org.example.Measurable.Addable;
import org.example.MeasurementsUnits.VolumeUnit;
import org.example.MeasurementsUnits.WeightUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeightTest {

    @Test
    public void compareWeightOf1GWith1GExpect0()
    {
        Addable<WeightUnit> weight1 = new Addable(1, WeightUnit.G);
        Addable<WeightUnit> weight2 = new Addable(1,WeightUnit.G);
        int result = weight1.compareTo(weight2);
        assertEquals(0,result);
    }

    @Test
    public void compareWeightOf1MGithVolumeOf1L_ExpectException()
    {
        Addable<WeightUnit> weight1 = new Addable(1, WeightUnit.MG);
        Addable<VolumeUnit> volume1 = new Addable(1, VolumeUnit.L);
        Throwable exception = assertThrows(ClassCastException.class, () -> {
            weight1.compareTo(volume1);
        });
        assertEquals(ClassCastException.class,exception.getClass());
    }

    @Test
    public void compareWeightOf1GWith1DGExpect1()
    {
        Addable<WeightUnit> weight1 = new Addable(1,WeightUnit.G);
        Addable<WeightUnit> weight2 = new Addable(1,WeightUnit.DG);
        int result = weight1.compareTo(weight2);
        assertEquals(1,result);
    }

    @Test
    public void compareWeightOf1DGWith1GExpectMinus1()
    {
        Addable<WeightUnit> weight1 = new Addable(1,WeightUnit.DG);
        Addable<WeightUnit> weight2 = new Addable(1,WeightUnit.G);
        int result = weight1.compareTo(weight2);
        assertEquals(-1,result);
    }
    @Test
    public void addWeightOf1MGWith1MGToGet2MG()
    {
        Addable<WeightUnit> weight1 = new Addable(1.0,WeightUnit.MG);
        Addable<WeightUnit> weight2 = new Addable(1.0,WeightUnit.MG);
        Addable<WeightUnit> result = weight1.add(weight2);
        assertEquals(new Addable(2.0,WeightUnit.MG),result);
    }

    @Test
    public void addWeightOf1MGWith2GToGet2_001G()
    {
        Addable<WeightUnit> weight1 = new Addable(1.0,WeightUnit.MG);
        Addable<WeightUnit> weight2 = new Addable(2.0,WeightUnit.G);
        Addable<WeightUnit> actualWeight = weight1.add(weight2);
        Addable<WeightUnit> expectedWeight = new Addable(2.001,WeightUnit.G);
        assertEquals(expectedWeight,actualWeight);
    }

    @Test
    public void addWeightOf1GWith2DGToGet12DG()
    {
        Addable<WeightUnit> weight1 = new Addable(1.0,WeightUnit.G);
        Addable<WeightUnit> weight2 = new Addable(2.0,WeightUnit.DG);
        Addable<WeightUnit> actualWeight = weight1.add(weight2);
        Addable<WeightUnit> expectedWeight = new Addable(12,WeightUnit.DG);
        assertEquals(expectedWeight,actualWeight);
    }

    @Test
    public void subtractWeightOf1MGWith1MGToGet0MG()
    {
        Addable<WeightUnit> weight1 = new Addable(1.0,WeightUnit.MG);
        Addable<WeightUnit> weight2 = new Addable(1.0,WeightUnit.MG);
        Addable<WeightUnit> result = weight1.subtract(weight2);
        assertEquals(new Addable(0.0,WeightUnit.MG),result);
    }

    @Test
    public void subtractWeightOf1MGWith2GToGet1_999G()
    {
        Addable<WeightUnit> weight1 = new Addable(1.0, WeightUnit.MG);
        Addable<WeightUnit> weight2 = new Addable(2.0,WeightUnit.G);
        Addable<WeightUnit> actualLength = weight1.subtract(weight2);
        Addable<WeightUnit> expectedLength = new Addable(1.999,WeightUnit.G);
        assertEquals(expectedLength,actualLength);
    }

    @Test
    public void subtractWeightOf1KGWith2GExpectsIllegalArgumentException()
    {
        Addable<WeightUnit> weight1 = new Addable(1.0,WeightUnit.KG);
        Addable<WeightUnit> weight2 = new Addable(2.0,WeightUnit.G);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            weight1.subtract(weight2);
        });

        String expectedMessage = "Larger Value Cannot Be Subtracted From Smaller Value";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

}
