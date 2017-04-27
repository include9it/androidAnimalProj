package com.example.ebutorins.animalaplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ebutorins.animalaplication.AnimalAplicationBase;
import com.example.ebutorins.animalaplication.dbhandlers.DBHandler;
import com.example.ebutorins.animalaplication.managers.DataManager;
import com.example.ebutorins.animalaplication.models.Animals;
import com.example.ebutorins.animalaplication.R;

public class AddAnimalActivity extends AppCompatActivity implements View.OnClickListener {

    Button bSave;
    DBHandler db;
    EditText eKind, eHabitat, eQuantity, eHorns, eWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        bSave = (Button) findViewById(R.id.activity_add_animal_save);
        bSave.setOnClickListener(this);

        eKind = (EditText) findViewById(R.id.activity_add_animal_kind_of_animal);
        eHabitat = (EditText) findViewById(R.id.activity_add_animal_habitat);
        eQuantity = (EditText) findViewById(R.id.activity_add_animal_quantity_tines);
        eHorns = (EditText) findViewById(R.id.activity_add_animal_horns);
        eWeight = (EditText) findViewById(R.id.activity_add_animal_weight);

        db = new DBHandler(AnimalAplicationBase.getContext());

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.activity_add_animal_save:
                if(db.addAnimal(
                        new Animals(0,R.drawable.ic_penguin, eKind.getText().toString(),
                                eHabitat.getText().toString(),Integer.valueOf(eQuantity.getText().toString()),
                                Boolean.valueOf(eHorns.getText().toString()),Integer.valueOf(eWeight.getText().toString())))== true){
                    Toast.makeText(AddAnimalActivity.this, "Save" ,
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AddAnimalActivity.this, "Error" ,
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
