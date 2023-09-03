package com.gildedrose.updater;

import com.gildedrose.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesUpdateTest {

    private static final String BACKSTAGE_ITEM_NAME_EXAMPLE = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void expect_item_quality_to_stay_at_fifth() {
        Item item = new Item(BACKSTAGE_ITEM_NAME_EXAMPLE, 1, 50);

        BackstagePassesUpdate updater = new BackstagePassesUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(50, item.quality);
    }

    @Test
    void expect_backstage_passes_quality_to_increase_by_two_when_sell_in_is_equal_or_bellow_ten() {
        Item[] items = new Item[] {
            new Item(BACKSTAGE_ITEM_NAME_EXAMPLE, 10, 20),
            new Item(BACKSTAGE_ITEM_NAME_EXAMPLE, 6, 18),
        };

        BackstagePassesUpdate updater = new BackstagePassesUpdate();
        updater.updateQuality(items[0]);
        updater.updateSellIn(items[0]);
        updater.updateQuality(items[1]);
        updater.updateSellIn(items[1]);

        assertEquals(22, items[0].quality);
        assertEquals(20, items[1].quality);
    }

    @Test
    void expect_backstage_passes_quality_to_increase_by_three_when_sell_in_is_equal_or_bellow_five() {
        Item[] items = new Item[] {
            new Item(BACKSTAGE_ITEM_NAME_EXAMPLE, 5, 20),
            new Item(BACKSTAGE_ITEM_NAME_EXAMPLE, 4, 18)
        };

        BackstagePassesUpdate updater = new BackstagePassesUpdate();
        updater.updateQuality(items[0]);
        updater.updateSellIn(items[0]);
        updater.updateQuality(items[1]);
        updater.updateSellIn(items[1]);

        assertEquals(23, items[0].quality);
        assertEquals(21, items[1].quality);
    }

    @Test
    void expect_backstage_passes_quality_to_be_zero_when_sell_in_hits_zero_after_update_quality() {
        Item[] items = new Item[] {
            new Item(BACKSTAGE_ITEM_NAME_EXAMPLE, 0, 50),
            new Item(BACKSTAGE_ITEM_NAME_EXAMPLE, -1, 50)
        };

        BackstagePassesUpdate updater = new BackstagePassesUpdate();
        updater.updateQuality(items[0]);
        updater.updateSellIn(items[0]);
        updater.updateQuality(items[1]);
        updater.updateSellIn(items[1]);

        assertEquals(0, items[0].quality);
        assertEquals(0, items[1].quality);
    }
}
