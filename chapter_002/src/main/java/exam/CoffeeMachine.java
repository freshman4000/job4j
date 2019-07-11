package exam;

import java.util.ArrayList;
import java.util.List;
/**
 * Class that describes change logic of coffee machine banknotes receiver.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 11.07.2019.
 * @version 1.0.
 */
public class CoffeeMachine {
    /**
     * Array of available face values.
     */
    private static final int [] NUMS = new int[] {1, 2, 5, 10};
    /**
     * Calculates the min number of bills with estimated face values to give change.
     * @param value incoming amount.
     * @param price of the product.
     * @return array of bills with face values.
     */
    public int[] changes(int value, int price) {
    List<Integer> lst = new ArrayList<>();
        int difference = value - price;
    while (difference != 0) {
        lst.add(maxCurrent(difference, NUMS));
        difference -= maxCurrent(difference, NUMS);
    }
    return lst.stream().mapToInt(x-> x).toArray();
    }
    /**
     * Finds max current face value according to the remaining amount.
     * @param ammount remaining.
     * @param noms array of available face values.
     * @return current max face value.
     */
    public static int maxCurrent(int ammount, int[] noms) {
        int result = 0;
        for(int i = 0; i < noms.length; i++) {
            if (noms[i] <= ammount && noms[i] > result) {
                result = noms[i];
            }
        }
        return result;
    }
}
