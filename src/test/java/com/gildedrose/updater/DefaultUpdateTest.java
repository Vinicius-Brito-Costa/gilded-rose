package com.gildedrose.updater;

import com.gildedrose.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultUpdateTest {

    @Test
    void expect_item_sell_in_decreases() {
        Item item = new Item("foo", 2, 0);

        DefaultUpdate updater = new DefaultUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(1, item.sellIn);
    }

    @Test
    void expect_item_sell_in_decreases_bellow_zero() {
        Item item = new Item("foo", 0, 0);

        DefaultUpdate updater = new DefaultUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(-1, item.sellIn);
    }

    @Test
    void expect_item_quality_does_not_go_lower_than_zero() {
        Item item = new Item("foo", 0, 0);

        DefaultUpdate updater = new DefaultUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(0, item.quality);
    }

    @Test
    void expect_item_quality_would_have_decreased() {
        Item item = new Item("foo", 1, 20);

        DefaultUpdate updater = new DefaultUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(19, item.quality);
    }

    @Test
    void expect_item_quality_would_have_decreased_two_times_when_sell_in_is_negative() {
        Item item = new Item("foo", -3, 7);

        DefaultUpdate updater = new DefaultUpdate();
        updater.updateQuality(item);
        updater.updateSellIn(item);

        assertEquals(5, item.quality);
    }
}
