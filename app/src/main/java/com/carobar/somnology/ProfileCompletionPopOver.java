package com.carobar.somnology;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.carobar.somnology.core.PopListAdapter;

import java.util.ArrayList;


public class ProfileCompletionPopOver extends DialogFragment implements View.OnClickListener {
    Button close;
    TextView headerTitle;
    TextView shortDesc;
    TextView starCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_completion_pop_over, null);
        close = view.findViewById(R.id.popoverPCYesButton);
        close.setOnClickListener(this);

        headerTitle = view.findViewById(R.id.popOverPCInfoText);
        headerTitle.setText(getArguments().getString("Title"));

        shortDesc =  view.findViewById(R.id.popOverPCinfoShortDesc);
        shortDesc.setText(getArguments().getString("shortDesc"));

        starCount = view.findViewById(R.id.popOverinfoStarCount);
        starCount.setText(getArguments().getString("starCount"));
        setCancelable(false);
        return view;
    }
    @Override
    public void onClick(View view){
        if(view.getId() == R.id.popoverPCYesButton){
            dismiss();
        }
    }
    @Override
    public void onDestroyView() {
        Dialog dialog = getDialog();
        // handles https://code.google.com/p/android/issues/detail?id=17423
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }
}
