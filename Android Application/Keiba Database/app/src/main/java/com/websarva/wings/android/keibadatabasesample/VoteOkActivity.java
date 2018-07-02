package com.websarva.wings.android.keibadatabasesample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VoteOkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_ok);

        //インテントオブジェクト取得
      //  Intent i  = getIntent();
        //渡されたデータを取得する
       // String horse = i.getStringExtra("horse");
        //String SoteiJockey = i.getStringExtra("soteiJockey");
        //馬名と想定騎手を表示するTextViewを取得する
        //TextView tvSoteiJockey = findViewById(R.id.tvSoteiJockey);
        //TextView tvHorse = findViewById(R.id.tvOkHorse);
        //馬名と想定騎手を表示する
        //tvHorse.setText(horse);
        //tvSoteiJockey.setText(SoteiJockey);
    }
    public void onBackButton(View view){
        Intent i = new Intent(VoteOkActivity.this,KeibaSampleActivity.class);
        startActivity(i);
    }
}
