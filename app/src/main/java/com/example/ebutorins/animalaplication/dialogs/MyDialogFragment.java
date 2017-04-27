package com.example.ebutorins.animalaplication.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ebutorins.animalaplication.managers.DataManager;
import com.example.ebutorins.animalaplication.models.Animals;
import com.example.ebutorins.animalaplication.R;

import java.util.List;

/**
 * Created by ebutorins on 5/18/2016.
 */
public class MyDialogFragment extends DialogFragment implements View.OnClickListener {

    OnHeadlineSelectedListener mCallback;

    public interface OnHeadlineSelectedListener {

        public void onArticleSelected();
    }

    public void setmCallback(OnHeadlineSelectedListener mCallback) {
        this.mCallback = mCallback;
    }

    int mNum;
    List<Animals>animalses;
    EditText editText;
    Button button;

    public static MyDialogFragment newInstance(int num) {
        MyDialogFragment f = new MyDialogFragment();
        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        f.setStyle(STYLE_NO_TITLE, 0); //requestWindowFeature(Window.FEATURE_NO_TITLE);

        return f;
    }

//
//    @Override
//    public void onStart()
//    {
//        super.onStart();
//        Dialog dialog = getDialog();
//        if (dialog != null)
//        {
//            int width = ViewGroup.LayoutParams.MATCH_PARENT;
//            int height = ViewGroup.LayoutParams.MATCH_PARENT;
//            dialog.getWindow().setLayout(width, height);
//        }
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog, container, false);
        View rtv = v.findViewById(R.id.fragment_dialog_edit_kind);
        animalses = DataManager.getInstance().getAnimalses();
        ((TextView)rtv).setText(animalses.get(mNum).getKindOfAnimal());
        editText = (EditText) rtv;
        button = (Button) v.findViewById(R.id.fragment_dialog_save);
        button.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fragment_dialog_save:
                DataManager.getInstance().getAnimalses()
                        .get(mNum).setKindOfAnimal(editText.getText().toString());
                mCallback.onArticleSelected();
                break;
        }
    }

}
