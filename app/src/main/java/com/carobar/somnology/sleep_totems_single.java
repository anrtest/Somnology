package com.carobar.somnology;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;


public class sleep_totems_single extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public sleep_totems_single() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
//    public static sleep_totems_single newInstance(String param1, String param2) {
//        sleep_totems_single fragment = new sleep_totems_single();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sleep_totems_single, container, false);
        View headerView = v.findViewById(R.id.sleep_totem_single_header);
        Button backButton = headerView.findViewById(R.id.back);
        backButton.setVisibility(View.VISIBLE);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getFragmentManager().getBackStackEntryCount() > 0){
                    getFragmentManager().popBackStackImmediate();
                }


            }
        });
        String strtext = getArguments().getString("edttext");
        Log.d("in fragment",strtext);
        TextView totemName=v.findViewById(R.id.sleep_totems_singleText);
        totemName.setText(strtext);
        totemName.setAllCaps(true);
        ImageView imageView = v.findViewById(R.id.sleepTotems_singleGifImageView);
//        Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);
//        AssetManager assetManager = getActivity().getAssets();
//        AssetFileDescriptor afd = assetManager.open("sleep_totems_gif/chicken.gif")
//        GifDrawable gifDrawable = new GifDrawable( getActivity().getAssets(), "chicken.gif" );

//        GifImageView sleepGif = v.findViewById(R.id.sleeptotems_gifView);
        TextView totemDetail= v.findViewById(R.id.sleep_totems_secondTextDescription);
        if (strtext.equalsIgnoreCase("pig")) {
            Glide.with(this).load(R.drawable.pig).into(imageView);
            totemDetail.setText(R.string.pig);
        }
        else if (strtext.equalsIgnoreCase("dog")) {
            Glide.with(this).load(R.drawable.dog).into(imageView);
            totemDetail.setText(R.string.dog);
        }
        else if (strtext.equalsIgnoreCase("chicken")) {
            Glide.with(this).load(R.drawable.chicken).into(imageView);
            totemDetail.setText(R.string.chicken);
        }
        else if (strtext.equalsIgnoreCase("dolphin")) {
            Glide.with(this).load(R.drawable.dolphin).into(imageView);
            totemDetail.setText(R.string.dolphion);
        }
        else if (strtext.equalsIgnoreCase("fox")) {
            Glide.with(this).load(R.drawable.fox).into(imageView);
            totemDetail.setText(R.string.fox);
        }
        else if (strtext.equalsIgnoreCase("lion")) {
            Glide.with(this).load(R.drawable.lion).into(imageView);
            totemDetail.setText(R.string.lion);
        }
        else if (strtext.equalsIgnoreCase("tiger")) {
            Glide.with(this).load(R.drawable.tiger).into(imageView);
            totemDetail.setText(R.string.tiger);
        }
        else if (strtext.equalsIgnoreCase("leopard")) {
            Glide.with(this).load(R.drawable.leopard).into(imageView);
            totemDetail.setText(R.string.leopard);
        }
        else if (strtext.equalsIgnoreCase("elephant")) {
            Glide.with(this).load(R.drawable.elephant).into(imageView);
            totemDetail.setText(R.string.elephant);
        }
        else if (strtext.equalsIgnoreCase("horse")) {
            Glide.with(this).load(R.drawable.horse).into(imageView);
            totemDetail.setText(R.string.horse);
        }
        else if (strtext.equalsIgnoreCase("monkey")) {
            Glide.with(this).load(R.drawable.monkey).into(imageView);
            totemDetail.setText(R.string.monkey);
        }
        else if (strtext.equalsIgnoreCase("panda")) {
            Glide.with(this).load(R.drawable.panda).into(imageView);
            totemDetail.setText(R.string.panda);
        }
        else if (strtext.equalsIgnoreCase("penguin")) {
            Glide.with(this).load(R.drawable.penguin).into(imageView);
            totemDetail.setText(R.string.penguin);
        }
        else if (strtext.equalsIgnoreCase("rabbit")) {
            Glide.with(this).load(R.drawable.rabbit).into(imageView);
            totemDetail.setText(R.string.rabbit);
        }
        else if (strtext.equalsIgnoreCase("sheep")) {
            Glide.with(this).load(R.drawable.sheep).into(imageView);
            totemDetail.setText(R.string.sheep);
        }
        else if (strtext.equalsIgnoreCase("zebra")) {
            Glide.with(this).load(R.drawable.zebra).into(imageView);
            totemDetail.setText(R.string.zebra);
        }
        else if (strtext.equalsIgnoreCase("deer")) {
            Glide.with(this).load(R.drawable.deer).into(imageView);
            totemDetail.setText(R.string.deer);
        }
        else {
            Glide.with(this).load(R.drawable.cow).into(imageView);
            totemDetail.setText(R.string.cow);
        }

        TextView screenTitle = headerView.findViewById(R.id.headerViewScreenText);
        screenTitle.setText("Sleep Totems");
        return v;
//        return inflater.inflate(R.layout.fragment_sleep_totems_single, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
