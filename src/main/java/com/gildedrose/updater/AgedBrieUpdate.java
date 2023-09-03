package com.gildedrose.updater;

import com.gildedrose.item.Item;

public class AgedBrieUpdate extends ItemUpdate {
    @Override
    public void updateQuality(Item item) {
        if(item.quality < 50){
            increaseQuality(item, qualityIncreaseDecreaseValue(item), 50);
        }
    }
}
