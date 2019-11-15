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

                if (STANDARD) {
                    if (quality > 0)
                        decrease quality
                    decrease sellin
                    if (sellin < 0)
                        decrease quality
                }

                if(BRIE){
                    if (quality < 50)
                        increase quality
                    decrease sellin
                    if sellin < 0 && quality < 50
                        increase quality
                }
             */
            if (itemWrapper.itemIs("Sulfuras, Hand of Ragnaros")){
                continue;
            }
            if (itemWrapper.itemIs("Backstage passes to a TAFKAL80ETC concert")) {
                if (itemWrapper.isBelowMaximumQuality()){
                    itemWrapper.increaseQualityValue();
                    itemWrapper.addHypeQuality();
                }
                itemWrapper.decreaseSellInValue();
                if (itemWrapper.isSellInDatePassed()) {
                    itemWrapper.dropQuality();
                }
                continue;
            }
            if( itemWrapper.itemIs("Aged Brie")){
                if (itemWrapper.isBelowMaximumQuality()) {
                    itemWrapper.increaseQualityValue();
                }
                itemWrapper.decreaseSellInValue();
                if (itemWrapper.isSellInDatePassed() && itemWrapper.isBelowMaximumQuality()){
                    itemWrapper.increaseQualityValue();
                }
                continue;
            }

            // Standard Object
            if (itemWrapper.isAboveMinimumQuality()) {
                itemWrapper.decreaseQualityValue();
            }
            itemWrapper.decreaseSellInValue();
            if (itemWrapper.isSellInDatePassed()) {
                if (itemWrapper.isAboveMinimumQuality()) {
                    itemWrapper.decreaseQualityValue();
                }
            }

        }
    }

}