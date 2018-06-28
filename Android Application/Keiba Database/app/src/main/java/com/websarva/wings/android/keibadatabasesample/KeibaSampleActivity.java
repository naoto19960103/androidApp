package com.websarva.wings.android.keibadatabasesample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KeibaSampleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keiba_sample);

    }
    public void onStartButton(View view){
        //インテントオブジェクト
        Intent i = new Intent(KeibaSampleActivity.this,SelectHorseActivity.class);
        startActivity(i);
    }
}
