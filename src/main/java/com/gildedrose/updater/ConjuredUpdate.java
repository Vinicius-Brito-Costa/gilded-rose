package com.gildedrose.updater;

import com.gildedrose.item.Item;

public class ConjuredUpdate extends ItemUpdate{
    @Override
    public void updateQuality(Item item) {
        decreaseQuality(item, 2 * qualityIncreaseDecreaseValue(item));
    }
}
