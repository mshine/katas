package org.mattshine.katas.gildedrose;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            final ItemUpdater updater = ItemUpdater.findItemUpdater(item.name);
            updater.updateItem(item);
        }
    }

}
