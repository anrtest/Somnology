package com.carobar.somnology.shankit.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.carobar.somnology.R;

public class HourSelectionViewHolder extends RecyclerView.ViewHolder {
    public RadioButton radioButton;
    public TextView textView;

    public HourSelectionViewHolder(View itemView) {
        super(itemView);
        radioButton = itemView.findViewById(R.id.rb_viewHolder);
        textView = itemView.findViewById(R.id.tv_hour_selection);
    }
}
