package training.weirdshop;

class WeirdShop {
    private final Item[] items;

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
                updateAgedBrieQuality(item);
                continue;
            }

            if (item.name.equals("Backstage Pass")) {
                updateBackstagePassQuality(item);
                continue;
            }

            updateOtherItemQuality(item);
        }
    }

    private void updateAgedBrieQuality(Item item) {
        item.quality += (item.sellIn < 0) ? 2 : 1;
        applyItemQualityMaximum(item);
    }

    private void updateBackstagePassQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = MINIMUM_QUALITY;
            return;
        }

        if (item.sellIn < 6) {
            item.quality += 3;
        } else if (item.sellIn < 11) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }

        applyItemQualityMaximum(item);
    }

    private void  updateOtherItemQuality(Item item) {
        item.quality -= (item.sellIn < 0) ? 2 : 1;
        applyItemQualityMinimum(item);
    }

    private void applyItemQualityMaximum(Item item) {
        if (item.quality > MAXIMUM_QUALITY) item.quality = MAXIMUM_QUALITY;
    }

    private void applyItemQualityMinimum(Item item) {
        if (item.quality < MINIMUM_QUALITY) item.quality = MINIMUM_QUALITY;
    }
}