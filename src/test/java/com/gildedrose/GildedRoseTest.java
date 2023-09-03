package com.gildedrose;

import com.gildedrose.enums.ItemEnum;
import com.gildedrose.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void expect_gilded_rose_update_all_items() {
        Item[] items = new Item[] {
            new Item("Leomon's Crest", 2, 50),
            new Item("Holy Ring", 5, 10),
            new Item(ItemEnum.CONJURED.getItemName(), 2, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
        assertEquals(9, app.items[1].quality);
        assertEquals(8, app.items[2].quality);
    }

}
