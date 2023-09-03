package com.gildedrose.updater;

import com.gildedrose.enums.ItemEnum;
import com.gildedrose.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieUpdateTest {
    @Test
    void expect_aged_brie_quality_would_have_increased_instead_of_decreasing() {
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 1, 1);

        AgedBrieUpdate updater = new AgedBrieUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(2, item.quality);
    }

    @Test
    void expect_aged_brie_quality_would_have_increased_two_times_with_negative_sell_in() {
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), -2, 10);

        AgedBrieUpdate updater = new AgedBrieUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(12, item.quality);
    }

    @Test
    void expect_item_quality_to_stay_at_fifth() {
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 1, 50);

        AgedBrieUpdate updater = new AgedBrieUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(50, item.quality);
    }
}
