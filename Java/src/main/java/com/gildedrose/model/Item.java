package com.gildedrose.model;

public abstract class Item {

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    private String name;

    private int sellIn;

    private int quality;


    public String getName() {
        return this.name;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }

    protected void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public abstract void update();

    protected void adjustQuality(int delta){
        this.quality = Math.max(0, Math.min(50, this.quality + delta));
    }

    protected void decrementSellIn(){
        this.sellIn -= 1;
    }
}
