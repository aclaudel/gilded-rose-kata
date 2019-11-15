package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String UNICORN = "Unicorn's Kidney";
    Item item;

    @Test
    public void sellIn_value_decreases_by_1() {
        given_a_new_item(UNICORN, 10, 10);
        when_the_items_are_updated();
        then_the_sellin_value_is(9);
    }

    @Test
    public void sellIn_doesnt_decrease_with_Sulfuras() {
        given_a_new_item(SULFURAS, 10, 10);
        when_the_items_are_updated();
        then_the_sellin_value_is(10);
    }

    @Test
    public void quality_decreases_by_1() {
        given_a_new_item(UNICORN, 10, 2);
        when_the_items_are_updated();
        then_the_quality_is(1);
    }

    @Test
    public void quality_can_not_go_lower_than_0() {
        given_a_new_item(UNICORN, 10, 0);
        when_the_items_are_updated();
        then_the_quality_is(0, item.quality);
    }

    @Test
    public void quality_doesnt_decrease_with_following_items_with_positive_sellin() {
        quality_doesnt_decrease_for_this_item(AGED_BRIE);
        quality_doesnt_decrease_for_this_item(BACKSTAGE);
        quality_doesnt_decrease_for_this_item(SULFURAS);
    }

    @Test
    public void quality_increases_for_aged_brie_by_1() {
        given_a_new_item(AGED_BRIE,10,20);
        when_the_items_are_updated();
        then_the_quality_is(21);
    }

    @Test
    public void quality_increases_for_backstage() {
        given_a_new_item(BACKSTAGE,12,20);
        when_the_items_are_updated();
        then_the_quality_is(21);

        given_a_new_item(BACKSTAGE,10,20);
        when_the_items_are_updated();
        then_the_quality_is(22);

        given_a_new_item(BACKSTAGE,5,20);
        when_the_items_are_updated();
        then_the_quality_is(23);
    }

    @Test
    public void quality_decreases_twice_when_sellin_is_negative_value() {
        given_a_new_item(UNICORN, -1, 10);
        when_the_items_are_updated();
        then_the_quality_is(8);
    }

    @Test
    public void quality_does_increase_when_sellin_is_negative_for_aged_brie() {
        given_a_new_item(AGED_BRIE, -1, 10);
        when_the_items_are_updated();
        then_the_quality_is(12);
    }

    @Test
    public void quality_drops_to_zero_when_the_sellin_is_zero_or_less_for_backstage() {
        given_a_new_item(BACKSTAGE, -1, 10);
        when_the_items_are_updated();
        then_the_quality_is(0);
    }

    @Test
    public void quality_doesnt_decrease_for_sulfuras_with_negative_sellin() {
        given_a_new_item(SULFURAS, -1, 80);
        when_the_items_are_updated();
        then_the_quality_is(80);
    }

    private void then_the_sellin_value_is(int expectedSellIn) {
        assertEquals(expectedSellIn, item.sellIn);
    }

    private void when_the_items_are_updated() {
        new GildedRose(new Item[]{item}).updateItems();
    }

    private void then_the_quality_is(int expectedQuality) {
        assertEquals(expectedQuality, item.quality);
    }

    private void then_the_quality_is(int i, int quality) {
        assertEquals(i, quality);
    }

    private void quality_doesnt_decrease_for_this_item(String itemName) {
        given_a_new_item(itemName, 10, 10);
        when_the_items_are_updated();
        assertTrue(item.quality >= 10);
    }

    private void given_a_new_item(String itemName, int sellIn, int quality) {
        item = new Item(itemName, sellIn, quality);
    }
}
