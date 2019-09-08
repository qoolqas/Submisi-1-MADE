package com.example.moviecatalog;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private FilmAdapter adapter;
    private ArrayList<Res> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setBackgroundResource(R.drawable.customshape);
        prepare();
        addItem();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Res items = new Res();
                items.setPhoto(dataPhoto.getResourceId(position, -1));
                items.setFilm(dataName[position]);
                items.setDescription(dataDescription[position]);
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra(SecondActivity.EXTRA_NAME,items);
                startActivity(intent);
            }
        });
    }
    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private  void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Res res = new Res();
            res.setPhoto(dataPhoto.getResourceId(i, -1));
            res.setFilm(dataName[i]);
            res.setDescription(dataDescription[i]);
            films.add(res);
        }

        adapter.setFilms(films);
    }
}
