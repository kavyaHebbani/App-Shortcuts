package upday.sample.shortcuts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import upday.sample.shortcuts.adapter.CategoriesRecyclerViewAdapter;

import static upday.sample.shortcuts.data.ItemListGenerator.getCategoriesList;

/**
 * Created by kavya on, 23/11/16.
 */

public class CategoriesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.categories_fragment, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.categories_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CategoriesRecyclerViewAdapter(getContext(), getCategoriesList()));

        Button button = (Button) view.findViewById(R.id.remove_shortcut);
        button.setOnClickListener(v -> DynamicShortcuts.removeShortcuts(getContext()));
    }

}
