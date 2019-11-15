package com.gildedrose;

public class AgedBrie extends ItemWrapper {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    void update() {
        if (isBelowMaximumQuality()) {
            increaseQualityValue();
        }
        decreaseSellInValue();
        if (isSellInDatePassed() && isBelowMaximumQuality()){
            increaseQualityValue();
        }
    }
}