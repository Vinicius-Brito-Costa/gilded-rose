package com.gildedrose.enums;

import com.gildedrose.item.Item;
import com.gildedrose.updater.*;

public enum ItemEnum {
    DEFAULT("default", new DefaultUpdate()),
    AGED_BRIE("Aged Brie", new AgedBrieUpdate()),
    BACKSTATE("Backstage passes", new BackstagePassesUpdate()),
    SULFURAS("Sulfuras", new SulfurasUpdate()),
    CONJURED("Conjured", new ConjuredUpdate());

    private String itemName;
    private ItemUpdate update;

    ItemEnum(String itemName, ItemUpdate update){
        this.itemName = itemName;
        this.update = update;
    }

    public String getItemName(){
        return itemName;
    }
    public static ItemUpdate getUpdater(Item item){
        for(ItemEnum key : ItemEnum.values()){
            if(item.name.startsWith(key.itemName)){
                return key.update;
            }
        }
        return DEFAULT.update;
    }
}
