package com.gildedrose.updater;

import com.gildedrose.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasUpdateTest {

    private static final String SULFURAS_ITEM_NAME_EXAMPLE = "Sulfuras, Hand of Ragnaros";

    @Test
    void expect_sulfuras_sell_in_does_not_decreases() {
        Item item = new Item(SULFURAS_ITEM_NAME_EXAMPLE, 20, 80);

        SulfurasUpdate updater = new SulfurasUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(20, item.sellIn);
    }

    @Test
    void expect_sulfuras_quality_to_stay_at_eighty_after_update_quality() {
        Item[] items = new Item[] {
            new Item(SULFURAS_ITEM_NAME_EXAMPLE, 1, 80),
            new Item(SULFURAS_ITEM_NAME_EXAMPLE, -1, 80)
        };

        SulfurasUpdate updater = new SulfurasUpdate();
        updater.updateQuality(items[0]);
        updater.updateSellIn(items[0]);
        updater.updateQuality(items[1]);
        updater.updateSellIn(items[1]);

        assertEquals(80, items[0].quality);
        assertEquals(80, items[1].quality);
    }
}
