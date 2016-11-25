package upday.sample.shortcuts.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import upday.sample.shortcuts.R;

/**
 * Created by kavya on, 23/11/16.
 */

public class CategoriesRecyclerViewAdapter
        extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoriesRecyclerViewHolder> {

    @NonNull
    private final List<String> mItems = new ArrayList<>();

    public CategoriesRecyclerViewAdapter(@NonNull List<String> items) {
        mItems.addAll(items);
    }

    @Override
    public CategoriesRecyclerViewHolder onCreateViewHolder(final ViewGroup parent,
                                                           final int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.categories_item_view, parent, false);
        return new CategoriesRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoriesRecyclerViewHolder holder, final int position) {
        if (mItems.size() == 0) {
            return;
        }

        holder.mTextView.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class CategoriesRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        CategoriesRecyclerViewHolder(final View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.category_name);
        }
    }

}
