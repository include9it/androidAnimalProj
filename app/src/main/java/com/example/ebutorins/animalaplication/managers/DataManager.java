package com.example.ebutorins.animalaplication.managers;


import com.example.ebutorins.animalaplication.AnimalAplicationBase;
import com.example.ebutorins.animalaplication.dbhandlers.DBHandler;
import com.example.ebutorins.animalaplication.models.Animals;
import com.example.ebutorins.animalaplication.utils.Utils;

import java.util.List;

/**
 * Created by ebutorins on 5/11/2016.
 */
public class DataManager {

    private static List<Animals> animalses;

    private static DBHandler dbHandler;

    private static DataManager instance;

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();

        }
        getDBInstance();
        animalses = dbHandler.getAllAnimals();

        return instance;
    }

    public DataManager() {
//        animalses = new ArrayList<>();
    }

    private static void getDBInstance(){
        if(dbHandler == null){
            dbHandler = new DBHandler(AnimalAplicationBase.getContext());
            List<Animals>  temp = Utils.fillAnimals();
            if(dbHandler.getAnimalsCount() < 1){
                for(int i = 0; i<temp.size(); i++){
                    dbHandler.addAnimal(temp.get(i));
                }
            }
        }
    }

    public List<Animals> getAnimalses() {
        return animalses;
    }

}
