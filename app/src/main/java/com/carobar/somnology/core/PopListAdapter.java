package com.carobar.somnology.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pradeep on 17/1/18.
 */

public class PopListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final int resourceId;

    public PopListAdapter(Context context, int resourceId, ArrayList<String> popList){
        super(context, resourceId, popList);
        this.context = context;
        this.resourceId = resourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);


        return view;
    }
}
