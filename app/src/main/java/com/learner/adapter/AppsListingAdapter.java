package com.learner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learner.R;
import com.learner.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Renders the List of PACKAGE_NAMES into Application-Details
 * (Application Name and Icon).
 * <p>
 * Developer: Rishabh Dutt Sharma
 * Dated: 5/22/2017.
 */
public class AppsListingAdapter extends RecyclerView.Adapter<AppsListingAdapter.TaskItemViewHolder> {

    private final Context mContext;
    private final List<String> mPackageNames;

    public AppsListingAdapter(Context context, ArrayList<String> packageNames) {
        this.mContext = context;
        this.mPackageNames = packageNames;
    }

    @Override
    public TaskItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_app_details_item, parent, false);
        return new TaskItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskItemViewHolder holder, int position) {
        holder.render(mPackageNames.get(position));
    }

    @Override
    public int getItemCount() {
        return mPackageNames == null ? 0 : mPackageNames.size();
    }

    class TaskItemViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivAppIcon;
        private final TextView tvApplicationName;

        TaskItemViewHolder(View itemView) {
            super(itemView);
            ivAppIcon = (ImageView) itemView.findViewById(R.id.iv_app_icon);
            tvApplicationName = (TextView) itemView.findViewById(R.id.tv_application_name);
        }

        /**
         * Evaluate the Package-Name data and renders in the Item
         *
         * @param packageName
         */
        void render(String packageName) {
            if (tvApplicationName != null)
                tvApplicationName.setText(Utils.getAppName(mContext, packageName));
            if (ivAppIcon != null)
                ivAppIcon.setImageDrawable(Utils.getAppIcon(mContext, packageName));
        }
    }
}