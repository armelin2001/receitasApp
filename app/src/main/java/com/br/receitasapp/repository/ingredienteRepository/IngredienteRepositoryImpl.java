package com.br.receitasapp.repository.ingredienteRepository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.br.receitasapp.model.Ingrediente;
import com.br.receitasapp.model.Receita;
import com.br.receitasapp.utils.ValuesUtils;

import java.util.ArrayList;

public class IngredienteRepositoryImpl extends SQLiteOpenHelper implements IngredienteRepository {

    private Context context;

    public IngredienteRepositoryImpl(Context context){
        super(context,ValuesUtils.DB_NAME,null,ValuesUtils.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE IF NOT EXISTS %s(" +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s INTEGER, " + "%s TEXT, " + "%s TEXT, " + "%s REAL, "+
                "FOREIGN KEY (%s)" +" REFERENCES %s " + "(%s))"
                ,ValuesUtils.DB_TABLE_INGREDIENTE, ValuesUtils.DB_TABLE_INGREDIENTE_ID, ValuesUtils.DB_TABLE_INGREDIENTE_RECEITA_ID
                ,ValuesUtils.DB_TABLE_INGREDIENTE_NOME,ValuesUtils.DB_TABLE_INGREDIENTE_UNIDADE_MEDIDA, ValuesUtils.DB_TABLE_INGREDIENTE_PESO
                ,ValuesUtils.DB_TABLE_INGREDIENTE_RECEITA_ID,ValuesUtils.DB_TABLE_RECEITA,ValuesUtils.DB_TABLE_RECEITA_ID
        );
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    @Override
    public long createIngrediente(Ingrediente ingrediente) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ValuesUtils.DB_TABLE_INGREDIENTE_RECEITA_ID,ingrediente.getIdReceita());
        values.put(ValuesUtils.DB_TABLE_INGREDIENTE_NOME,ingrediente.getNome());
        values.put(ValuesUtils.DB_TABLE_INGREDIENTE_UNIDADE_MEDIDA,ingrediente.getUnidadeMedida());
        values.put(ValuesUtils.DB_TABLE_INGREDIENTE_PESO,ingrediente.getPeso());
        long id = database.insert(ValuesUtils.DB_TABLE_INGREDIENTE,null,values);
        database.close();
        return id;
    }

    @Override
    public ArrayList<Ingrediente> getAllIngredientes() {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.query(ValuesUtils.DB_TABLE_INGREDIENTE,null,null,
                null,null,null,null);
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                long id = cursor.getLong(cursor.getColumnIndex(ValuesUtils.DB_TABLE_RECEITA_ID));
                String nome = cursor.getString(cursor.getColumnIndex(ValuesUtils.DB_TABLE_INGREDIENTE_NOME));
                float peso = cursor.getFloat(cursor.getColumnIndex(ValuesUtils.DB_TABLE_INGREDIENTE_PESO));
                String unidadeMedida = cursor.getString(cursor.getColumnIndex(ValuesUtils.DB_TABLE_INGREDIENTE_UNIDADE_MEDIDA));
                Ingrediente ingredienteTemp = new Ingrediente(id,nome,peso,unidadeMedida);
                ingredientes.add(ingredienteTemp);
            }while (cursor.moveToNext());
        }
        database.close();
        return ingredientes;
    }


    @Override
    public int removeIngrediente(Ingrediente ingrediente) {
        return 0;
    }

}
