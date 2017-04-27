package com.example.ebutorins.animalaplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ebutorins.animalaplication.models.Animals;
import com.example.ebutorins.animalaplication.R;

import java.util.List;

/**
 * Created by ebutorins on 5/11/2016.
 */
public class GridAdapter extends BaseAdapter {

    List<Animals> animalses;
    Context context;
    ViewHolder holder;

    public GridAdapter(List<Animals> animalses, Context context) {
        this.animalses = animalses;
        this.context = context;
    }


    @Override
    public int getCount() {
        return animalses.size();
    }

    @Override
    public Object getItem(int position) {
        return animalses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.grid_form_fill , parent, false);
            holder = new ViewHolder();
            holder.thumbImage = (ImageView) convertView.findViewById(R.id.grid_form_fill_image);
            holder.text = (TextView) convertView.findViewById(R.id.grid_form_fill_kindOfAnimal);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

//        ImageView imageView;
//        TextView txtKind;

//        imageView = (ImageView) convertView.findViewById(R.id.grid_form_fill_image);
//        txtKind = (TextView) convertView.findViewById(R.id.grid_form_fill_kindOfAnimal);


        holder.thumbImage.setImageResource(animalses.get(position).getImageId());
        holder.text.setText(String.format(context.getString(R.string.fragment_details_table_row_text_kind_of_animals), animalses.get(position).getKindOfAnimal()));

        return convertView;
    }

    public class ViewHolder {
        ImageView thumbImage;
        TextView text;
    }
}

