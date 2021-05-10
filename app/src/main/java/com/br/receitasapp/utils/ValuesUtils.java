package com.br.receitasapp.utils;

public class ValuesUtils {
    private ValuesUtils(){}
    public static final String DB_NAME = "receitas.sqlite";
    public static final int  DB_VERSION = 1;
    //nome das tabelas
    public static final String DB_TABLE_RECEITA = "Receita";
    public static final String DB_TABLE_INGREDIENTE = "Ingrediente";
    //colunas da receita
    public static final String DB_TABLE_RECEITA_ID = "id";
    public static final String DB_TABLE_RECEITA_IMG_URI = "img_uri";
    public static final String DB_TABLE_RECEITA_IMG_NAME = "img_name";
    public static final String DB_TABLE_RECEITA_NAME = "nome";
    public static final String DB_TABLE_RECEITA_QTD_PESSOAS = "qtd_pessoas";
    //colunas do ingrediente
    public static final String DB_TABLE_INGREDIENTE_ID = "id";
    public static final String DB_TABLE_INGREDIENTE_RECEITA_ID = "receita_id";
    public static final String DB_TABLE_INGREDIENTE_NOME = "nome";
    public static final String DB_TABLE_INGREDIENTE_UNIDADE_MEDIDA = "unidade_medida";
    public static final String DB_TABLE_INGREDIENTE_PESO = "peso";
}
