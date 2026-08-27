package com.gildedrose;

import com.gildedrose.model.*;
import com.gildedrose.utils.GildedRoseUtils;

public class ItemFactory {

    public static Item create(String name, int sellIn, int quality) {
        if (name.equals(GildedRoseUtils.AGED_BRIE))
            return new AgedBrieItem(name, sellIn, quality);
        if (name.startsWith(GildedRoseUtils.CONJURED_PREFIX))
            return new ConjuredItem(name, sellIn, quality);
        if (name.startsWith(GildedRoseUtils.BACKSTAGE_PASSES_PREFIX))
            return new BackstagePassItem(name, sellIn, quality);
        if (name.equals(GildedRoseUtils.SULFURAS_PREFIX))
            return new SulfurasItem(name, sellIn, quality);
        return new NormalItem(name, sellIn, quality);
    }


}
