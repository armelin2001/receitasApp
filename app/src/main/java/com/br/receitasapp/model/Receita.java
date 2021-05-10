package com.br.receitasapp.model;

import java.util.List;

public class Receita {
    private long id;
    private String imgUri;
    private String imgName;
    private String nomeReceita;
    private long qtdPessoas;


    public Receita(long id, String imgUri, String imgName, String nomeReceita,long qtdPessoas) {
        this.id = id;
        this.imgUri = imgUri;
        this.imgName = imgName;
        this.nomeReceita = nomeReceita;
        this.qtdPessoas = qtdPessoas;
    }

    public Receita(long id, String imgUri, String imgName, String nomeReceita) {
        this.id = id;
        this.imgUri = imgUri;
        this.imgName = imgName;
        this.nomeReceita = nomeReceita;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    public long getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(long qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }


}
