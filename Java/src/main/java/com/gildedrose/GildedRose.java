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

            /*
                if(BRIE){
                    if (quality < 50)
                        increase quality
                    decrease sellin
                    if sellin < 0 && quality < 50
                        increase quality
                }

                if (SULFURAS)
                {}

                if (BACKSTAGE){
                    if (quality < 50)
                        increase quality
                        increase hype
                    decrease sellin
                    if (sellDatePassed)
                        quality 0
                }

                if (STANDARD) {
                    if (quality > 0)
                        decrease quality
                    decrease sellin
                    if (sellin < 0)
                        decrease quality
                }

             */
            if (itemWrapper.itemIs("Sulfuras, Hand of Ragnaros")){
                continue;
            }
            if (itemWrapper.itemIsNot("Aged Brie")
                && itemWrapper.itemIsNot("Backstage passes to a TAFKAL80ETC concert")) {
                if (itemWrapper.isAboveMinimumQuality()) {
                    itemWrapper.decreaseQualityValue();
                }
            } else {
                if (itemWrapper.isBelowMaximumQuality()) {
                    itemWrapper.increaseQualityValue();

                    if (itemWrapper.itemIs("Backstage passes to a TAFKAL80ETC concert")) {
                        itemWrapper.addHypeQuality();
                    }
                }
            }

            itemWrapper.decreaseSellInValue();

            if (itemWrapper.isSellInDatePassed()) {
                if (itemWrapper.itemIsNot("Aged Brie")) {
                    if (itemWrapper.itemIsNot("Backstage passes to a TAFKAL80ETC concert")) {
                        if (itemWrapper.isAboveMinimumQuality()) {
                            itemWrapper.decreaseQualityValue();
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