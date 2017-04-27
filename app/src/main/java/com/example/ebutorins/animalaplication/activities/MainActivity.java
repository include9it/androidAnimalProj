package com.example.ebutorins.animalaplication.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ebutorins.animalaplication.adapters.GridAdapter;
import com.example.ebutorins.animalaplication.dialogs.MyDialogFragment;
import com.example.ebutorins.animalaplication.managers.DataManager;
import com.example.ebutorins.animalaplication.models.Animals;
import com.example.ebutorins.animalaplication.R;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyDialogFragment.OnHeadlineSelectedListener {

    Button button, bAdd;

    //ListView listView;
//    GridView gridView;
    //ListAdapter listAdapter;
    GridAdapter gridAdapter;

    LinearLayout linearLayoutList, linearLayoutGrid;

    MyDialogFragment newFragment;

    @Override
    protected void onResume() {
        super.onResume();
        
//        listAdapter.notifyDataSetChanged();
//        listView.refreshDrawableState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.activity_main_button_switch);
        bAdd = (Button) findViewById(R.id.activity_main_button_add);
//        listView = (ListView) findViewById(R.id.activity_main_list_view);
        linearLayoutList = (LinearLayout) findViewById(R.id.activity_main_layout_list);
//        gridView = (GridView) findViewById(R.id.activity_main_grid_view);
        linearLayoutGrid = (LinearLayout) findViewById(R.id.activity_main_layout_grid);

        button.setOnClickListener(this);
        bAdd.setOnClickListener(this);

//        listAdapter = new ListAdapter(DataManager.getInstance().getAnimalses(),this);
//        listView.setAdapter(listAdapter);
        fillList(DataManager.getInstance().getAnimalses(),this);



//        gridAdapter = new GridAdapter(DataManager.getInstance().getAnimalses(),this);
//        gridView.setAdapter(gridAdapter);
        fillGrid(DataManager.getInstance().getAnimalses(),this);


//        gridView.setAdapter(new GridAdapter(DataManager.getInstance().getAnimalses(),this));



//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                showDialogs(position);
//                return true;
//            }
//        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(MainActivity.this, "" + (position+1),
//                        Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this,FragmentActivity.class);
//                intent.putExtra("Poss",position);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//
//        });

//        setListViewHeightBasedOnChildren();

//        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                showDialogs(position);
//                return true;
//            }
//        });
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(MainActivity.this, "" + (position+1),
//                        Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this,FragmentActivity.class);
//                intent.putExtra("Poss",position);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        });

//        setGridViewHeightBasedOnChildren();

    }

   /* public void setListViewHeightBasedOnChildren() {
        listAdapter = (ListAdapter) listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        View listHeight = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);

            listHeight = listItem;

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = (listHeight.getMeasuredHeight() * (listAdapter.getCount()-1));
        listView.setLayoutParams(params);
        listView.requestLayout();

       *//* int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height *= (totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1)));
        listView.setLayoutParams(params);*//*
    }*/

   /* public void setGridViewHeightBasedOnChildren() {
        gridAdapter = (GridAdapter) gridView.getAdapter();
        if (gridAdapter == null) {
            // pre-condition
            return;
        }

        View gridHeight = null;
        for (int i = 0; i < gridAdapter.getCount(); i++) {
            View gridItem = gridAdapter.getView(i, null, gridView);
            gridItem.measure(0, 0);

            gridHeight = gridItem;
        }

        int columns = 2;
        int totalHeight = gridHeight.getMeasuredHeight();
        int items = gridAdapter.getCount();
        int rows = 0;

        float x = 1;
        if( items > columns ){
            x = items/columns;
            rows = (int) (x + 1);
            totalHeight *= rows;
        }

        ViewGroup.LayoutParams params = gridView.getLayoutParams();

        params.height = gridHeight.getMeasuredHeight();
        gridView.setLayoutParams(params);
        gridView.requestLayout();
    }*/

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.activity_main_button_switch:
                if(linearLayoutList.getVisibility()==View.VISIBLE/*listView.getVisibility()==View.VISIBLE*/){
                    //listView.setVisibility(View.GONE);
                    linearLayoutList.setVisibility(View.GONE);
//                    gridView.setVisibility(View.VISIBLE);
                    linearLayoutGrid.setVisibility(View.VISIBLE);
                    changeButtonBackground(1);
                } else {
                    //listView.setVisibility(View.VISIBLE);
                    linearLayoutList.setVisibility(View.VISIBLE);
//                    gridView.setVisibility(View.GONE);
                    linearLayoutGrid.setVisibility(View.GONE);
                    changeButtonBackground(2);
                }
                break;
            case R.id.activity_main_button_add:
                Intent intent = new Intent(MainActivity.this, AddAnimalActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;

        }

    }

    public void changeButtonBackground(int type){
        switch (type){
            case 1:
                button.setBackgroundResource(R.drawable.list);
                break;
            case 2:
                button.setBackgroundResource(R.drawable.grid);
                break;
        }
    }

    public void showDialogs(int possiton) {


        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        newFragment = MyDialogFragment.newInstance(possiton);
        newFragment.setmCallback(this);
        newFragment.show(ft, "dialog");

    }

    @Override
    public void onArticleSelected() {
       // listAdapter.notifyDataSetChanged();
        newFragment.dismiss();
    }


    public void fillList(final List<Animals> animalses, Context context){
        View convertView = null;

        for(int i = 0; i < animalses.size();i++){
            final int possition = i;

            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.like_list_item, null);


            ImageView imageView;
            TextView txtKind, txtHabitat, txtQuantity, txtHorns, txtWeight;

            imageView = (ImageView) convertView.findViewById(R.id.like_list_item_image);

            txtKind = (TextView) convertView.findViewById(R.id.like_list_item_kindOfAnimal);
            txtHabitat = (TextView) convertView.findViewById(R.id.like_list_item_habitat);
            txtQuantity = (TextView) convertView.findViewById(R.id.like_list_item_quantityTines);
            txtHorns = (TextView) convertView.findViewById(R.id.like_list_item_horns);
            txtWeight = (TextView) convertView.findViewById(R.id.like_list_item_weight);


            imageView.setImageResource((animalses.get(i).getImageId()));

            txtKind.setText(String.format(context.getString(R.string.fragment_details_table_row_text_kind_of_animals), animalses.get(i).getKindOfAnimal()));
            txtHabitat.setText(String.format(context.getString(R.string.fragment_details_table_row_text_habitat), animalses.get(i).getHabitat()));
            txtQuantity.setText(String.format(context.getString(R.string.fragment_details_table_row_text_quantity_tines), Integer.toString(animalses.get(i).getQuantityTines())));
            if (animalses.get(i).isHorns() == false)
                txtHorns.setText(String.format(context.getString(R.string.fragment_details_table_row_horns), context.getString(R.string.fragment_details_table_no_horns)));
            else
                txtHorns.setText(String.format(context.getString(R.string.fragment_details_table_row_horns), context.getString(R.string.fragment_details_table_have_horns)));
            txtWeight.setText(String.format(context.getString(R.string.fragment_details_table_row_text_weight), Integer.toString(animalses.get(i).getWeight())));

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO this need to be removed
                    Toast.makeText(MainActivity.this, "" + (possition+1),
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,FragmentActivity.class);
                    intent.putExtra("Poss",possition);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });

            convertView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    showDialogs(possition);
                    return false;
                }
            });

            linearLayoutList.addView(convertView);
        }



    }

    public void fillGrid(final List<Animals> animalses, Context context){
        View convertView = null;

        for(int i = 0; i < animalses.size(); i++){
            final int possition = i;

            /*Animals item1 = null;
            Animals item2 = null;

            item1 = animalses.get(i);

            if (i+1 < animalses.size()) {
                item2 = animalses.get(i+1);
            }*/

            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.like_grid_item , null, false);

            LinearLayout linearLayoutl = (LinearLayout) convertView.findViewById(R.id.like_grid_item_left_layout);
            LinearLayout linearLayoutr = (LinearLayout) convertView.findViewById(R.id.like_grid_item_right_layout);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.like_grid_item_left_image);
            TextView txtKind = (TextView) convertView.findViewById(R.id.like_grid_item_left_description);

            imageView.setImageResource(animalses.get(possition).getImageId());
            txtKind.setText(String.format(context.getString(R.string.fragment_details_table_row_text_kind_of_animals), animalses.get(possition).getKindOfAnimal()));
//
//            if(animalses.size()%2 != 0 && i == animalses.size()-1) {
//
//            }

            ImageView imageView2 = (ImageView) convertView.findViewById(R.id.like_grid_item_right_image);
            TextView txtKind2 = (TextView) convertView.findViewById(R.id.like_grid_item_right_description);


            if (i+1 < animalses.size()) {
                imageView2.setImageResource(animalses.get(possition+1).getImageId());
                txtKind2.setText(String.format(context.getString(R.string.fragment_details_table_row_text_kind_of_animals), animalses.get(possition+1).getKindOfAnimal()));
            } else if (i == animalses.size()-1){

                linearLayoutr.setVisibility(View.GONE);
            }

            linearLayoutl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO this need to be removed
                    Toast.makeText(MainActivity.this, "" + (possition + 1),
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                    intent.putExtra("Poss", possition);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });

            linearLayoutl.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    showDialogs(possition);
                    return false;
                }
            });

            i++;

            linearLayoutr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO this need to be removed
                    Toast.makeText(MainActivity.this, "" + (possition + 2),
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                    intent.putExtra("Poss", possition+1);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });

            linearLayoutr.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    showDialogs(possition+1);
                    return false;
                }
            });

            linearLayoutGrid.addView(convertView);

        }

    }

}
