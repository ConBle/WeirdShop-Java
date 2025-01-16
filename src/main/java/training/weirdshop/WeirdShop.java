package training.weirdshop;

class WeirdShop {
    private Item[] items;

    private static int MAXIMUM_QUALITY = 50;    // Does not apply Gold Coin
    private static int MINIMUM_QUALITY = 0;

    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Gold Coin")) continue;

            item.sellIn--;

            if (item.name.equals("Aged Brie")) {
                item.quality += (item.sellIn < 0) ? 2 : 1;
            } else if (item.name.equals("Backstage Pass")) {
                if (item.sellIn < 0) {
                    item.quality = MINIMUM_QUALITY;
                    continue;
                }

                if (item.sellIn < 6) {
                    item.quality += 3;
                } else if (item.sellIn < 11) {
                    item.quality += 2;
                } else {
                    item.quality += 1;
                }
            } else {
                item.quality -= (item.sellIn < 0) ? 2 : 1;
                if (item.quality < MINIMUM_QUALITY) item.quality = MINIMUM_QUALITY;
                continue;
            }

            if (item.quality > MAXIMUM_QUALITY) item.quality = MAXIMUM_QUALITY;
        }
    }
}