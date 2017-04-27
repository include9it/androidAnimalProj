package com.example.ebutorins.animalaplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ebutorins.animalaplication.managers.DataManager;
import com.example.ebutorins.animalaplication.models.Animals;
import com.example.ebutorins.animalaplication.R;

import java.util.List;

/**
 * Created by ebutorins on 5/12/2016.
 */
public class BigImageFragment extends Fragment implements View.OnClickListener {


    List<Animals> animalses;
    ImageView imageView;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_big_image, container, false);

        animalses = DataManager.getInstance().getAnimalses();

        imageView = (ImageView) view.findViewById(R.id.fragment_big_image_image);
        textView = (TextView) view.findViewById(R.id.fragment_big_image_text);

        int position = getArguments().getInt("PossFragment");

        imageView.setBackgroundResource(animalses.get(position).getImageId());
        textView.setText(animalses.get(position).getKindOfAnimal());

        imageView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fragment_big_image_image:
                if(textView.getVisibility() == View.GONE)
                    textView.setVisibility(View.VISIBLE);
                else
                    textView.setVisibility(View.GONE);
                break;
        }
    }
}
