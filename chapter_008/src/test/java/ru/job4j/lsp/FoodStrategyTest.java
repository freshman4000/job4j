package ru.job4j.lsp;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import ru.job4j.lsp.products.*;
import ru.job4j.lsp.storages.*;
import ru.job4j.lsp.strategies.ControlQuality;
import ru.job4j.lsp.strategies.ControlQualityV2;
import ru.job4j.lsp.utility.DateManager;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * Testing strategy.
 */
public class FoodStrategyTest {
    private StoragePlace<Food> shop = new Shop(new ArrayList<>());
    private StoragePlaceV2 shopV2 = new ShopV2(shop, 10, new ArrayList<>());
    private StoragePlace<Food> warehouse = new WareHouse(new ArrayList<>());
    private StoragePlaceV2 wareHouseAdd = new WarehouseAdditional(10, new ArrayList<>());
    private StoragePlaceV2 wareHouseV2 = new WarehouseNormalTemp(warehouse, 1, new ArrayList<>(), wareHouseAdd);
    private StoragePlaceV2 wareHouseFridge = new WarehouseFridge(10, new ArrayList<>());
    private StoragePlace<Food> trash = new Trash(new ArrayList<>());
    private StoragePlaceV2 trashV2 = new TrashV2(trash, 10, new ArrayList<>());
    private StoragePlaceV2 repFacility = new ReproductionFacility(10, new ArrayList<>());

    private FoodV2 carrot1 = new FoodV2("Carrot - Minis",
            DateManager.convertDate(new Date(), 42),
            DateManager.convertDate(new Date(), -2),
            30.0, 0, true, true);

    private Food bread1 = new Food("Bread WheatDream",
            DateManager.convertDate(new Date(), 4),
            DateManager.convertDate(new Date(), 0),
            50.0, 0);
    private FoodV2 bread1V2 = new FoodV2(false,
            true, bread1);
    private FoodV2 bread2V2 = new FoodV2("Bread WheatDreamT",
            DateManager.convertDate(new Date(), 4),
            DateManager.convertDate(new Date(), 0),
            50.0, 0, false, true);
    private FoodV2 bread3V2 = new FoodV2("Bread WheatDreamW",
            DateManager.convertDate(new Date(), -1),
            DateManager.convertDate(new Date(), -5),
            50.0, 0, false, true);

    private Food milk1 = new Food("Milk TexasCows",
            DateManager.convertDate(new Date(), 2),
            DateManager.convertDate(new Date(), -2),
            90.0, 0);
    private FoodV2 milk1V2 = new FoodV2(false,
            true, milk1);
    private Food chips1 = new Food("Chips Lays",
            DateManager.convertDate(new Date(), -1),
            DateManager.convertDate(new Date(), -180),
            108.0, 0);
    private FoodV2 chips1V2 = new FoodV2(false,
            false, chips1);

    private Food chips2 = new Food("Chips Lays",
            DateManager.convertDate(new Date(), 3),
            DateManager.convertDate(new Date(), -177),
            108.0, 0);
    private FoodV2 chips2V2 = new FoodV2(false,
            false, chips2);

    private Comparator<FoodV2> cmp = new Comparator<FoodV2>() {
        @Override
        public int compare(FoodV2 o1, FoodV2 o2) {
            int res1 = o1.getExpireDate().compareTo(o2.getExpireDate());
            if (res1 == 0) {
                res1 = o1.getPrice().compareTo(o2.getPrice());
            }
            return res1 == 0 ? o1.getName().compareTo(o2.getName()) : res1;
        }
    };
    private List<FoodV2> heap = new ArrayList<>();


    public void intiDatabase() {
        heap.add(carrot1);
        heap.add(bread1V2);
        heap.add(bread2V2);
        heap.add(bread3V2);
        heap.add(milk1V2);
        heap.add(chips1V2);
        heap.add(chips2V2);
        StrategyLauncher sl = new StrategyLauncher(new ControlQualityV2(heap, List.of(
                shopV2,
                wareHouseV2,
                wareHouseAdd,
                wareHouseFridge,
                trashV2,
                repFacility)));
        sl.launch();
    }

    /**
     * Testing shop.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then2InShop() {
        intiDatabase();
        List<FoodV2> result = shopV2.getStorage();
        List<FoodV2> expected = new ArrayList<>(Arrays.asList(chips2V2, milk1V2));
        result.sort(cmp);
        expected.sort(cmp);
        Assert.assertThat(result, Is.is(expected));
    }
    /**
     * Testing discount.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then2InShop1withDiscount() {
        intiDatabase();
        Assert.assertThat(shopV2.getStorage().get(1).getDiscount(), Is.is(10));
    }

    /**
     * Testing warehouse.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then1InWare() {
        intiDatabase();
        List<FoodV2> result = wareHouseV2.getStorage();
        Assert.assertThat(result.get(0), Is.is(bread1V2));
    }
    /**
     * Testing warehouseAdditional.
     */
    @Test
    public void whenWHIsFullThen1InWareAdd() {
        intiDatabase();
        List<FoodV2> result = wareHouseAdd.getStorage();
        Assert.assertThat(result.get(0), Is.is(bread2V2));
    }
    /**
     * Testing warehouseFridge.
     */
    @Test
    public void when1VegThen1InWareFridge() {
        intiDatabase();
        List<FoodV2> result = wareHouseFridge.getStorage();
        Assert.assertThat(result.get(0), Is.is(carrot1));
    }
    /**
     * Testing trash.
     */
    @Test
    public void whenOneBelow25OneBetween25And75OneBetween75And100AndOneAbove100Then1InTrash() {
        intiDatabase();
        List<FoodV2> result = trashV2.getStorage();
        Assert.assertThat(result.get(0), Is.is(chips1V2));
    }
    /**
     * Testing reproduction facility.
     */
    @Test
    public void when1ValForTrashButRepThen1InRepFac() {
        intiDatabase();
        List<FoodV2> result = repFacility.getStorage();
        Assert.assertThat(result.get(0), Is.is(bread3V2));
    }
}