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
public class ListAdapter extends BaseAdapter {

    List<Animals> animalses;
    Context context;

    public ListAdapter(List<Animals> animalses, Context context) {
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
            convertView = mInflater.inflate(R.layout.list_form_fill , null);
        }

        ImageView imageView;
        TextView txtKind, txtHabitat, txtQuantity, txtHorns, txtWeight;

        imageView = (ImageView) convertView.findViewById(R.id.list_form_fill_image);

        txtKind = (TextView) convertView.findViewById(R.id.list_form_fill_kindOfAnimal);
        txtHabitat = (TextView) convertView.findViewById(R.id.list_form_fill_habitat);
        txtQuantity = (TextView) convertView.findViewById(R.id.list_form_fill_quantityTines);
        txtHorns = (TextView) convertView.findViewById(R.id.list_form_fill_horns);
        txtWeight = (TextView) convertView.findViewById(R.id.list_form_fill_weight);



        imageView.setImageResource((animalses.get(position).getImageId()));

        txtKind.setText(String.format(context.getString(R.string.fragment_details_table_row_text_kind_of_animals), animalses.get(position).getKindOfAnimal()));
        txtHabitat.setText(String.format(context.getString(R.string.fragment_details_table_row_text_habitat), animalses.get(position).getHabitat()));
        txtQuantity.setText(String.format(context.getString(R.string.fragment_details_table_row_text_quantity_tines),Integer.toString(animalses.get(position).getQuantityTines())));
        if(animalses.get(position).isHorns()==false)
            txtHorns.setText(String.format(context.getString(R.string.fragment_details_table_row_horns),context.getString(R.string.fragment_details_table_no_horns)));
        else
            txtHorns.setText(String.format(context.getString(R.string.fragment_details_table_row_horns), context.getString(R.string.fragment_details_table_have_horns)));
        txtWeight.setText(String.format(context.getString(R.string.fragment_details_table_row_text_weight), Integer.toString(animalses.get(position).getWeight())));


        return convertView;
    }
}
