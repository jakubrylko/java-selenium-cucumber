package Options;

import java.util.HashMap;

public class Zad1 {

    private final HashMap<String, Item> items = new HashMap<>();

    public void reset() {
        items.clear();
    }

    public void addItem(String name, int price) {
        if (name != null && !name.isEmpty() && !name.trim().isEmpty() && price > 0) {
            items.put(name, new Item(name, price));
        }
    }

    public void scanItems(String name, int count) {
        Item item = items.get(name);
        if (item != null) {
            item.count = item.count + count;
        }
    }

    public int totalCart() {
        int total = 0;
        for (Item item : items.values()) {
            total += item.price * item.count;
        }
        return total;
    }
}

class Item {
    String name;
    int price = 0;
    int count = 0;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        this.count = 0;
    }
}