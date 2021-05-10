package com.br.receitasapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import com.br.receitasapp.R;
import com.br.receitasapp.model.Receita;
import com.br.receitasapp.service.IngredienteService;
import com.br.receitasapp.service.ReceitaService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private ArrayList<Receita> receitas;
    private List<String> nomeReceitas;
    private List<String> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);
        receitas = ReceitaService.getInstance().getReceitas();
        for (int i=0; i<receitas.size();i++){
            nomeReceitas.add(receitas.get(i).getNomeReceita());
            //concatenando path mais o nome da imagem
            images.add(receitas.get(i).getImgUri()+receitas.get(i).getImgName());
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(gridLayoutManager);
        recyclerview.setHasFixedSize(true);
    }
}