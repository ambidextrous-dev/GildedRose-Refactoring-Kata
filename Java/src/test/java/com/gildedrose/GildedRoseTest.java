package com.gildedrose;

import com.gildedrose.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private GildedRose createApp(Item item) {
        return createApp(item, 1);
    }

    private GildedRose createApp(Item item, int days) {
        GildedRose app = new GildedRose(new Item[]{item});
        for (int i = 0; i < days; i++) app.updateQuality();
        return app;
    }

    @Test
    void shouldBeAbleToAddNormalItem() {
        GildedRose app = createApp(new NormalItem("foo", 0, 0));
        assertEquals("foo", app.items[0].getName());
    }

    @Test
    void sellInDateShouldDecrementForNormalItem() {
        GildedRose app = createApp(new NormalItem("rice", 1, 1));
        assertEquals(0, app.items[0].getSellIn());
    }

    @Test
    void qualityShouldDecrementForNormalItem() {
        GildedRose app = createApp(new NormalItem("rice", 1, 1));
        assertEquals(0, app.items[0].getQuality());
    }

    @Test
    void qualityShouldDegradeTwiceAsFastForExpiredItem() {
        GildedRose app = createApp(new NormalItem("rice", 1, 10), 2);
        assertEquals(7, app.items[0].getQuality());
    }

    @Test
    void qualityShouldNotBecomeNegative() {
        GildedRose app = createApp(new NormalItem("rice", 1, 1), 2);
        assertEquals(0, app.items[0].getQuality());
    }

    @Test
    void shouldIncreaseQualityForAgedBrie() {
        GildedRose app = createApp(new AgedBrieItem("Aged Brie", 1, 10));
        assertEquals(11, app.items[0].getQuality());
    }

    @Test
    void shouldDoubleQualityIncreaseForExpiredAgedBrie() {
        GildedRose app = createApp(new AgedBrieItem("Aged Brie", 0, 10));
        assertEquals(12, app.items[0].getQuality());
    }

    @Test
    void shouldNotIncreaseQualityOver50() {
        GildedRose app = createApp(new AgedBrieItem("Aged Brie", 1, 49), 2);
        assertEquals(50, app.items[0].getQuality());
    }

    @Test
    void shouldNotDecreaseQualityForSulfuras() {
        GildedRose app = createApp(new SulfurasItem("Sulfuras, Hand of Ragnaros", 10, 80));
        assertEquals(80, app.items[0].getQuality());
    }

    @Test
    void shouldNotDecreaseSellInForSulfuras() {
        GildedRose app = createApp(new SulfurasItem("Sulfuras, Hand of Ragnaros", 10, 80));
        assertEquals(10, app.items[0].getSellIn());
    }

    @Test
    void shouldIncreaseQualityForBackstagePassesBefore10Days() {
        GildedRose app = createApp(new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 11, 11));
        assertEquals(12, app.items[0].getQuality());
    }

    @Test
    void shouldDoubleQualityIncreaseForBackstagePassesForLessThan10Days() {
        GildedRose app = createApp(new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 10, 10));
        assertEquals(12, app.items[0].getQuality());
    }

    @Test
    void shouldTripleQualityIncreaseForBackstagePassesForLessThan5Days() {
        GildedRose app = createApp(new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 10));
        assertEquals(13, app.items[0].getQuality());
    }

    @Test
    void shouldDropQualityToZeroAfterConcert() {
        GildedRose app = createApp(new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 1, 10), 2);
        assertEquals(0, app.items[0].getQuality());
    }

    @Test
    void shouldDecreaseQualityByTwoForConjuredItems() {
        GildedRose app = createApp(new ConjuredItem("Conjured", 1, 10));
        assertEquals(8, app.items[0].getQuality());
    }

    @Test
    void shouldDecreaseQualityByTwoForConjuredItemsExpired() {
        GildedRose app = createApp(new ConjuredItem("Conjured Mana Cake", 0, 10));
        assertEquals(6, app.items[0].getQuality());
    }

}
