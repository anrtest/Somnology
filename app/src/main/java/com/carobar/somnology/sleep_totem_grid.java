package com.carobar.somnology;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class sleep_totem_grid extends Fragment {

    GridView androidGridView;

    Integer[] imageIDs = {
            R.drawable.totem_chicken_large,
            R.drawable.totem_cow_large,
            R.drawable.totem_deer_large,
            R.drawable.totem_dog_large,
            R.drawable.totem_dolphin_large,
            R.drawable.totem_elephant_large,
            R.drawable.totem_fox_large,
            R.drawable.totem_horse_large,
            R.drawable.totem_leopard_large,
            R.drawable.totem_lion_large,
            R.drawable.totem_monkey_large,
            R.drawable.totem_panda_large,
            R.drawable.totem_penguin_large,
            R.drawable.totem_pig_large,
            R.drawable.totem_rabbit_large,
            R.drawable.totem_sheep_large,
            R.drawable.totem_tiger_large,
            R.drawable.totem_zebra_large,


    };


    public sleep_totem_grid() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sleep_totem_grid, container, false);
        GridView androidGridView = (GridView) v.findViewById(R.id.gridview);
//        androidGridView.setAdapter(new ImageAdapterGridView(this));
        androidGridView.setAdapter(new ImageAdapterGridView(getContext()));
        View headerView = v.findViewById(R.id.sleep_totem_grid_header);
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

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
//                Toast.makeText(getContext(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();
                if (position + 1 == 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "chicken");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "pig");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 3) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "deer");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 4) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "dog");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 5) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "dolphin");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 6) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "elephant");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 7) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "fox");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 8) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "horse");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 9) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "leopard");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 10) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "lion");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 11) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "monkey");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 12) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "panda");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 13) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "penguin");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 14) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "pig");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 15) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "rabbit");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 16) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "sheep");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 17) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "tiger");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
                else if (position + 1 == 18) {
                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", "zebra");
                    Fragment sleepTotemFragment=new sleep_totems_single();
                    sleepTotemFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.sleeptotem_GridRelativeLayout,sleepTotemFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }
            }
        });

        return v;

//        return inflater.inflate(R.layout.fragment_sleep_totem_grid, container, false);
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
