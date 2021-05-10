package com.br.receitasapp.repository.ingredienteRepository;

import com.br.receitasapp.model.Ingrediente;

import java.util.ArrayList;

public interface IngredienteRepository {
    long createIngrediente(Ingrediente ingrediente);
    ArrayList<Ingrediente> getAllIngredientes();
    int removeIngrediente(Ingrediente ingrediente);
}
