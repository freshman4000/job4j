package ru.job4j.lsp;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import ru.job4j.lsp.products.Bread;
import ru.job4j.lsp.products.Chips;
import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.products.Milk;
import ru.job4j.lsp.storages.*;
import ru.job4j.lsp.strategies.ControlQuality;
import ru.job4j.lsp.utility.DateManager;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * Testing strategy.
 */
public class FoodStrategyTest {
    private StoragePlace<Food> shop = new Shop(new ArrayList<>());
    private StoragePlace<Food> warehouse = new WareHouse(new ArrayList<>());
    private StoragePlace<Food> trash = new Trash(new ArrayList<>());

    private Food bread1 = new Bread("WheatDream",
            DateManager.convertDate(new Date(), 4),
            DateManager.convertDate(new Date(), 0),
            50.0, 0);

    private Food milk1 = new Milk("TexasCows",
            DateManager.convertDate(new Date(), 2),
            DateManager.convertDate(new Date(), -2),
            90.0, 0);
    private Food chips1 = new Chips("Lays",
            DateManager.convertDate(new Date(), -1),
            DateManager.convertDate(new Date(), -180),
            108.0, 0);

    private Food chips2 = new Chips("Lays",
            DateManager.convertDate(new Date(), 3),
            DateManager.convertDate(new Date(), -177),
            108.0, 0);

    private Comparator<Food> cmp = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            int res1 = o1.getExpireDate().compareTo(o2.getExpireDate());
            return res1 == 0 ? o1.getName().compareTo(o2.getName()) : res1;
        }
    };
    private List<Food> heap = new ArrayList<>();


    public void intiDatabase() {
        heap.add(bread1);
        heap.add(milk1);
        heap.add(chips1);
        heap.add(chips2);
        StrategyLauncher sl = new StrategyLauncher(new ControlQuality(heap, List.of(shop, warehouse, trash)));
        sl.launch();
    }

    /**
     * Testing shop.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then2InShop() {
        intiDatabase();
        List<Food> result = shop.getStorage();
        List<Food> expected = new ArrayList<>(Arrays.asList(chips2, milk1));
        result.sort(cmp);
        expected.sort(cmp);
        Assert.assertThat(result, Is.is(expected));
    }

//    /**
//     * Testing shop low capacity.
//     */
//
//    @Test
//    public void whenOver75PercentCapacityThenMessage() {
//        PrintStream stOut = System.out;
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        shop = new Shop(new ArrayList<>(), 2);
//        intiDatabase();
//        Assert.assertThat(out.toString(), Is.is("Attention! Low capacity!" + System.lineSeparator()));
//        System.setOut(stOut);
//    }

//    /**
//     * Testing trash full message.
//     */
//
//    @Test
//    public void whenOver100PercentCapacityThenMessage() {
//        PrintStream stOut = System.out;
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        trash = new Trash(new ArrayList<>(), 0);
//        intiDatabase();
//        Assert.assertThat(out.toString(), Is.is("Trash is full!" + System.lineSeparator()));
//        System.setOut(stOut);
//    }

    /**
     * Testing discount.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then2InShop1withDiscount() {
        intiDatabase();
        Assert.assertThat(shop.getStorage().get(1).getDiscount(), Is.is(10));
    }

    /**
     * Testing warehouse.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then1InWare() {
        intiDatabase();
        List<Food> result = warehouse.getStorage();
        Assert.assertThat(result.get(0), Is.is(bread1));
    }

    /**
     * Testing trash.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then1InTrash() {
        intiDatabase();
        List<Food> result = trash.getStorage();
        Assert.assertThat(result.get(0), Is.is(chips1));
    }
}