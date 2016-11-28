package upday.sample.shortcuts.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import upday.sample.shortcuts.shortcuts.DynamicShortcuts;
import upday.sample.shortcuts.R;

/**
 * Created by kavya on, 23/11/16.
 */

public class CategoriesRecyclerViewAdapter
        extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoriesRecyclerViewHolder> {

    private Context mContext;

    @NonNull
    private final List<String> mItems = new ArrayList<>();

    public CategoriesRecyclerViewAdapter(Context context, @NonNull List<String> items) {
        mItems.addAll(items);
        mContext = context;
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

        String category = mItems.get(position);
        holder.mTextView.setText(category);
        holder.mTextView.setOnClickListener(view -> {
            DynamicShortcuts.createShortcut(mContext, category);
            Toast.makeText(mContext,
                           String.format(mContext.getString(R.string.category_toast_message),
                                         category),
                           Toast.LENGTH_SHORT)
                 .show();
        });
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
