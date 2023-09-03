package com.gildedrose.updater;

import com.gildedrose.item.Item;

public abstract class ItemUpdate {
    public abstract void updateQuality(Item item);

    public void updateSellIn(Item item) {
        item.sellIn--;
    }

    int qualityIncreaseDecreaseValue(Item item){
        return item.sellIn < 0 ? 2 : 1;
    }

    void increaseQuality(Item item, int value, int limit){
        if((item.quality + value) < limit){
            item.quality += value;
        }
        else {
            item.quality = limit;
        }
    }

    void decreaseQuality(Item item, int value){
        if((item.quality - value) >= 0){
            item.quality -= value;
        }
        else {
            item.quality = 0;
        }
    }
}
