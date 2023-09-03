package com.gildedrose.updater;

import com.gildedrose.item.Item;

public class DefaultUpdate extends ItemUpdate {
    @Override
    public void updateQuality(Item item) {
        decreaseQuality(item, qualityIncreaseDecreaseValue(item));
    }
}
