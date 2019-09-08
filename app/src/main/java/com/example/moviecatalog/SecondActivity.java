package com.example.moviecatalog;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    TextView name,desc;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Res res = getIntent().getParcelableExtra(EXTRA_NAME);
        name = findViewById(R.id.txt_name);
        desc = findViewById(R.id.txt_description);
        img = findViewById(R.id.img_photo);

        name.setText(res.getFilm());
        desc.setText(res.getDescription());
        img.setImageResource(res.getPhoto());
    }
}
