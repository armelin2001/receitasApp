package com.br.receitasapp.repository.receitaRepository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.br.receitasapp.model.Receita;
import com.br.receitasapp.utils.ValuesUtils;

import java.util.ArrayList;

public class ReceitaRepositoryImpl extends SQLiteOpenHelper implements ReceitaRepository {

    private Context context;
    public ReceitaRepositoryImpl(Context context){
        super(context, ValuesUtils.DB_NAME,null,ValuesUtils.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE IF NOT EXISTS %s("+
                        "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT, " + " %s TEXT, " + "%s TEXT, " +
                        "%s INTEGER)"
                ,ValuesUtils.DB_TABLE_RECEITA,ValuesUtils.DB_TABLE_RECEITA_ID
                ,ValuesUtils.DB_TABLE_RECEITA_IMG_URI,ValuesUtils.DB_TABLE_RECEITA_IMG_NAME
                ,ValuesUtils.DB_TABLE_RECEITA_NAME, ValuesUtils.DB_TABLE_RECEITA_QTD_PESSOAS);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    @Override
    public long createReceita(Receita receita) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ValuesUtils.DB_TABLE_RECEITA_IMG_URI,receita.getImgUri());
        values.put(ValuesUtils.DB_TABLE_RECEITA_IMG_NAME,receita.getImgName());
        values.put(ValuesUtils.DB_TABLE_RECEITA_NAME,receita.getNomeReceita());
        values.put(ValuesUtils.DB_TABLE_RECEITA_QTD_PESSOAS,receita.getNomeReceita());
        long id = database.insert(ValuesUtils.DB_TABLE_RECEITA,null,values);
        database.close();
        return id;
    }

    @Override
    public ArrayList<Receita> getAllReceitas() {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.query(ValuesUtils.DB_TABLE_RECEITA,null,null,
                null,null,null,null);
        ArrayList<Receita> receitas = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                long id = cursor.getLong(cursor.getColumnIndex(ValuesUtils.DB_TABLE_RECEITA_ID));
                String nome = cursor.getString(cursor.getColumnIndex(ValuesUtils.DB_TABLE_RECEITA_NAME));
                String imgUri = cursor.getString(cursor.getColumnIndex(ValuesUtils.DB_TABLE_RECEITA_IMG_URI));
                String imgName = cursor.getString(cursor.getColumnIndex(ValuesUtils.DB_TABLE_RECEITA_IMG_NAME));
                Receita receitaTemp = new Receita(id,imgUri,imgName,nome);
                receitas.add(receitaTemp);
            }while (cursor.moveToNext());
        }
        database.close();
        return receitas;
    }

    @Override
    public int updateReceita(Receita receita) {
        return 0;
    }

    @Override
    public int removeReceita(Receita receita) {
        return 0;
    }
}
