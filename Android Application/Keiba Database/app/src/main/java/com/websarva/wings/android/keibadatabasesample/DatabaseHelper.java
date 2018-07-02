package com.websarva.wings.android.keibadatabasesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //データベースファイルの定数フィールド
    private static final String database_name = "Keiba.db";
    //バージョン情報の定数フィールド
    private static final int database_version = 1;
    //コンストラクタ
    public DatabaseHelper(Context context){
        //親クラスのコンストラクタ呼び出し
        super(context, database_name,null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //テーブル作成用のSQL文字列の作成
        StringBuilder sb = new StringBuilder();
        sb.append("create table KEIBA(");
        sb.append("id integer primary key,");
        sb.append("horse text,");
        sb.append("SoteiJockey text,");
        sb.append("KiboJockey text,");
        sb.append("memo text);");
        String sql = sb.toString();
        //SQL実行
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
