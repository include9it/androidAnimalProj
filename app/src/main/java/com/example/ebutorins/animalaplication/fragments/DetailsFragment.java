package com.example.ebutorins.animalaplication.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ebutorins.animalaplication.managers.DataManager;
import com.example.ebutorins.animalaplication.models.Animals;
import com.example.ebutorins.animalaplication.R;

import java.util.List;

/**
 * Created by ebutorins on 5/11/2016.
 */
public class DetailsFragment extends Fragment implements View.OnClickListener {

    OnHeadlineSelectedListener mCallback;

    public interface OnHeadlineSelectedListener {

        public void onArticleSelected(int position);
    }
    List<Animals> animalses;

    ImageView imageView;
    TextView ltextKind, ltextHabitat, ltextQuantity, ltextHorns, ltextWeight;

    LinearLayout layout_details;

    int position;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details, container, false);

        animalses = DataManager.getInstance().getAnimalses();

        imageView = (ImageView) view.findViewById(R.id.fragment_details_image);

        ltextKind = (TextView) view.findViewById(R.id.fragment_details_table_row_text_left_kind_of_animals);
        ltextHabitat  = (TextView) view.findViewById(R.id.fragment_details_table_row_text_left_habitat);
        ltextQuantity  = (TextView) view.findViewById(R.id.fragment_details_table_row_text_left_quantity_tines);
        ltextHorns  = (TextView) view.findViewById(R.id.fragment_details_table_row_text_left_horns);
        ltextWeight  = (TextView) view.findViewById(R.id.fragment_details_table_row_text_left_weight);

        position = getArguments().getInt("Poss");

        imageView.setBackgroundResource(animalses.get(position).getImageId());

        ltextKind.setText(String.format(getString(R.string.fragment_details_table_row_text_kind_of_animals), animalses.get(position).getKindOfAnimal()));
        ltextHabitat.setText(String.format(getString(R.string.fragment_details_table_row_text_habitat), animalses.get(position).getHabitat()));
        ltextQuantity.setText(String.format(getString(R.string.fragment_details_table_row_text_quantity_tines), animalses.get(position).getQuantityTines()));
        if(animalses.get(position).isHorns()==true){
            ltextHorns.setText(String.format(getString(R.string.fragment_details_table_row_horns), getString(R.string.fragment_details_table_have_horns)));
        }else{
            ltextHorns.setVisibility(View.GONE);
        }
        ltextWeight.setText(String.format(getString(R.string.fragment_details_table_row_text_weight), animalses.get(position).getWeight()));

        imageView.setOnClickListener(this);

        layout_details = (LinearLayout) view.findViewById(R.id.fragment_details_layout);
        layout_details.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return false;
            }
        });


        return view;

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fragment_details_image:
                mCallback.onArticleSelected(position);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnHeadlineSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

}
