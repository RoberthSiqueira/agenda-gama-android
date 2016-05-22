package com.br.agenda.POJO;

/**
 * Created by roberth on 22/05/16.
 */

import java.io.Serializable;

//Classe responsável pelo transporte dos dados entre a
//interface(tela) e Banco de Dados
public class ContatoVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String nome;
    private String telefone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String value) {
        this.nome = value;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String value) {
        this.telefone = value;
    }
    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return nome;
    }
}