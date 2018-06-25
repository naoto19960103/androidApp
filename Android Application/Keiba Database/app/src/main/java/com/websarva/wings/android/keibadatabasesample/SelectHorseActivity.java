package com.websarva.wings.android.keibadatabasesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class SelectHorseActivity extends AppCompatActivity {

    ListView horseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_horse);

        //馬名リストの表示
        horseList = findViewById(R.id.lvSelectHorse);


    }
}
