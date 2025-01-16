package training.weirdshop;

class WeirdShop {
    private Item[] items;

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
                    item.quality = 0;
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
                if (item.quality < 0) item.quality = 0;
                continue;
            }

            if (item.quality > 50) item.quality = 50;
        }
    }
}