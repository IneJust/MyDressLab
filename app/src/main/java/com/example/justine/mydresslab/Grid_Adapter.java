package com.example.justine.mydresslab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by justine on 03/02/2015.
 */
public class Grid_Adapter extends BaseAdapter{

    String [] result;
    Context context;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public Grid_Adapter(Context context, String[] prgmNameList, int [] prgmImages)
    {
        result=prgmNameList;
        this.context=context;
        imageId=prgmImages;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.cellule_fragment_layout,null);
        holder.tv=(TextView) rowView.findViewById(R.id.text_cell_fragment);
        holder.img=(ImageView) rowView.findViewById(R.id.image_cell_fragment);

        holder.tv.setText(result[position]);

            holder.img.setImageResource(imageId[position]);



        return rowView;
    }
}
