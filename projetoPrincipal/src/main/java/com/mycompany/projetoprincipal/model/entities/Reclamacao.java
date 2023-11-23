package com.mycompany.projetoprincipal.model.entities;

public class Reclamacao 
{
    private Integer id;
    private String reclamar;
    private String endereco;
    private String setor;
    private String enviar;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReclamar() {
        return reclamar;
    }

    public void setReclamar(String Reclamar) {
        this.reclamar = Reclamar;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String Endereco) {
        this.endereco = Endereco;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String Setor) {
        this.setor = Setor;
    }

    public String getEnviar() {
        return enviar;
    }

    public void setEnviar(String Enviar) {
        this.enviar = Enviar;
    }
}