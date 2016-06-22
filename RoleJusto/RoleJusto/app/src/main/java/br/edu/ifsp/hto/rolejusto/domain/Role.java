package br.edu.ifsp.hto.rolejusto.domain;

import com.google.gson.annotations.SerializedName;

public class Role {
    public Role() {
        distancia = 0;
        totalPedagio = 0;
        valorLitroCombustivel = 0;
        valorTotalCombustivel = 0;
        consumo = 0;
        qtdPessoas = 1;
        valorTotalRole = 0;
        valorPorPessoa = 0;
    }

    @SerializedName("n_role")
    private int n_role;

    @SerializedName("distancia")
    private double distancia;

    @SerializedName("valor_total_pedagio")
    private double totalPedagio;

    @SerializedName("valor_litro_combustivel")
    private double valorLitroCombustivel;

    @SerializedName("valor_total_combustivel")
    private double valorTotalCombustivel;

    @SerializedName("consumo")
    private double consumo;

    @SerializedName("quant_pessoas")
    private int qtdPessoas;

    @SerializedName("valor_total_role")
    private double valorTotalRole;

    @SerializedName("valor_por_pessoa")
    private double valorPorPessoa;

    public int getN_role() {
        return n_role;
    }

    public void setN_role(int n_role) {
        this.n_role = n_role;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getTotalPedagio() {
        return totalPedagio;
    }

    public void setTotalPedagio(double totalPedagio) {
        this.totalPedagio = totalPedagio;
    }

    public double getValorLitroCombustivel() {
        return valorLitroCombustivel;
    }

    public void setValorLitroCombustivel(double valorLitroCombustivel) {
        this.valorLitroCombustivel = valorLitroCombustivel;
    }

    public double getValorTotalCombustivel() {
        return valorTotalCombustivel;
    }

    public void setValorTotalCombustivel(double valorTotalCombustivel) {
        this.valorTotalCombustivel = valorTotalCombustivel;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public double getValorTotalRole() {
        return valorTotalRole;
    }

    public void setValorTotalRole(double valorTotalRole) {
        this.valorTotalRole = valorTotalRole;
    }

    public double getValorPorPessoa() {
        return valorPorPessoa;
    }

    public void setValorPorPessoa(double valorPorPessoa) {
        this.valorPorPessoa = valorPorPessoa;
    }
}