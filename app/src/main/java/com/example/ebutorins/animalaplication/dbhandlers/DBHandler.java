package com.example.ebutorins.animalaplication.dbhandlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ebutorins.animalaplication.models.Animals;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "animalsInfo";
    // Contacts table name
    private static final String TABLE_ANIMALS = "animals";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_IMAGE = "animal_image";
    private static final String KEY_KIND = "kind_name";
    private static final String KEY_AN_HABIT = "habitat";
    private static final String KEY_QUANTITY_TINES = "quantity_tines";
    private static final String KEY_HORNS = "horns";
    private static final String KEY_WEIGHT = "weight";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ANIMALS_TABLE = "CREATE TABLE " + TABLE_ANIMALS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_IMAGE + " TEXT," + KEY_KIND + " TEXT,"
                + KEY_AN_HABIT + " TEXT," + KEY_QUANTITY_TINES + " TEXT,"
                + KEY_HORNS + " TEXT," + KEY_WEIGHT + " TEXT" + ")";
        db.execSQL(CREATE_ANIMALS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMALS);
        // Creating tables again
        onCreate(db);
    }


    // Adding new animal
    public boolean addAnimal(Animals animals) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE, animals.getImageId()); // Animal Image
        values.put(KEY_KIND, animals.getKindOfAnimal()); // Animal Name
        values.put(KEY_AN_HABIT, animals.getHabitat()); // Animal habitat
        values.put(KEY_QUANTITY_TINES, animals.getQuantityTines()); // Animal quantity tines
        values.put(KEY_HORNS, animals.isHorns()); // Animal horns
        values.put(KEY_WEIGHT, animals.getWeight()); // Animal weight
        // Inserting Row
        db.insert(TABLE_ANIMALS, null, values);
        db.close(); // Closing database connection

        return true;
    }

    // Getting one animal
    public Animals getAnimal(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ANIMALS, new String[] { KEY_ID, KEY_IMAGE,
                        KEY_KIND, KEY_AN_HABIT, KEY_QUANTITY_TINES, KEY_HORNS, KEY_WEIGHT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Animals identificate = new Animals(
                Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)),
                cursor.getString(2),cursor.getString(3), Integer.parseInt(cursor.getString(4)),
                Boolean.parseBoolean(cursor.getString(5)), Integer.parseInt(cursor.getString(6))
        );
        // return shop
        return identificate;
    }

    // Getting All Animals
    public List<Animals> getAllAnimals() {
        List<Animals> animalsList = new ArrayList<Animals>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_ANIMALS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Animals animals = new Animals();
                animals.setAnimalId(Integer.parseInt(cursor.getString(0)));
                animals.setImageId(Integer.parseInt(cursor.getString(1)));
                animals.setKindOfAnimal(cursor.getString(2));
                animals.setHabitat(cursor.getString(3));
                animals.setQuantityTines(Integer.parseInt(cursor.getString(4)));
                animals.setHorns(Boolean.parseBoolean(cursor.getString(5)));
                animals.setWeight(Integer.parseInt(cursor.getString(6)));
                // Adding contact to list
                animalsList.add(animals);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return animalsList;
    }

    // Getting animals Count
    public int getAnimalsCount() {
        String countQuery = "SELECT * FROM " + TABLE_ANIMALS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    // Updating an animal
    public int updateAnimal(Animals animals) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE, animals.getImageId());
        values.put(KEY_KIND, animals.getKindOfAnimal());
        values.put(KEY_AN_HABIT, animals.getHabitat());
        values.put(KEY_QUANTITY_TINES, animals.getQuantityTines());
        values.put(KEY_HORNS, animals.isHorns());
        values.put(KEY_WEIGHT, animals.getWeight());
        // updating row
        return db.update(TABLE_ANIMALS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(animals.getAnimalId())});
    }

    // Deleting an animal
    public void deleteAnimal(Animals animals) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ANIMALS, KEY_ID + " = ?",
                new String[] { String.valueOf(animals.getAnimalId()) });
        db.close();
    }

}