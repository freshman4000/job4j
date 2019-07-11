package exam;

import org.junit.Test;
import org.junit.Assert;
import  org.hamcrest.core.Is;
/**
 * Test.
 */
public class CoffeMachineTest {
    /**
     * Testing 50-35
     */
    @Test
    public void if50And35Then10And5() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] result = coffeeMachine.changes(50, 35);
        int[] expected = new int[]{10, 5};
        Assert.assertThat(result, Is.is(expected));
    }
    /**
     * Testing 50-12
     */
    @Test
    public void if50And12Then101010And5And2And1() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] result = coffeeMachine.changes(50, 12);
        int[] expected = new int[]{10, 10, 10, 5, 2, 1};
        Assert.assertThat(result, Is.is(expected));
    }
}
