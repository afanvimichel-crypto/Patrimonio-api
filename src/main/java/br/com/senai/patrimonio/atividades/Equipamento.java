package br.com.senai.patrimonio.atividades;

public class Equipamento  {

    private String nome;
    private double valorInicial;

    public Equipamento(String nome, double valorInicial) {
        this.nome = nome;
        this.valorInicial = valorInicial;
    }

    public String getNome() {
        return nome;
    }

    public double getValorInicial() {
        return valorInicial;
    }



    public double calcularDepreciacao() {
        return this.valorInicial*0.05;
    }
}
