package com.example.ebutorins.animalaplication.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.ebutorins.animalaplication.models.Animals;
import com.example.ebutorins.animalaplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ebutorins on 5/11/2016.
 */
public class Utils {
    public static List<Animals> fillAnimals(){

        Animals ani1 = new Animals(0,R.drawable.ic_lion,"Lion","Africa",4,false,190);
        Animals ani2 = new Animals(1,R.drawable.ic_elephant,"Elephant","Africa",4,false,6000);
        Animals ani3 = new Animals(2,R.drawable.ic_giraffe,"Giraffe","Africa",4,true,1200);
        Animals ani4 = new Animals(3,R.drawable.ic_penguin,"Penguin","Antarctica",2,false,23);
        Animals ani5 = new Animals(4,R.drawable.ic_cat,"Cat","Home",4,false,4);
        Animals ani6 = new Animals(5,R.drawable.ic_dog,"Dog","Hollywood",4,false,15);

        List<Animals> animalses = new ArrayList<>();
        animalses.add(ani1);
        animalses.add(ani2);
        animalses.add(ani3);
        animalses.add(ani4);
        animalses.add(ani5);
        animalses.add(ani6);

        return animalses;
    }
    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public static float convertSpToPixel(float sp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = sp * (metrics.scaledDensity / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static float convertPixelToSp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float sp = px / (metrics.scaledDensity / DisplayMetrics.DENSITY_DEFAULT);
        return sp;
    }

    public static float convertPtToPixel(float pt, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = pt * ((metrics.xdpi * (1.0f/72)) / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static float convertPixelToPt(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float pt = px / ((metrics.xdpi * (1.0f/72)) / DisplayMetrics.DENSITY_DEFAULT);
        return pt;
    }

    public static float convertInToPixel(float in, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = in * (metrics.xdpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static float convertPixelToIn(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float in = px / (metrics.xdpi / DisplayMetrics.DENSITY_DEFAULT);
        return in;
    }

    public static float convertMmToPixel(float mm, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = mm * ((metrics.xdpi * (1.0f/25.4f)) / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static float convertPixelToMm(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float mm = px / ((metrics.xdpi * (1.0f/25.4f)) / DisplayMetrics.DENSITY_DEFAULT);
        return mm;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    public static int dpToPx(Context context, int dp) {
//        Resources r = context.getResources();
//        return (int) TypedValue.applyDimension(
//                TypedValue.COMPLEX_UNIT_DIP,
//                dp,
//                r.getDisplayMetrics()
//        );
//    }
//
//    public static int pxToDp(int px) {
//        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
//    }
//
//    public static int dpToPx(int dp) {
//        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
//    }

}
