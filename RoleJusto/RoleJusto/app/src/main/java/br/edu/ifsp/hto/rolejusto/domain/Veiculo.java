package br.edu.ifsp.hto.rolejusto.domain;

import com.google.gson.annotations.SerializedName;

public class Veiculo {

    public Veiculo() {
        nome_vei = "n/a";
        modelo_vei = "n/a";
        ano_vei = 0;
        combustivel_vei = "n/a";
        consumo_vei = 0;
    }

    @SerializedName("n_vei")
    private int n_vei;

    @SerializedName("nome_vei")
    private String nome_vei;

    @SerializedName("modelo_vei")
    private String modelo_vei;

    @SerializedName("ano_vei")
    private int ano_vei;

    @SerializedName("combustivel_vei")
    private String combustivel_vei;

    @SerializedName("consumo_vei")
    private float consumo_vei;

    public int getN_vei() {
        return n_vei;
    }

    public void setN_vei(int n_vei) {
        this.n_vei = n_vei;
    }

    public String getNome_vei() {
        return nome_vei;
    }

    public void setNome_vei(String nome_vei) {
        this.nome_vei = nome_vei;
    }

    public String getModelo_vei() {
        return modelo_vei;
    }

    public void setModelo_vei(String modelo_vei) {
        this.modelo_vei = modelo_vei;
    }

    public int getAno_vei() {
        return ano_vei;
    }

    public void setAno_vei(int ano_vei) {
        this.ano_vei = ano_vei;
    }

    public String getCombustivel_vei() {
        return combustivel_vei;
    }

    public void setCombustivel_vei(String combustivel_vei) {
        this.combustivel_vei = combustivel_vei;
    }

    public float getConsumo_vei() {
        return consumo_vei;
    }

    public void setConsumo_vei(float consumo_vei) {
        this.consumo_vei = consumo_vei;
    }
}
