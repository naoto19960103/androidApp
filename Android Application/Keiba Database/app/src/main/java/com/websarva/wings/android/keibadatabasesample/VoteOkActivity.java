package com.websarva.wings.android.keibadatabasesample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class VoteOkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_ok);
    }
    public void onBackButton(View view){
        Intent i = new Intent(VoteOkActivity.this,KeibaSampleActivity.class);
        startActivity(i);
    }
}
