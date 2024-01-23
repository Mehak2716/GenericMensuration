package orrg.example.Measurements;

import org.example.Measurable.Addable;
import org.example.Measurements.Volume;
import org.example.Measurements.Weight;
import org.example.MeasurementsUnits.VolumeUnit;
import org.example.MeasurementsUnits.WeightUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeightTest {

    @Test
    public void compareWeightOf1GWith1GExpect0()
    {
        Weight weight1 = new Weight(1, WeightUnit.G);
        Weight weight2 = new Weight(1,WeightUnit.G);
        int result = weight1.compareTo(weight2);
        assertEquals(0,result);
    }

    @Test
    public void compareWeightOf1MGithVolumeOf1L_ExpectException()
    {
        Weight weight1 = new Weight(1, WeightUnit.MG);
       Volume volume1 = new Volume(1, VolumeUnit.L);
        Throwable exception = assertThrows(ClassCastException.class, () -> {
            weight1.compareTo(volume1);
        });
        assertEquals(ClassCastException.class,exception.getClass());
    }

    @Test
    public void compareWeightOf1GWith1DGExpect1()
    {
        Weight weight1 = new Weight(1,WeightUnit.G);
        Weight weight2 = new Weight(1,WeightUnit.DG);
        int result = weight1.compareTo(weight2);
        assertEquals(1,result);
    }

    @Test
    public void compareWeightOf1DGWith1GExpectMinus1()
    {
        Weight weight1 = new Weight(1,WeightUnit.DG);
        Weight weight2 = new Weight(1,WeightUnit.G);
        int result = weight1.compareTo(weight2);
        assertEquals(-1,result);
    }
    @Test
    public void addWeightOf1MGWith1MGToGet2MG()
    {
        Weight weight1 = new Weight(1.0,WeightUnit.MG);
        Weight weight2 = new Weight(1.0,WeightUnit.MG);
        Addable result = weight1.add(weight2);
        assertEquals(new Weight(2.0,WeightUnit.MG),result);
    }

    @Test
    public void addWeightOf1MGWith2GToGet2_001G()
    {
        Weight weight1 = new Weight(1.0,WeightUnit.MG);
        Weight weight2 = new Weight(2.0,WeightUnit.G);
        Addable actualWeight = weight1.add(weight2);
        Weight expectedWeight = new Weight(2.001,WeightUnit.G);
        assertEquals(expectedWeight,actualWeight);
    }

    @Test
    public void addWeightOf1GWith2DGToGet12DG()
    {
        Weight weight1 = new Weight(1.0,WeightUnit.G);
        Weight weight2 = new Weight(2.0,WeightUnit.DG);
        Addable actualWeight = weight1.add(weight2);
        Weight expectedWeight = new Weight(12,WeightUnit.DG);
        assertEquals(expectedWeight,actualWeight);
    }

    @Test
    public void subtractWeightOf1MGWith1MGToGet0MG()
    {
        Weight weight1 = new Weight(1.0,WeightUnit.MG);
        Weight weight2 = new Weight(1.0,WeightUnit.MG);
        Addable result = weight1.subtract(weight2);
        assertEquals(new Weight(0.0,WeightUnit.MG),result);
    }

    @Test
    public void subtractWeightOf1MGWith2GToGet1_999G()
    {
        Weight weight1 = new Weight(1.0, WeightUnit.MG);
        Weight weight2 = new Weight(2.0,WeightUnit.G);
        Addable actualLength = weight1.subtract(weight2);
        Weight expectedLength = new Weight(1.999,WeightUnit.G);
        assertEquals(expectedLength,actualLength);
    }

    @Test
    public void subtractWeightOf1KGWith2GExpectsIllegalArgumentException()
    {
        Weight weight1 = new Weight(1.0,WeightUnit.KG);
        Weight weight2 = new Weight(2.0,WeightUnit.G);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            weight1.subtract(weight2);
        });

        String expectedMessage = "Larger Value Cannot Be Subtracted From Smaller Value";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

}
