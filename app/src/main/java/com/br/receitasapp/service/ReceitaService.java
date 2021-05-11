package com.br.receitasapp.service;

import android.content.Context;
import android.widget.Toast;

import com.br.receitasapp.model.Receita;
import com.br.receitasapp.repository.receitaRepository.ReceitaRepositoryImpl;

import java.util.ArrayList;

public class ReceitaService {
    private static ReceitaService instance = new ReceitaService();
    private ReceitaService(){}
    public static ReceitaService getInstance(){
        return instance;
    }
    private ReceitaRepositoryImpl receitaRepository;
    //chamar a service de ingrediente
    private ArrayList<Receita> receitas;
    private Context context;
    /**
     * temos que implementar uma consulta no
     * service de ingredientes para quando formos fazer
     * um edit de receita ou ate deletar ela.
     *
     * como fazer?
     * RESPOSTA:chamar a service do ingrediente, carregar
     * toda a lista de ingredientes(sim isso vai deixar o app mais pesado)
     * e depois de carregada a lista dos ingredientes, nos fazemos uma seleção pelos compos correspondentes
     * */
    public void setContext(Context context){
        this.context = context;
        receitaRepository = new ReceitaRepositoryImpl(context);
        receitas = receitaRepository.getAllReceitas();
    }
    public ArrayList<Receita> getReceitas(){
        return receitas;
    }
    public void addReceita(Receita receita){
        long id = receitaRepository.createReceita(receita);
        if(id>0){
            receita.setId(id);
            receitas.add(receita);
        }else {
            Toast.makeText(context,
                    "Add receitas problem",Toast.LENGTH_LONG).show();
        }
    }
    public void editReceita(Receita receita, int position){
        int count  = receitaRepository.updateReceita(receita);
        if(count >0){
            receitas.set(position,receita);
        }
    }
    public void removeReceita(int position){
        int count =  receitaRepository.removeReceita(receitas.get(position));
        if(count > 0){
            receitas.remove(position);
        }
    }
}
