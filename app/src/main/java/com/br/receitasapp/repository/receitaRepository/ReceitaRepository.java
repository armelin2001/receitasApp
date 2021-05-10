package com.br.receitasapp.repository.receitaRepository;

import android.database.sqlite.SQLiteOpenHelper;

import com.br.receitasapp.model.Receita;

import java.util.ArrayList;

public interface ReceitaRepository{
    long createReceita(Receita receita);
    ArrayList<Receita> getAllReceitas();
    int updateReceita(Receita receita);
    int removeReceita(Receita receita);
}
