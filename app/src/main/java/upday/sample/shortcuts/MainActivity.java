package upday.sample.shortcuts;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import static upday.sample.shortcuts.MyFragmentManager.CART;
import static upday.sample.shortcuts.MyFragmentManager.CATEGORIES;

public class MainActivity extends AppCompatActivity {

    private MyFragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpActionBar();

        // restore shortcuts after app upgrade
        DynamicShortcuts.restoreShortcuts(this);

        mFragmentManager = new MyFragmentManager(getSupportFragmentManager());
        mFragmentManager.handleIntent(getIntent());

        ImageView cartImageView = (ImageView) findViewById(R.id.cart);
        cartImageView.setOnClickListener(view -> mFragmentManager.showFragment(CART));

        ImageView categoriesImageView = (ImageView) findViewById(R.id.categories);
        categoriesImageView.setOnClickListener(view -> mFragmentManager.showFragment(CATEGORIES));
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
