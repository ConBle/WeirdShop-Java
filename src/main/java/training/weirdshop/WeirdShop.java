package training.weirdshop;

class WeirdShop {
    private Item[] items;

    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Gold Coin")) {
                continue;
            }

            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage Pass")) {
                if (item.quality > 0) {
                    item.quality--;
                }
            } else if (item.quality < 50) {
                if (!item.name.equals("Backstage Pass")) {
                    item.quality++;
                } else {
                    if (item.sellIn < 7) {
                        item.quality = (item.quality > 47) ? 50 : item.quality + 3;
                    } else if (item.sellIn < 12) {
                        item.quality = (item.quality > 48) ? 50 : item.quality + 2;
                    } else {
                        item.quality++;
                    }
                }
            }

            item.sellIn--;

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage Pass")) {
                        if (item.quality > 0) {
                            item.quality--;
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            }
        }
    }
}