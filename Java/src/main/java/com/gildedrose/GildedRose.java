package com.gildedrose;

import com.gildedrose.model.Item;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            item.update();
        }
    }
}
