package br.com.thiengo.opessistema.domain;


public class Opcao {
    private String nome;
    private boolean status;


    public Opcao( String nome, boolean status ){
        this.nome = nome;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean ehStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
