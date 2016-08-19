package org.mattshine.katas.gildedrose;


import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.Collections.unmodifiableSet;
import static java.util.stream.Collectors.toSet;

public enum ItemUpdater {
    SULFURAS(matchingNames(
            ItemNames.SULFURAS.name
    )) {
        @Override
        public void updateItem(Item item) {
            // Do Nothing
        }
    },
    AGED_BRIE(matchingNames(
            ItemNames.AGED_BRIE.name
    )) {
        @Override
        public void updateItem(Item item) {
            item.sellIn--;
            increaseQuality(item);
        }
    },
    BACKSTAGE_CONCERT(matchingNames(
            ItemNames.BACKSTAGE_CONCERT.name
    )) {
        @Override
        public void updateItem(Item item) {
            item.sellIn--;

            increaseQuality(item);

            if (item.sellIn < 11) increaseQuality(item);
            if (item.sellIn < 6) increaseQuality(item);
            if (item.sellIn < 0) item.quality = 0;
        }
    },
    OTHER(Collections.emptySet()) {
        @Override
        public void updateItem(Item item) {
            item.sellIn--;
            decreaseQuality(item);

            if (item.sellIn < 0) decreaseQuality(item);
        }
    };

    private final Set<String> names;

    ItemUpdater(Set<String> names) {
        this.names = names;
    }

    private static Set<String> matchingNames(String... names) {
        return unmodifiableSet(stream(names).collect(toSet()));
    }

    static ItemUpdater findItemUpdater(String itemName) {
        final Set<ItemUpdater> enumSet = EnumSet.allOf(ItemUpdater.class);
        enumSet.remove(OTHER);
        return enumSet.stream()
                .filter(itemUpdater -> itemUpdater.names.contains(itemName))
                .findFirst()
                .orElse(OTHER);
    }

    public abstract void updateItem(Item item);

    void decreaseQuality(Item item) {
        if (item.quality > 0) item.quality--;
    }

    void increaseQuality(Item item) {
        if (item.quality < 50) item.quality++;
    }
}
