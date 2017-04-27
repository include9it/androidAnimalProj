package com.example.ebutorins.animalaplication.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;

import com.example.ebutorins.animalaplication.fragments.BigImageFragment;
import com.example.ebutorins.animalaplication.fragments.DetailsFragment;
import com.example.ebutorins.animalaplication.R;

public class FragmentActivity extends android.support.v4.app.FragmentActivity implements View.OnClickListener, DetailsFragment.OnHeadlineSelectedListener {


    ImageButton button;
    DetailsFragment detailsFragment;
    Boolean step = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        button = (ImageButton) findViewById(R.id.activity_fragmnet_button);

        button.setOnClickListener(this);


        if (findViewById(R.id.activity_fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            detailsFragment = new DetailsFragment();
            detailsFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_fragment_container, detailsFragment).commit();
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.activity_fragmnet_button:
                if(step == false)
                finish();
                else{
                    step = false;
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.activity_fragment_container, detailsFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                break;
        }
    }

    @Override
    public void onArticleSelected(int position) {

        BigImageFragment bigImageFragment = new BigImageFragment();

        Bundle args = new Bundle();
        args.putInt("PossFragment", position);
        bigImageFragment.setArguments(args);

        step = true;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_fragment_container, bigImageFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
