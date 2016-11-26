package upday.sample.shortcuts.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import upday.sample.shortcuts.R;

import static upday.sample.shortcuts.data.ItemListGenerator.Categories.GADGETS;
import static upday.sample.shortcuts.data.ItemListGenerator.Categories.FASHION;
import static upday.sample.shortcuts.data.ItemListGenerator.Categories.SPORTS;

/**
 * Created by kavya on, 23/11/16.
 */
public class ItemListGenerator {

    public interface Categories {

        String GADGETS = "Gadgets";
        String SPORTS = "Sports";
        String FASHION = "Fashion";
    }

    public static List<Item> getItemsList() {
        List<Item> items = new ArrayList<>(6);
        items.add(new Item("item1", GADGETS, 50));
        items.add(new Item("item2", GADGETS, 70));
        items.add(new Item("item3", SPORTS, 80));
        items.add(new Item("item4", SPORTS, 90));
        items.add(new Item("item5", FASHION, 100));
        items.add(new Item("item6", FASHION, 60));
        return items;
    }

    public static List<String> getCategoriesList() {
        return Arrays.asList(GADGETS, SPORTS, FASHION);
    }

    public static List<Item> getItemsListForCategory(String category) {
        List<Item> items = new ArrayList<>();
        for (Item item : getItemsList()) {
            if (item.getCategory().equals(category)) {
                items.add(item);
            }
        }
        return items;
    }

    public static int getIconForCategory(String category) {
        switch (category) {
            case GADGETS:
                return R.drawable.mobile;
            case SPORTS:
                return R.drawable.sports;
            case FASHION:
            default:
                return R.drawable.fashion;
        }
    }

}
