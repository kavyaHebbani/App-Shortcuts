package upday.sample.shortcuts.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static upday.sample.shortcuts.data.ItemListGenerator.Categories.BOOKS;
import static upday.sample.shortcuts.data.ItemListGenerator.Categories.FASHION;
import static upday.sample.shortcuts.data.ItemListGenerator.Categories.SPORTS;

/**
 * Created by kavya on, 23/11/16.
 */
public class ItemListGenerator {

    public interface Categories {

        String BOOKS = "Books";
        String SPORTS = "Sports";
        String FASHION = "Fashion";
    }

    public static List<Item> getItemsList() {
        List<Item> items = new ArrayList<>(6);
        items.add(new Item("item1", BOOKS, 50));
        items.add(new Item("item2", BOOKS, 70));
        items.add(new Item("item3", SPORTS, 80));
        items.add(new Item("item4", SPORTS, 90));
        items.add(new Item("item5", FASHION, 100));
        items.add(new Item("item6", FASHION, 60));
        return items;
    }

    public static List<String> getCategoriesList() {
        return Arrays.asList(BOOKS, SPORTS, FASHION);
    }

    public static List<Item> getItemsListForCategory(String category) {
        List<Item> items = new ArrayList<>();
        for (Item item : getItemsList()) {
            if (item.getCategory() == category) {
                items.add(item);
            }
        }
        return items;
    }

}
