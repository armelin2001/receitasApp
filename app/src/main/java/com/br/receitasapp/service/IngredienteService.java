package com.br.receitasapp.service;

import android.content.Context;
import android.widget.Toast;

import com.br.receitasapp.model.Ingrediente;
import com.br.receitasapp.repository.ingredienteRepository.IngredienteRepositoryImpl;

import java.util.ArrayList;

public class IngredienteService {
    private static IngredienteService instace = new IngredienteService();
    private IngredienteService(){}
    public static IngredienteService getInstance(){return instace;}
    private IngredienteRepositoryImpl ingredienteRepository;
    private ArrayList<Ingrediente> ingredientes;
    private Context context;
    public void setContext(Context context){
        this.context = context;
        ingredienteRepository = new IngredienteRepositoryImpl(context);
        ingredientes = ingredienteRepository.getAllIngredientes();
    }
    public ArrayList<Ingrediente> getIngredientes(){return ingredientes;}
    public void addIngrediente(Ingrediente ingrediente){
        long id = ingredienteRepository.createIngrediente(ingrediente);
        if(id>0){
            ingrediente.setId(id);
            ingredientes.add(ingrediente);
        }else {
            Toast.makeText(context,
                    "Add ingrediente problem",Toast.LENGTH_LONG).show();
        }
    }

    public void removeIngrediente(int position){

    }
}
