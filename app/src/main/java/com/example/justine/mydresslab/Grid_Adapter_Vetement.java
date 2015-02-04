package com.example.justine.mydresslab;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by justine on 04/02/2015.
 */
public class Grid_Adapter_Vetement extends BaseAdapter{

        Context context;
        ArrayList<String> imageId;
        private static LayoutInflater inflater = null;

        public Grid_Adapter_Vetement(Context context, ArrayList<String> prgmImages)
        {
            this.context=context;
            imageId=prgmImages;
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imageId.size();
        }

        @Override
        public Object getItem(int position) {
            return imageId.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public class Holder
        {
            ImageView img;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Holder holder = new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.cellule_fragment_vetement,null);
            holder.img=(ImageView) rowView.findViewById(R.id.image_cell_fragment);

            holder.img.setImageURI(Uri.parse(imageId.get(position)));

            return rowView;
        }


}
