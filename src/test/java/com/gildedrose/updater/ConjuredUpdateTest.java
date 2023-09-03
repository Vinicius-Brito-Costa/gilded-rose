package com.gildedrose.updater;

import com.gildedrose.enums.ItemEnum;
import com.gildedrose.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredUpdateTest {
    @Test
    void expect_conjured_quality_to_decrease_by_two() {
        Item item = new Item(ItemEnum.CONJURED.getItemName(), 2, 50);

        ConjuredUpdate updater = new ConjuredUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(48, item.quality);
    }

    @Test
    void expect_conjured_quality_to_decrease_double_when_sell_in_is_negative() {
        Item item = new Item(ItemEnum.CONJURED.getItemName(), -2, 10);

        ConjuredUpdate updater = new ConjuredUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(6, item.quality);
    }
}
