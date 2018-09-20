package com.carobar.somnology;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.carobar.somnology.core.PopListAdapter;

import java.util.ArrayList;


public class InfoDialogFragment extends DialogFragment implements View.OnClickListener {
    Button close;
    TextView headerTitle;
    TextView shortDesc;
    ListView popupListView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_dialog, null);
        close = (Button) view.findViewById(R.id.yesButton);
        close.setOnClickListener(this);

        headerTitle = (TextView) view.findViewById(R.id.dialogFragmentInfoText);
        headerTitle.setText(getArguments().getString("Title"));

        shortDesc = (TextView) view.findViewById(R.id.dialogFragmentInfoShortDesc);
        shortDesc.setText(getArguments().getString("shortDesc"));

        ArrayList<String> popList = new ArrayList<String>();
        String[] popArray = getArguments().getStringArray("infoSteps");
        for (String s:popArray) {
            popList.add(s);
        }
        popupListView = (ListView) view.findViewById(R.id.popupListView);
        PopListAdapter popAdapter = new PopListAdapter(getActivity(), android.R.layout.simple_list_item_1, popList);
        popupListView.setAdapter(popAdapter);




        setCancelable(false);
        return view;
    }
    @Override
    public void onClick(View view){
        if(view.getId() == R.id.yesButton){
            dismiss();
        }
    }

}
