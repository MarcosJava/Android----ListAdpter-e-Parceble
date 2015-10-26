package br.com.mrcsfelipe.voo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mrcsfelipe.voo.model.Voo;

/**
 * Created by marcos.pinto on 26/10/2015.
 */
public class VooDao {

    private SQLiteDatabase database;
    private Dao dataBaseHelper;


    public VooDao(Context context) {
        dataBaseHelper = Dao.getInstance(context);
    }


    public void open() throws SQLException {
        database = dataBaseHelper.getWritableDatabase();
    }


    public void close() {
        dataBaseHelper.close();
    }


    public long salvar(Voo voo) throws SQLException {

        ContentValues values = new ContentValues();
        values.put("nome",  voo.getNome());
        values.put("no_voo", voo.getNoVoo());
        values.put("descricao",  voo.getDestino());

        try {

            this.open();
            return database.insert("voo", null, values);
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            this.close();
        }
    }




    public List<Voo> getListVoos() throws SQLException {
        List<Voo> voos = new ArrayList<Voo>();

        try {

            this.open();

            Cursor cursor = database.query("voo", null, null, null, null, null, null);

            while (cursor.moveToNext()) {
                voos.add(new Voo(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
            }
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            this.close();
        }


        return voos;
    }
}
