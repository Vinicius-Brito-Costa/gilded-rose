package com.gildedrose.updater;

import com.gildedrose.item.Item;

public class BackstagePassesUpdate extends ItemUpdate {
    private static final int LIMIT = 50;
    @Override
    public void updateQuality(Item item) {
        if(item.sellIn <= 0){
            item.quality = 0;
        }
        else {
            increaseQuality(item, getTimeWindowMultiplier(item) * qualityIncreaseDecreaseValue(item), LIMIT);
        }
    }

    private int getTimeWindowMultiplier(Item item){
        int sellInTimeWindowMultiplier = 1;
        if(item.sellIn <= 10){
            sellInTimeWindowMultiplier++;
        }
        if(item.sellIn <= 5){
            sellInTimeWindowMultiplier++;
        }
        return sellInTimeWindowMultiplier;
    }
}
