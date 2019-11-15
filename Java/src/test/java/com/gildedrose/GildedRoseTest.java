package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void sellIn_value_decreases_by_1() {
        Item item = new Item("shoes of flying", 10, 10);
        new GildedRose(new Item[]{item}).updateQuality();
        assertEquals(9, item.sellIn);
    }

    @Test
    public void sellIn_doesnt_decrease_with_Sulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        new GildedRose(new Item[]{item}).updateQuality();
        assertEquals(10, item.sellIn);
    }

    @Test
    public void quality_decreases_by_1() {
        Item item = new Item("Unicorn's Kidney", 10, 2);
        new GildedRose(new Item[]{item}).updateQuality();
        assertEquals(1, item.quality);
    }

    @Test
    public void quality_can_not_go_lower_than_0() {
        Item item = new Item("Unicorn's Kidney", 10, 0);
        new GildedRose(new Item[]{item}).updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void quality_doesnt_decrease_with_following_items() {
        quality_doesnt_decrease_for_this_item("Aged Brie");
        quality_doesnt_decrease_for_this_item("Backstage passes to a TAFKAL80ETC concert");
        quality_doesnt_decrease_for_this_item("Sulfuras, Hand of Ragnaros");
    }

    private void quality_doesnt_decrease_for_this_item(String itemName) {
        Item item = new Item(itemName, 10, 10);
        new GildedRose(new Item[]{item}).updateQuality();
        assertTrue(item.quality >= 10);
    }

}
