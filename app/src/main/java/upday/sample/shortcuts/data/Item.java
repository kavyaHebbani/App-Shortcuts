package upday.sample.shortcuts.data;

import android.support.annotation.NonNull;

/**
 * Created by kavya on, 23/11/16.
 */
public class Item {

    @NonNull
    private final String mName;

    @NonNull
    private final String mCategory;

    private final int mPrice;

    public Item(@NonNull String name, @NonNull String category, int price) {
        mName = name;
        mCategory = category;
        mPrice = price;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    @NonNull
    public String getCategory() {
        return mCategory;
    }

    public int getPrice() {
        return mPrice;
    }
}
