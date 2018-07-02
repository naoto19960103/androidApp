package com.websarva.wings.android.keibadatabasesample;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.provider.ContactsContract;
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
    int horseId = 0;
    //選択された馬名を表すフィールド
    String Horse = "";
    //馬名を表示するTextViewフィールド
    TextView tvHorse;
    //想定騎手を表すフィールド
    String SoteiJockey = "";
    //想定騎手を表示するTextViewフィールド
    TextView tvSoteiJockey;
    //保存ボタンフィールド
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_horse);

        //馬名を表示するTextViewを取得する
        tvHorse = findViewById(R.id.tvHorse);
        //想定騎手を表示するTextView
        tvSoteiJockey = findViewById(R.id.tvSoteiJockey);

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
        horse.put("jockey", "福永祐一");
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
        //リストタップのリスナクラス登録
        lvHorse.setOnItemClickListener(new ListItemClickListener());
    }

    //保存ボタンがタップされたときのメソッド

    public void onSaveButton(View view){
        //希望騎手を取得する
        EditText etJockey = findViewById(R.id.tvJockey);
        String KiboJockey = etJockey.getText().toString();
        //備考欄を取得する
        EditText etNote = findViewById(R.id.etNote);
        String note = etNote.getText().toString();

        //データベースヘルパーオブジェクトの作成
        DatabaseHelper helper = new DatabaseHelper(SelectHorseActivity.this);
        //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            //リストで選択された馬名のメモデータを削除。その後インサートする
            //SQL削除文
            String delete = "delete from KEIBA where id = ?";
            SQLiteStatement sqlStat = db.compileStatement(delete);
            //変数バインド
            sqlStat.bindLong(1,horseId);
            //SQL削除文の実行
            sqlStat.executeUpdateDelete();

            //インサート用のSQLを用意する
            String sqlInsert = "insert into KEIBA(id,horse,SoteiJockey,KiboJockey,memo) values (?,?,?,?,?)";
            sqlStat = db.compileStatement(sqlInsert);
            //変数のバインド
            sqlStat.bindLong(1,horseId);
            sqlStat.bindString(2,Horse);
            sqlStat.bindString(3,SoteiJockey);
            sqlStat.bindString(4,KiboJockey);
            sqlStat.bindString(5,note);
            //インサート分を実行
            sqlStat.executeInsert();


        } finally {
            db.close();
        }

        //保存ボタンをタップできないように変更
        btnSave.setEnabled(false);
    }

    //リストがタップされたときの処理が記述されたメンバクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            //タップされた行番号をフィールドの主キーIDに代入
            horseId = position;
            //タップされが行のデータを取得する。これが馬名となる
            Map<String,String> horse = (Map<String, String>) parent.getItemAtPosition(position);
            Horse = horse.get("name");
            SoteiJockey = horse.get("jockey");
            //馬名を表示するTextViewに表示馬名を設定する
            tvHorse.setText(Horse);
            tvSoteiJockey.setText(SoteiJockey);
            //保存ボタンをタップできるように変更
            btnSave.setEnabled(true);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(SelectHorseActivity.this);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try{
                //主キーによる検索SQLの用意
                String sql = "select * from KEIBA where id =" + horseId;
                //SQL実行
                Cursor cursor = db.rawQuery(sql, null);
                //データベースから取得した値を格納する変数を用意。データがなかった時の初期値も用意する
                String KibouJockey = "";
                String memo = "";
                while(cursor.moveToNext()){
                    //カラムのインデックス値を取得
                    int idxEdit1 = cursor.getColumnIndex("KiboJockey");
                    int idxEdit2 = cursor.getColumnIndex("memo");
                    //カラムのインデックス値をもとに実際のデータを取得
                    KibouJockey = cursor.getString(idxEdit1);
                    memo = cursor.getString(idxEdit2);
                }
                //EditTextの各画面部品を取得しデータベースの値を反映させる
                EditText etNote = findViewById(R.id.etNote);
                EditText etJockey = findViewById(R.id.tvJockey);

                etJockey.setText(KibouJockey);
                etNote.setText(memo);
            }finally {
                db.close();
            }

        }
    }


    public void onSendButton(View view){
        Intent i = new Intent(SelectHorseActivity.this, VoteOkActivity.class);
        startActivity(i);
    }
}
