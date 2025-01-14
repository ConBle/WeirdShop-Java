package training.weirdshop;

import org.junit.Test;
import static org.junit.Assert.*;

public class RegressionTest {
    @Test
    public void testGoldCoinQualityBeforeSellBy() {
        Item goldCoin = new Item("Gold Coin", 20, 80);
        Item[] items = {goldCoin};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 20, goldCoin.sellIn);
        assertEquals( 80, goldCoin.quality);
    }

    @Test
    public void testGoldCoinQualityOnSellBy() {
        Item goldCoin = new Item("Gold Coin", 0, 80);
        Item[] items = {goldCoin};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 0, goldCoin.sellIn);
        assertEquals( 80, goldCoin.quality);
    }

    @Test
    public void testAgedBrieQualityLessBeforeSellBy() {
        Item agedBrie = new Item("Aged Brie", 5, 20);
        Item[] items = {agedBrie};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 4, agedBrie.sellIn);
        assertEquals(21, agedBrie.quality);
    }

    @Test
    public void testAgedBrieQualityOnSellBy() {
        Item agedBrie = new Item("Aged Brie", 0, 20);
        Item[] items = {agedBrie};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( -1, agedBrie.sellIn);
        assertEquals(22, agedBrie.quality);
    }

    @Test
    public void testAgedBrieCannotExceedQuality50(){
        Item agedBrie = new Item("Aged Brie", -5, 49);
        Item[] items = {agedBrie};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( -6, agedBrie.sellIn);
        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void testBackstagePassQuality11DaysBeforeSellBy() {
        Item backstagePass = new Item("Backstage Pass", 12, 20);
        Item[] items = {backstagePass};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 11, backstagePass.sellIn);
        assertEquals(21, backstagePass.quality);
    }

    @Test
    public void testBackstagePassQuality10DaysBeforeSellBy() {
        Item backstagePass = new Item("Backstage Pass", 11, 20);
        Item[] items = {backstagePass};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 10, backstagePass.sellIn);
        assertEquals(22, backstagePass.quality);
    }

    @Test
    public void testBackstagePassQuality6DaysBeforeSellBy() {
        Item backstagePass = new Item("Backstage Pass", 7, 20);
        Item[] items = {backstagePass};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 6, backstagePass.sellIn);
        assertEquals(22, backstagePass.quality);
    }

    @Test
    public void testBackstagePassQuality5DaysBeforeSellBy() {
        Item backstagePass = new Item("Backstage Pass", 6, 20);
        Item[] items = {backstagePass};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 5, backstagePass.sellIn);
        assertEquals(23, backstagePass.quality);
    }

    @Test
    public void testBackstagePassQuality0DaysBeforeSellBy() {
        Item backstagePass = new Item("Backstage Pass", 1, 20);
        Item[] items = {backstagePass};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 0, backstagePass.sellIn);
        assertEquals(23, backstagePass.quality);
    }

    @Test
    public void testBackstagePassQualityAfterSellBy() {
        Item backstagePass = new Item("Backstage Pass", 0, 20);
        Item[] items = {backstagePass};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( -1, backstagePass.sellIn);
        assertEquals(0, backstagePass.quality);
    }

    @Test
    public void testBackStagePassCannotExceedQuality50(){
        Item backstagePass = new Item("Backstage Pass", 3, 49);
        Item[] items = {backstagePass};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 2, backstagePass.sellIn);
        assertEquals(50, backstagePass.quality);
    }

    @Test
    public void testRegularItemBeforeSellBy() {
        Item regularItem = new Item("Regular Item", 5, 20);
        Item[] items = {regularItem};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 4, regularItem.sellIn);
        assertEquals(19, regularItem.quality);
    }

    @Test
    public void testRegularItemOnSellBy() {
        Item regularItem = new Item("Regular Item", 0, 20);
        Item[] items = {regularItem};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( -1, regularItem.sellIn);
        assertEquals(18, regularItem.quality);
    }

    @Test
    public void test1RegularItemQualityCannotBeLessThan0() {
        Item regularItem = new Item("Regular Item", 0, 1);
        Item[] items = {regularItem};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( -1, regularItem.sellIn);
        assertEquals(0, regularItem.quality);
    }

    @Test
    public void test2RegularItemQualityCannotBeLessThan0() {
        Item regularItem = new Item("Regular Item", 5, 0);
        Item[] items = {regularItem};
        WeirdShop shop = new WeirdShop(items);
        shop.updateQuality();

        assertEquals( 4, regularItem.sellIn);
        assertEquals(0, regularItem.quality);
    }
}

