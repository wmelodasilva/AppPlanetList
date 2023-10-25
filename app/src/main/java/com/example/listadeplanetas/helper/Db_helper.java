package com.example.listadeplanetas.helper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.Nullable;

public class Db_helper extends SQLiteOpenHelper {

    public  static int VERSION = 1;
    public  static String NOME_DB = "Planets_DB";

    public static String TABELA_PLANETAS = "planetas";

    public Db_helper(Context context) {
        super(context, NOME_DB,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_PLANETAS
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT)";

        try{
            db.execSQL(sql);
            Log.i("INFO DB", "SUCESSO AO CRIAR");
        }catch (Exception e){
            Log.i("INFO DB", "ERRO AO CRIAR A TABELA");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
