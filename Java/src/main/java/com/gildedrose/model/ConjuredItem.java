package com.gildedrose.model;

import com.gildedrose.utils.GildedRoseUtils;

public class ConjuredItem extends Item {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        int delta = (this.getSellIn() <= 0) ?
            -GildedRoseUtils.EXPIRED_DAILY_QUALITY_CHANGE_RATE :
            -GildedRoseUtils.NORMAL_DAILY_QUALITY_CHANGE_RATE;

        delta *= GildedRoseUtils.CONJURED_ITEM_QUALITY_CHANGE_RATE;
        adjustQuality(delta);
        decrementSellIn();
    }


}
