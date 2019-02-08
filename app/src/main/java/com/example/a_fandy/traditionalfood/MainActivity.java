package com.example.a_fandy.traditionalfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<Food> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;
//    private String title = "List Food";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(FoodData.getListData());
//        setActionBarTitle("List Food");
//        showRecyclerList();

        if (savedInstanceState == null) {
            setActionBarTitle("Card Food");
//            list.addAll(FoodData.getListData());
            showRecyclerCardView();
            mode = R.id.action_cardview;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Food> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
//            list.addAll(stateList);
            setMode(stateMode);
        }

    }

    private void showSelectedFood(Food food) {
//        Toast.makeText(this, "Kamu memilih " + food.getName(), Toast.LENGTH_SHORT).show();
        Intent detailActivity = new Intent(MainActivity.this, DetailActivity.class);
        detailActivity.putExtra(DetailActivity.EXTRA_NAME, food.getName());
        detailActivity.putExtra(DetailActivity.EXTRA_REMARKS,food.getRemarks());
        detailActivity.putExtra(DetailActivity.EXTRA_DESKRIPSI,food.getDeskripsi());
        detailActivity.putExtra(DetailActivity.EXTRA_IMG,food.getPhoto());
        startActivity(detailActivity);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListFoodAdapter listFoodAdapter = new ListFoodAdapter(this);
        listFoodAdapter.setListFood(list);
        rvCategory.setAdapter(listFoodAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedFood(list.get(position));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
//        String title = null;
        switch (selectedMode){
            case R.id.action_list:
                setActionBarTitle("List Food");
                showRecyclerList();
                break;
            case R.id.action_grid:
                setActionBarTitle("Grid Food");
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                setActionBarTitle("Card Food");
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
//        setActionBarTitle(title);
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridFoodAdapter gridFoodAdapter = new GridFoodAdapter(this);
        gridFoodAdapter.setListFood(list);
        rvCategory.setAdapter(gridFoodAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedFood(list.get(position));
            }
        });
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewFoodAdapter cardViewFoodAdapter = new CardViewFoodAdapter(this);
        cardViewFoodAdapter.setListFood(list);
        rvCategory.setAdapter(cardViewFoodAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedFood(list.get(position));
            }
        });
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
