package com.example.ebutorins.animalaplication.customViews;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ebutorins.animalaplication.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ebutorins on 6/7/2016.
 */
public class InfoEverywhereView extends LinearLayout implements View.OnClickListener {

    final String SAVED_COLOR = "saved_colors";
    SharedPreferences sPref;
    Context context;
    private String text_color;

    TextView textView;

    Button bRed, bGreen, bBlue;

    public InfoEverywhereView(Context context) {
        super(context);
    }

    public InfoEverywhereView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }

    public InfoEverywhereView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context, attrs);
    }

    private void initViews(Context context, AttributeSet attrs) {

        this.context = context;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_infoeverywhere, this, true);
        textView = (TextView) findViewById(R.id.view_infoeverywhere_info);
        textView.setText("Animal");
        textView.setTextSize(30);

        bRed = (Button) findViewById(R.id.view_infoeverywhere_red_button);
        bGreen = (Button) findViewById(R.id.view_infoeverywhere_green_button);
        bBlue = (Button) findViewById(R.id.view_infoeverywhere_blue_button);

        bRed.setOnClickListener(this);
        bGreen.setOnClickListener(this);
        bBlue.setOnClickListener(this);

        loadText();

        if(text_color.equals("#FF0000")) textView.setTextColor(Color.parseColor("#FF0000"));
        if(text_color.equals("#00FF00")) textView.setTextColor(Color.parseColor("#00FF00"));
        if(text_color.equals("#0000FF")) textView.setTextColor(Color.parseColor("#0000FF"));

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.view_infoeverywhere_red_button:
                changeTextColor(1);
                break;
            case R.id.view_infoeverywhere_green_button:
                changeTextColor(2);
                break;
            case R.id.view_infoeverywhere_blue_button:
                changeTextColor(3);
                break;
        }

    }

    public void changeTextColor(int type) {
        switch (type) {
            case 1:
                textView.setTextColor(Color.parseColor("#FF0000"));
                text_color = "#FF0000";
                saveText();
                break;
            case 2:
                textView.setTextColor(Color.parseColor("#00FF00"));
                text_color = "#00FF00";
                saveText();
                break;
            case 3:
                textView.setTextColor(Color.parseColor("#0000FF"));
                text_color = "#0000FF";
                saveText();
                break;
        }
    }

    void saveText() {
        sPref = getContext().getSharedPreferences(
                "com.example.app", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_COLOR, text_color);
        ed.commit();
        Toast.makeText(context, "Text saved"+text_color, Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        sPref = getContext().getSharedPreferences(
                "com.example.app", MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_COLOR, "");
        text_color = savedText;
        Toast.makeText(context, "Text loaded"+text_color, Toast.LENGTH_SHORT).show();
    }
}
