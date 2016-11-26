package upday.sample.shortcuts;

import android.content.Intent;
import android.support.v4.app.FragmentManager;

/**
 * Created by kavya on, 26/11/16.
 */

public class MyFragmentManager {

    static final String CART = "cart";
    static final String CATEGORIES = "categories";
    static final String FRAGMENT_TO_SHOW = "fragment";

    private static final String CART_FRAGMENT = "CartFragment";
    private static final String CATEGORIES_FRAGMENT = "CategoriesFragment";

    private FragmentManager mFragmentManager;

    MyFragmentManager(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    void handleIntent(Intent intent) {
        showFragment(intent.getStringExtra(FRAGMENT_TO_SHOW));
    }

    void showFragment(String name) {
        if (name != null) {
            switch (name) {
                case CART:
                    showCartFragment();
                    break;
                case CATEGORIES:
                    showCategoriesFragment();
                    break;
                default:
                    showItemsForCategory(name);
                    break;
            }
        }
    }

    private void showCartFragment() {
        mFragmentManager
                .beginTransaction()
                .replace(R.id.main_fragment, new CartFragment(), CART_FRAGMENT)
                .addToBackStack(CART_FRAGMENT)
                .commit();
    }

    private void showCategoriesFragment() {
        mFragmentManager
                .beginTransaction()
                .replace(R.id.main_fragment, new CategoriesFragment(), CATEGORIES_FRAGMENT)
                .addToBackStack(CATEGORIES_FRAGMENT)
                .commit();
    }

    private void showItemsForCategory(String category) {
        MainFragment fragment = (MainFragment) mFragmentManager
                .findFragmentById(R.id.main_fragment);
        fragment.updateItemsForCategory(category);
    }

}
