package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void sellIn_value_decreases_when_not_Sulfuras() {
        Item item = new Item("shoes of flying", 10, 10);
        new GildedRose(new Item[]{item}).updateQuality();
        assertEquals(9, item.quality);
    }

    @Test
    public void sellIn_doesnt_decrease_with_Sulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        new GildedRose(new Item[]{item}).updateQuality();
        assertEquals(10, item.quality);
    }

}
