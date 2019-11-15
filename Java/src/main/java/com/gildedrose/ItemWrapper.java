package com.gildedrose;

public class ItemWrapper {
    public static final int MAXIMUM_QUALITY = 50;
    public static final int MINIMUM_QUALITY = 0;
    private Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    void dropQuality() {
        item.quality = 0;
    }

    void addHypeQuality() {
        if (item.sellIn < 11) {
            if (isBelowMaximumQuality()) {
                increaseQualityValue();
            }
        }

        if (item.sellIn < 6) {
            if (isBelowMaximumQuality()) {
                increaseQualityValue();
            }
        }
    }

    boolean isSellInDatePassed() {
        return item.sellIn < 0;
    }

    boolean itemIs(String name) {
        return item.name.equals(name);
    }

    boolean isBelowMaximumQuality() {
        return item.quality < MAXIMUM_QUALITY;
    }

    void increaseQualityValue() {
        item.quality = item.quality + 1;
    }

    void decreaseQualityValue() {
        item.quality -= 1;
    }

    boolean isAboveMinimumQuality() {
        return item.quality > MINIMUM_QUALITY;
    }

    boolean itemIsNot(String itemName) {
        return !itemIs(itemName);
    }

    void decreaseSellInValue() {
        item.sellIn -= 1;
    }
}