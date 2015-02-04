package com.example.justine.mydresslab;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


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
        final GridView typeView = (GridView) view.findViewById(R.id.type_grid);
        typeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
                int[] images = null;
                ArrayList<Integer> image = new ArrayList<Integer>();
                TextView tv = (TextView) view.findViewById(R.id.text_cell_fragment);
                System.out.println(tv.toString());
                if(tv.getText().equals("Tee Shirts"))
                {

                }
                else if(tv.getText().equals("Manches Longues"))
                {
                   VetementsBDD vetBDD = ((MainActivity)getActivity()).getVetementBDD();
                    vetBDD.open();
                    ArrayList<Vetements> vets = vetBDD.recupereTSdepuisSsType("manche_longue");
                    for(Vetements vet : vets)
                    {
                        String lien = vet.getLienPhoto();
                        int idLien = getActivity().getResources().getIdentifier("lien","drawable","com.example.justine.mydresslab");
                        image.add((Integer)idLien);
                    }
                    ft.replace(R.id.fragment_placeholder, FragmentVetement.getInstance(image));
                    ft.commit();
                }
                else if(tv.getText().equals("Manches Longues"))
                {

                }
                else if(tv.getText().equals("Pulls"))
                {

                }
                else if(tv.getText().equals("Débardeurs"))
                {

                }
                else if(tv.getText().equals("Pantalons"))
                {

                }
                else if(tv.getText().equals("Shorts"))
                {

                }
                else if(tv.getText().equals("Jupes"))
                {
                    VetementsBDD vetBDD = ((MainActivity)getActivity()).getVetementBDD();
                    vetBDD.open();
                    ArrayList<Vetements> vets = vetBDD.recupereTSdepuisSsType("Jupe");
                    vetBDD.close();
                    for(Vetements vet : vets)
                    {
                        String lien = vet.getLienPhoto();
                        System.out.println(lien);
                        int idLien = getActivity().getResources().getIdentifier(lien,"drawable",getActivity().getPackageName());
                        image.add((Integer)idLien);
                    }

                    ft.replace(R.id.fragment_placeholder, FragmentVetement.getInstance(image));
                    ft.commit();

                }
                else if(tv.getText().equals("Tongues"))
                {

                }
                else if(tv.getText().equals("Talons"))
                {

                }
                else if(tv.getText().equals("Bottes"))
                {

                }
                else if(tv.getText().equals("Autre"))
                {

                }
                else if(tv.getText().equals("Sacs"))
                {

                }
                else if(tv.getText().equals("Lunettes"))
                {

                }
                else if(tv.getText().equals("Cravates"))
                {

                }
                else if(tv.getText().equals("Chapeaux"))
                {

                }
                else
                {
                    Grid_Adapter gridAdapter = new Grid_Adapter(getActivity(),ssTypes, images);
                    typeView.setAdapter(gridAdapter);
                }
            }
        });
        Grid_Adapter gridAdapter = new Grid_Adapter(getActivity(),ssTypes, images);
        typeView.setAdapter(gridAdapter);

        return view;
    }
}
