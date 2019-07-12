package exam;

import java.util.ArrayList;
import java.util.List;
/**
 * Class that describes change logic of coffee machine banknotes receiver.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 11.07.2019.
 * @version 1.0.
 */
public class CoffeeMachineV2 {
    /**
     * Array of available face values.
     */
    private static final int [] NUMS = new int[] {1, 2, 5, 10};
    private  List<Integer> lst = new ArrayList<>();
    /**
     * Calculates the min number of bills with estimated face values to give change.
     * @param value incoming amount.
     * @param price of the product.
     * @return array of bills with face values.
     */
    public int[] changes(int value, int price) {
        int remaining = value - price;
        int counter = NUMS.length - 1;
        while (remaining != 0 && counter != -1) {
            if (NUMS[counter] <= remaining) {
                lst.add(NUMS[counter]);
                remaining -= NUMS[counter];
            }
            else {
                counter--;
            }
        }
        return lst.stream().mapToInt(x -> x).toArray();
    }
}