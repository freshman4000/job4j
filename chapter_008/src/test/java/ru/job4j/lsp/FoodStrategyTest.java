package ru.job4j.lsp;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import ru.job4j.lsp.products.Bread;
import ru.job4j.lsp.products.Chips;
import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.products.Milk;
import ru.job4j.lsp.storages.Shop;
import ru.job4j.lsp.storages.Trash;
import ru.job4j.lsp.storages.Warehouse;
import ru.job4j.lsp.validating.DateManager;

import java.util.*;

/**
 * Testing strategy.
 */
public class FoodStrategyTest {
    private StorageStrategy<Food> shop = new Shop();
    private StorageStrategy<Food> warehouse = new Warehouse();
    private StorageStrategy<Food> trash = new Trash();
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
    private List<Food> productsDatabase = new ArrayList<>();

    @Before
    public void intiDatabase() {
        productsDatabase.add(bread1);
        productsDatabase.add(milk1);
        productsDatabase.add(chips1);
        productsDatabase.add(chips2);
        ControlQuality<Food> cc1 = new ControlQuality<>(shop);
        cc1.executeStorageStrategy(productsDatabase);
        ControlQuality<Food> cc2 = new ControlQuality<>(warehouse);
        cc2.executeStorageStrategy(productsDatabase);
        ControlQuality<Food> cc3 = new ControlQuality<>(trash);
        cc3.executeStorageStrategy(productsDatabase);
    }

    /**
     * Testing shop.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then2InShop() {

        List<Food> result = shop.getStorage();
        List<Food> expected = new ArrayList<>(Arrays.asList(chips2, milk1));
        result.sort(cmp);
        expected.sort(cmp);
        Assert.assertThat(result, Is.is(expected));
    }

    /**
     * Testing discount.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then2InShop1withDiscount() {

        Assert.assertThat(shop.getStorage().get(1).getDiscount(), Is.is(10));
    }

    /**
     * Testing warehouse.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then1InWare() {
        List<Food> result = warehouse.getStorage();
        Assert.assertThat(result.get(0), Is.is(bread1));
    }

    /**
     * Testing trash.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then1InTrash() {

        List<Food> result = trash.getStorage();
        Assert.assertThat(result.get(0), Is.is(chips1));
    }
}
