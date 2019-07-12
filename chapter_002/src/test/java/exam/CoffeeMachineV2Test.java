package exam;

import org.junit.Test;
import org.junit.Assert;
import  org.hamcrest.core.Is;
/**
 * Test.
 */
public class CoffeeMachineV2Test {
    /**
     * Testing CoffeeMachineV2 50-35
     */
    @Test
    public void if50And35Then10And5V2() {
        CoffeeMachineV2 coffeeMachine = new CoffeeMachineV2();
        int[] result = coffeeMachine.changes(50, 35);
        int[] expected = new int[]{10, 5};
        Assert.assertThat(result, Is.is(expected));
    }
    /**
     * Testing CoffeeMachine 50-12
     */
    @Test
    public void if50And12Then101010And5And2And1V2() {
        CoffeeMachineV2 coffeeMachine = new CoffeeMachineV2();
        int[] result = coffeeMachine.changes(50, 12);
        int[] expected = new int[]{10, 10, 10, 5, 2, 1};
        Assert.assertThat(result, Is.is(expected));
    }
}