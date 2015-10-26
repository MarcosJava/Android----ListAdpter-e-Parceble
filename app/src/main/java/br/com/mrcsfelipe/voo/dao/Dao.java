package br.com.mrcsfelipe.voo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marcos.pinto on 26/10/2015.
 */
public class Dao extends SQLiteOpenHelper {


    private static final String DATABASE_NAME    = " voo.db";
    private static final int    DATABASE_VERSION = 3;


    private static final String DATABASE_CREATE = "create table voo " +
            "(id     integer primary key autoincrement, "             +
            " nome  text not null, "                                 +
            " no_voo   integer not null, "                                 +
            " descricao  text not null);";


    private static Dao _instance;


    private Dao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public static Dao getInstance(Context context) {
        if (_instance == null) {
            _instance = new Dao(context);
        }

        return _instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
       // database.execSQL("drop table if exists voo");
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i2) {
        database.execSQL("drop table if exists voo");
        this.onCreate(database);
    }
}
