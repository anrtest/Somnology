package com.carobar.somnology.shankit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.carobar.somnology.R;
import com.carobar.somnology.shankit.HourSelectionModel;
import com.carobar.somnology.shankit.viewholder.HourSelectionViewHolder;

import java.util.ArrayList;
import java.util.List;

public class HourSelectionRecyclerAdapter extends RecyclerView.Adapter<HourSelectionViewHolder> {
    private List<HourSelectionModel> list = new ArrayList<>();
    private Context context;
    private RadioButton selectedRB = null;

    public HourSelectionRecyclerAdapter(Context context) {
        this.context = context;
    }

//    @Override
//    public HourSelectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new HourSelectionViewHolder(LayoutInflater.from(context).inflate(R.layout.item_hour_selection, parent, false));
//    }

    @NonNull
    @Override
    public HourSelectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hour_selection, viewGroup, false);
        HourSelectionViewHolder vh = new HourSelectionViewHolder(mView);
        return vh;
    }

    @Override
    public void onBindViewHolder(final HourSelectionViewHolder holder, final int position) {
        final HourSelectionModel model = list.get(position);
        holder.radioButton.setSelected(model.isSelected());
        holder.textView.setText(model.getText());
        holder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (selectedRB == null) {
                        holder.radioButton.setChecked(true);
                    } else {
                        selectedRB.setChecked(false);
                    }
                    selectedRB = holder.radioButton;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<HourSelectionModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public List<HourSelectionModel> getList() {
        return list;
    }
}
