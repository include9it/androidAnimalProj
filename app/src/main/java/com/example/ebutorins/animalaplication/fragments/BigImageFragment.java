package com.example.ebutorins.animalaplication.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
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
public class BigImageFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {


    static int REQUEST_IMAGE_CAPTURE;

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
        REQUEST_IMAGE_CAPTURE = getArguments().getInt("REQUEST_IMAGE_CAPTURE");

        imageView.setBackgroundResource(animalses.get(position).getImageId());
        textView.setText(animalses.get(position).getKindOfAnimal());

        imageView.setOnClickListener(this);
        imageView.setOnLongClickListener(this);

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


    @Override
    public boolean onLongClick(View view) {
        int id = view.getId();

        if(R.id.fragment_big_image_image == id){

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getContext().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }

        }
        return false;
    }



}
