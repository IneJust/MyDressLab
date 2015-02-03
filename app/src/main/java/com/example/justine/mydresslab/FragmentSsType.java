package com.example.justine.mydresslab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by justine on 03/02/2015.
 */
public class FragmentSsType extends Fragment {

    private static String [] ssTypes;
    private static int [] images;

    public FragmentSsType () {}

    public static FragmentSsType getInstance(String[] ssType, int [] image)
    {
        FragmentSsType instanceFragment = new FragmentSsType();
        ssTypes = ssType.clone();
        images = image.clone();
        return instanceFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =inflater.inflate(R.layout.type_fragment_layout, container, false);
        GridView typeView = (GridView) view.findViewById(R.id.type_grid);

        Grid_Adapter gridAdapter = new Grid_Adapter(getActivity(),ssTypes, images);
        typeView.setAdapter(gridAdapter);
        return view;
    }
}
