package br.com.senai.patrimonio.atividades;

public class Funcionario {
    private String nome;
    private double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    public double calcularBonificacao(){
        return this.salarioBase*0.05;
    }
}
