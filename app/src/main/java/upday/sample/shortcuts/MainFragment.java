package upday.sample.shortcuts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import upday.sample.shortcuts.adapter.MainRecyclerViewAdapter;

import static upday.sample.shortcuts.data.ItemListGenerator.getItemsList;
import static upday.sample.shortcuts.data.ItemListGenerator.getItemsListForCategory;

/**
 * Created by kavya on, 23/11/16.
 */
public class MainFragment extends Fragment {

    @NonNull
    private final MainRecyclerViewAdapter mAdapter = new MainRecyclerViewAdapter();

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setItems(getItemsList());
    }

    public void updateItemsForCategory(String category) {
        DynamicShortcuts.reportShortcutUsed(getContext(), category);
        mAdapter.setItems(getItemsListForCategory(category));
    }

}
