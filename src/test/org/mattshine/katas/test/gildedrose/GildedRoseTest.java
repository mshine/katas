package org.mattshine.katas.test.gildedrose;

import org.junit.Test;
import org.mattshine.katas.gildedrose.GildedRose;
import org.mattshine.katas.gildedrose.Item;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    /*

    - Once the sell by date has passed, Quality degrades twice as fast
	- The Quality of an item is never negative
	- "Aged Brie" actually increases in Quality the older it gets
	- The Quality of an item is never more than 50
	- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	Quality drops to 0 after the concert
     */

    @Test
    public void checkItemNameIsCorrect() {
        Item[] items = new Item[]{
                new Item("foo", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, equalTo("foo"));
    }

    @Test
    public void checkQualityOfAnItemIsNeverNegative() {
        Item[] items = new Item[]{
                new Item("foo", 2, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, equalTo(0));
    }

    @Test
    public void checkQualityOfAnItemNeverExceeds50() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 3, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, equalTo(50));
    }

    @Test
    public void checkAgedBrieIncreasesInQualityTheOlderItGets() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 3, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, equalTo(2));
        assertThat(app.items[0].sellIn, equalTo(2));
        app.updateQuality();
        assertThat(app.items[0].quality, equalTo(3));
        assertThat(app.items[0].sellIn, equalTo(1));
    }

    @Test
    public void checkBackstagePassesIncreasesInQualityWhenSellInHasMoreThan10DaysLeft() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, equalTo(11));
        assertThat(app.items[0].quality, equalTo(21));
    }

    @Test
    public void checkBackstagePassesIncreasesInQualityWhenSellInHas10DaysOrLessButMoreThan5DaysLeft() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, equalTo(9));
        assertThat(app.items[0].quality, equalTo(22));
    }

    @Test
    public void checkBackstagePassesIncreasesInQualityWhenSellInHas5DaysOrLessLeft() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, equalTo(4));
        assertThat(app.items[0].quality, equalTo(23));
    }

    @Test
    public void checkBackstagePassesQualityDropsToZeroWhenSellInIs0() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, equalTo(-1));
        assertThat(app.items[0].quality, equalTo(0));
    }

    @Test
    public void checkSulfurasNeverDecreasesInQuality() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 3, 80)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, equalTo(80));

    }

    @Test
    public void checkOnceSellInDateHasPassedQualityDegradesTwiceAsFast() {
        Item[] items = new Item[]{
                new Item("foo", 0, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, equalTo(-1));
        assertThat(app.items[0].quality, equalTo(18));
    }
}
