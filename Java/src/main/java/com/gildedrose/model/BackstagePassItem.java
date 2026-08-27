package com.gildedrose.model;

public class BackstagePassItem extends Item {

    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        int delta = 0;
        if (this.getSellIn() <= 0) {
            this.setQuality(0);
            decrementSellIn();
            return;
        }
        else if (this.getSellIn() >= 11) {
            delta = 1;
        } else if (this.getSellIn() > 6 && this.getSellIn() <= 10) {
            delta = 2;
        } else {
            delta = 3;
        }

        adjustQuality(delta);
        decrementSellIn();

    }
}



