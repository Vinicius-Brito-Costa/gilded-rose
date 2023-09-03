package com.gildedrose;

import com.gildedrose.enums.ItemEnum;
import com.gildedrose.item.Item;
import com.gildedrose.updater.ItemUpdate;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            ItemUpdate updater = ItemEnum.getUpdater(items[i]);
            updater.updateQuality(items[i]);
            updater.updateSellIn(items[i]);
        }
    }
}
