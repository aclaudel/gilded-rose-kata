package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];
            if (itemIsNot("Aged Brie", currentItem)
                && itemIsNot("Backstage passes to a TAFKAL80ETC concert", currentItem)) {
                if (qualityIsGreaterThanZero(currentItem)) {
                    if (itemIsNot("Sulfuras, Hand of Ragnaros", currentItem)) {
                        decreaseQualityValue(currentItem);
                    }
                }
            } else {
                if (currentItem.quality < 50) {
                    currentItem.quality = currentItem.quality + 1;

                    if (currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (currentItem.sellIn < 11) {
                            if (currentItem.quality < 50) {
                                currentItem.quality = currentItem.quality + 1;
                            }
                        }

                        if (currentItem.sellIn < 6) {
                            if (currentItem.quality < 50) {
                                currentItem.quality = currentItem.quality + 1;
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
                        if (qualityIsGreaterThanZero(currentItem)) {
                            if (itemIsNot("Sulfuras, Hand of Ragnaros", currentItem)) {
                                decreaseQualityValue(currentItem);
                            }
                        }
                    } else {
                        currentItem.quality = currentItem.quality - currentItem.quality;
                    }
                } else {
                    if (currentItem.quality < 50) {
                        currentItem.quality = currentItem.quality + 1;
                    }
                }
            }
        }
    }

    private void decreaseQualityValue(Item item) {
        item.quality -= 1;
    }

    private boolean qualityIsGreaterThanZero(Item item) {
        return item.quality > 0;
    }

    private boolean itemIsNot(String itemName, Item item) {
        return !item.name.equals(itemName);
    }

    private void decreaseSellInValue(Item item) {
        item.sellIn -= 1;
    }

}