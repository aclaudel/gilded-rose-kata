package com.gildedrose;

class GildedRose {
    public static final int MAXIMUM_QUALITY = 50;
    public static final int MINIMUM_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];
            if (itemIsNot("Aged Brie", currentItem)
                && itemIsNot("Backstage passes to a TAFKAL80ETC concert", currentItem)) {
                if (isAboveMinimumQuality(currentItem)) {
                    if (itemIsNot("Sulfuras, Hand of Ragnaros", currentItem)) {
                        decreaseQualityValue(currentItem);
                    }
                }
            } else {
                if (isBelowMaximumQuality(currentItem)) {
                    increaseQualityValue(currentItem);

                    if (itemIs("Backstage passes to a TAFKAL80ETC concert", currentItem)) {
                        if (currentItem.sellIn < 11) {
                            if (isBelowMaximumQuality(currentItem)) {
                                increaseQualityValue(currentItem);
                            }
                        }

                        if (currentItem.sellIn < 6) {
                            if (isBelowMaximumQuality(currentItem)) {
                                increaseQualityValue(currentItem);
                            }
                        }
                    }
                }
            }

            if (itemIsNot("Sulfuras, Hand of Ragnaros", currentItem)) {
                decreaseSellInValue(currentItem);
            }

            if (currentItem.sellIn < 0) {
                if (itemIsNot("Aged Brie", currentItem)) {
                    if (itemIsNot("Backstage passes to a TAFKAL80ETC concert", currentItem)) {
                        if (isAboveMinimumQuality(currentItem)) {
                            if (itemIsNot("Sulfuras, Hand of Ragnaros", currentItem)) {
                                decreaseQualityValue(currentItem);
                            }
                        }
                    } else {
                        currentItem.quality = 0;
                    }
                } else {
                    if (isBelowMaximumQuality(currentItem)) {
                        increaseQualityValue(currentItem);
                    }
                }
            }
        }
    }

    private boolean itemIs(String name, Item currentItem) {
        return currentItem.name.equals(name);
    }

    private boolean isBelowMaximumQuality(Item currentItem) {
        return currentItem.quality < MAXIMUM_QUALITY;
    }

    private void increaseQualityValue(Item currentItem) {
        currentItem.quality = currentItem.quality + 1;
    }

    private void decreaseQualityValue(Item item) {
        item.quality -= 1;
    }

    private boolean isAboveMinimumQuality(Item item) {
        return item.quality > MINIMUM_QUALITY;
    }

    private boolean itemIsNot(String itemName, Item item) {
        return !itemIs(itemName, item);
    }

    private void decreaseSellInValue(Item item) {
        item.sellIn -= 1;
    }

}