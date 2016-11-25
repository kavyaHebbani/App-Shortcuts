package upday.sample.shortcuts;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String MAIN_FRAGMENT = "MainFragment";
    private static final String CART_FRAGMENT = "CartFragment";
    private static final String CATEGORIES_FRAGMENT = "CategoriesFragment";

    private static final String FRAGMENT_TO_SHOW = "fragment";
    private static final String CART = "cart";
    private static final String CATEGORIES = "categories";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpActionBar();
        handleIntent();

        if (getSupportFragmentManager().findFragmentById(R.id.main_fragment) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new MainFragment(), MAIN_FRAGMENT)
                    .addToBackStack(MAIN_FRAGMENT)
                    .commit();
        }

        ImageView cartImageView = (ImageView) findViewById(R.id.cart);
        cartImageView.setOnClickListener(view -> showCartFragment());

        ImageView categoriesImageView = (ImageView) findViewById(R.id.categories);
        categoriesImageView.setOnClickListener(view -> showCategoriesFragment());
    }

    private void handleIntent() {
        String extra = getIntent().getStringExtra(FRAGMENT_TO_SHOW);
        if (extra != null) {
            switch (extra) {
                case CART:
                    showCartFragment();
                    break;
                case CATEGORIES:
                    showCategoriesFragment();
                    break;
                default:
                    break;
            }
        }
    }

    private void showCartFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, new CartFragment(), CART_FRAGMENT)
                .addToBackStack(CART_FRAGMENT)
                .commit();
    }

    private void showCategoriesFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, new CategoriesFragment(), CATEGORIES_FRAGMENT)
                .addToBackStack(CATEGORIES_FRAGMENT)
                .commit();
    }

    private void setUpActionBar() {
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayShowHomeEnabled(true);
            ab.setDisplayHomeAsUpEnabled(false);
            ab.setDisplayShowCustomEnabled(true);
            ab.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}
