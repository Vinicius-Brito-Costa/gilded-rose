package com.gildedrose.item;

import com.gildedrose.enums.ItemEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    void expect_item_render_correct_values_in_to_string() {
        Item item = new Item(ItemEnum.SULFURAS.getItemName(), 2, 80);
        assertEquals("Sulfuras, 2, 80", item.toString());
    }
}
