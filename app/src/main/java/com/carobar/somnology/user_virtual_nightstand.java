package com.carobar.somnology;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class user_virtual_nightstand extends Fragment {

    GridView androidVirtulaNSGridView;

    Integer[] imageIDs = {
            R.drawable.totem_chicken_inactive_2x,
            R.drawable.totem_cow_inactive_2x,
            R.drawable.totem_deer_inactive_2x,
            R.drawable.totem_dog_inactive_2x,
            R.drawable.totem_dolphin_inactive_2x,
            R.drawable.totem_elephant_inactive_2x,
            R.drawable.totem_fox_inactive_2x,
            R.drawable.totem_horse_inactive_2x,
            R.drawable.totem_leopard_inactive_2x,
            R.drawable.totem_lion_inactive_2x,
            R.drawable.totem_monkey_inactive_2x,
            R.drawable.totem_panda_inactive_2x,
            R.drawable.totem_penguin_inactive_2x,
            R.drawable.totem_pig_inactive_2x,
            R.drawable.totem_rabbit_inactive_2x,
            R.drawable.totem_sheep_inactive_2x,
            R.drawable.totem_tiger_inactive_2x,
            R.drawable.totem_zebra_inactive_2x,


    };


    public user_virtual_nightstand() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_user_virtual_nightstand, container, false);
        GridView androidVirtulaNSGridView = (GridView) v.findViewById(R.id.virtual_nightstand_gridview);
//        androidGridView.setAdapter(new ImageAdapterGridView(this));
        androidVirtulaNSGridView.setAdapter(new ImageAdapterGridView(getContext()));
        View headerView = v.findViewById(R.id.virtual_nightstand_grid_header);
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

//        Button settingBtn = headerView.findViewById(R.id.userProfile_settingBtn);
//        settingBtn.setVisibility(View.INVISIBLE);

        TextView screenTitle = headerView.findViewById(R.id.headerViewScreenText);
        screenTitle.setText("Virtual Night Stand");

        return v;
//        return inflater.inflate(R.layout.fragment_user_virtual_nightstand, container, false);
    }

    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(200, 250));
                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mImageView.setPadding(16, 16, 16, 25);
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(imageIDs[position]);
            return mImageView;
        }
    }

}
