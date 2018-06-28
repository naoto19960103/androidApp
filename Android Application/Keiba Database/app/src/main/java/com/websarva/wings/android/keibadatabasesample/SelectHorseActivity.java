package com.websarva.wings.android.keibadatabasesample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectHorseActivity extends AppCompatActivity {
    //選択された馬の主キーIDを表すフィールド
    //int horseId = 0;
    //選択された馬の名前を表すフィールド
    //String horseName = "";
    //馬名を表示するTextViewフィールド
    TextView tvHorse;
    //保存ボタンフィールド
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_horse);

        //馬名を表示するTextViewを取得する
        tvHorse = findViewById(R.id.tvHorse);

        //保存ボタンを取得する
        btnSave = findViewById(R.id.btnSave);
        //馬名リストの表示
        ListView lvHorse = findViewById(R.id.lvSelectHorse);
        //SimpleAdapterで使用するListオブジェクトを用意
        List<Map<String, String>> horseList = new ArrayList<>();
        Map<String, String> horse = new HashMap<>();
        //horseListへデータを登録する
        horse = new HashMap<>();
        horse.put("name", "サトノダイヤモンド");
        horse.put("jockey", "C.ルメール");
        horse.put("win", "2016有馬記念\n2016菊花賞");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "スワーヴリチャード");
        horse.put("jockey", "M.デムーロ");
        horse.put("win", "2018大阪杯");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "アーモンドアイ");
        horse.put("jockey", "C.ルメール");
        horse.put("win", "2018桜花賞\n2018優駿牝馬");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "ラッキーライラック");
        horse.put("jockey", "石橋脩");
        horse.put("win", "2017阪神JF");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "ワグネリアン");
        horse.put("jockey", "福永祐一");
        horse.put("win", "2018東京優駿");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "ヴィブロス");
        horse.put("jockey", "モレイラ");
        horse.put("win", "2016秋華賞\n2017ドバイターフ");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "ゴールドアクター");
        horse.put("jockey", "吉田隼人");
        horse.put("win", "2015有馬記念");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "レイデオロ");
        horse.put("jockey", "C.ルメール");
        horse.put("win", "2017東京優駿");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "アルアイン");
        horse.put("jockey", "松山弘平");
        horse.put("win", "2017皐月賞");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "シュヴァルグラン");
        horse.put("jockey", "H.ボーマン");
        horse.put("win", "2017ジャパンカップ");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "ソウルスターリング");
        horse.put("jockey", "C.ルメール");
        horse.put("win", "2017優駿牝馬");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "エポカドーロ");
        horse.put("jockey", "戸崎圭太");
        horse.put("win", "2018皐月賞");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "リスグラシュー");
        horse.put("jockey", "武豊");
        horse.put("win", "2018AJCC");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "キセキ");
        horse.put("jockey", "M.デムーロ");
        horse.put("win", "2017菊花賞");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "クリンチャー");
        horse.put("jockey", "藤岡雄介");
        horse.put("win", "2018京都記念");
        horseList.add(horse);

        horse = new HashMap<>();
        horse.put("name", "サトノクラウン");
        horse.put("jockey", "M.デムーロ");
        horse.put("win", "2017宝塚記念");
        horseList.add(horse);


        String[] from = {"name", "jockey"};
        int[] to = {android.R.id.text1, android.R.id.text2};
        //SimpleAdapter生成
        //SimpleAdapterはList<Map<String,?>>を使う時に利用するアダプタクラス
        SimpleAdapter adapter = new SimpleAdapter(SelectHorseActivity.this, horseList, android.R.layout.simple_list_item_2, from, to);
        //アダプタを登録
        lvHorse.setAdapter(adapter);
    }

    //保存ボタンがタップされたときのメソッド

   public void onSaveButton(View view){
        //備考欄を取得する
        EditText etNote = findViewById(R.id.etNote);
        //馬名を未選択に変更
        tvHorse.setText(getString(R.string.tvSelect));
        //備考欄の入力値を消去
        etNote.setText("");
        //保存ボタンをタップできないように変更
        btnSave.setEnabled(false);
    }

    public void onSendButton(View view){
        Intent i = new Intent(SelectHorseActivity.this, VoteOkActivity.class);
        startActivity(i);
    }
/*
    //リストがタップされたときの処理が記述されたメンバクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            //タップされた行番号をフィールドの主キーIDに代入
            horseId = position;
            //タップされが行のデータを取得する。これが馬名となる
            horseName = (String)parent.getItemAtPosition(position);
            //馬名を表示するTextViewに表示馬名を設定する
            tvHorse.setText(horseName);
            //保存ボタンをタップできるように変更
            btnSave.setEnabled(true);
        }
    }*/
}
