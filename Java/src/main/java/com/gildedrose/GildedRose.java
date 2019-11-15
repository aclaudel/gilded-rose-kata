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

            if (itemWrapper.itemIs("Sulfuras, Hand of Ragnaros")){
                updateSulfuras();
                continue;
            }

            if (itemWrapper.itemIs("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstage(itemWrapper);
                continue;
            }

            if( itemWrapper.itemIs("Aged Brie")){
                new AgedBrie(currentItem).update();
                continue;
            }

            itemWrapper.update();
        }
    }

    private void updateSulfuras() {

    }

    private void updateBackstage(ItemWrapper itemWrapper) {
        if (itemWrapper.isBelowMaximumQuality()){
            itemWrapper.increaseQualityValue();
            itemWrapper.addHypeQuality();
        }
        itemWrapper.decreaseSellInValue();
        if (itemWrapper.isSellInDatePassed()) {
            itemWrapper.dropQuality();
        }
    }

}