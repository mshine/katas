package org.mattshine.katas.gildedrose;

import static org.mattshine.katas.gildedrose.ItemNames.*;
import static org.mattshine.katas.gildedrose.ItemNames.SULFURAS;

public class TexttestFixture {
    public static void main(String[] args) {

        Item[] items = new Item[] {
                new Item(DEXTERITY_VEST.name, 10, 20), //
                new Item(AGED_BRIE.name, 2, 0), //
                new Item(ELIXIR_MONGOOSE.name, 5, 7), //
                new Item(SULFURAS.name, 0, 80), //
                // -1 sellin???? never has to be sold??
                new Item(SULFURAS.name, -1, 80),
                new Item(BACKSTAGE_CONCERT.name, 15, 20),
                new Item(BACKSTAGE_CONCERT.name, 10, 49),
                new Item(BACKSTAGE_CONCERT.name, 5, 49),
                // this conjured item does not work properly yet
                new Item(CONJURED_MANA_CAKE.name, 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}

