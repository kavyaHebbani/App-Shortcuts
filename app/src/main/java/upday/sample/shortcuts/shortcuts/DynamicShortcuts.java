package upday.sample.shortcuts.shortcuts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import upday.sample.shortcuts.MainActivity;
import upday.sample.shortcuts.R;
import upday.sample.shortcuts.data.ItemListGenerator;

import static upday.sample.shortcuts.data.ItemListGenerator.getIconForCategory;
import static upday.sample.shortcuts.fragments.MyFragmentManager.FRAGMENT_TO_SHOW;

/**
 * Created by kavya on, 25/11/16.
 */
public class DynamicShortcuts {

    private static ShortcutManager getShortcutManager(Context context) {
        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);

        if (shortcutManager.isRateLimitingActive()) {
            // Bringing app to foreground resets the limit.
            Toast.makeText(context, "Shortcut Manager Rate-Limiting is active", Toast.LENGTH_SHORT)
                 .show();
        }
        return shortcutManager;
    }

    public static void createShortcut(Context context, String category) {
        ShortcutManager shortcutManager = getShortcutManager(context);

        // to add an element to existing list of shortcuts, use 'addDynamicShortcuts'.
        shortcutManager.setDynamicShortcuts(getShortcutInfo(context, category));
    }

    public static void restoreShortcuts(Context context) {
        ShortcutManager shortcutManager = getShortcutManager(context);
        if (shortcutManager.getDynamicShortcuts().size() == 0) {
            // restore dynamic shortcuts that needs to be added by default.

            if (shortcutManager.getPinnedShortcuts().size() > 0) {
                // pinned shortcuts needs to be updated here, after app upgrade.
            }
        }
    }

    public static void reportShortcutUsed(Context context, String category) {
        getShortcutManager(context).reportShortcutUsed(category);
    }

    public static void removeShortcuts(Context context) {
        Toast.makeText(context, R.string.shortcuts_removed, Toast.LENGTH_SHORT).show();
        getShortcutManager(context).removeAllDynamicShortcuts();
    }

    private static void disableShortcuts(Context context) {
        // disable shortcuts that are no more valid here
        getShortcutManager(context).disableShortcuts(ItemListGenerator.getCategoriesList(),
                                                     context.getString(R.string.disabled_message));
    }

    private static List<ShortcutInfo> getShortcutInfo(Context context, String category) {
        // Add more shortcuts here
        return Arrays.asList(new ShortcutInfo.Builder(context, category)
                                     .setShortLabel(category)
                                     .setLongLabel("Go To " + category)
                                     .setIcon(getIcon(context, category))
                                     .setIntent(getIntent(context, category))
                                     .build());
    }

    private static Icon getIcon(Context context, String category) {
        return Icon.createWithResource(context, getIconForCategory(category));
    }

    private static Intent getIntent(Context context, String category) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(FRAGMENT_TO_SHOW, category);
        intent.setAction(Intent.ACTION_VIEW);
        return intent;
    }

}
