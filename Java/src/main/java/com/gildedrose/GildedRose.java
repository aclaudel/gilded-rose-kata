package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];
            ItemWrapper itemWrapper = new ItemWrapper(currentItem);
            if (itemWrapper.itemIsNot("Aged Brie")
                && itemWrapper.itemIsNot("Backstage passes to a TAFKAL80ETC concert")) {
                if (itemWrapper.isAboveMinimumQuality()) {
                    if (itemWrapper.itemIsNot("Sulfuras, Hand of Ragnaros")) {
                        itemWrapper.decreaseQualityValue();
                    }
                }
            } else {
                if (itemWrapper.isBelowMaximumQuality()) {
                    itemWrapper.increaseQualityValue();

                    if (itemWrapper.itemIs("Backstage passes to a TAFKAL80ETC concert")) {
                        itemWrapper.addHypeQuality();
                    }
                }
            }

            if (itemWrapper.itemIsNot("Sulfuras, Hand of Ragnaros")) {
                itemWrapper.decreaseSellInValue();
            }

            if (itemWrapper.isSellInDatePassed()) {
                if (itemWrapper.itemIsNot("Aged Brie")) {
                    if (itemWrapper.itemIsNot("Backstage passes to a TAFKAL80ETC concert")) {
                        if (itemWrapper.isAboveMinimumQuality()) {
                            if (itemWrapper.itemIsNot("Sulfuras, Hand of Ragnaros")) {
                                itemWrapper.decreaseQualityValue();
                            }
                        }
                    } else {
                        itemWrapper.dropQuality();
                    }
                } else {
                    if (itemWrapper.isBelowMaximumQuality()) {
                        itemWrapper.increaseQualityValue();
                    }
                }
            }
        }
    }

}