package com.example.justine.mydresslab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by justine on 04/02/2015.
 */
public class FragmentVetement extends Fragment {




        private static ArrayList<Integer> images;

        public FragmentVetement () {}

        public static FragmentVetement getInstance(ArrayList<Integer> image)
        {
            FragmentVetement instanceFragment = new FragmentVetement();
            images = image;
            System.out.println(images.get(0));
            return instanceFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View view =inflater.inflate(R.layout.type_fragment_layout, container, false);
            GridView typeView = (GridView) view.findViewById(R.id.type_grid);

            Grid_Adapter_Vetement gridAdapter = new Grid_Adapter_Vetement(getActivity(), images);
            typeView.setAdapter(gridAdapter);
            return view;
        }
}
