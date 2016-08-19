package org.mattshine.katas.gildedrose;

/**
 * Created by pivotal on 8/19/16.
 */
enum ItemNames {
    AGED_BRIE("Aged Brie"),
    ELIXIR_MONGOOSE("Elixir of the Mongoose"),
    DEXTERITY_VEST("+5 Dexterity Vest"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_CONCERT("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED_MANA_CAKE("Conjured Mana Cake");


    public final String name;

    ItemNames(String name) {
        this.name = name;
    }
}
