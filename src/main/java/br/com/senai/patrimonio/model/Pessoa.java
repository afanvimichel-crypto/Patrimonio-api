package br.com.senai.patrimonio.model;

public class Pessoa {
    private Long id;
    private String nome;
    private String cpf;

    public Pessoa(){}

    public Pessoa(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    /**
    * Metód com implementaçáo padráo na super classe mas que pode ser
    * sobrescrito com (@verride) pelas subclasses
    * ver {@link Funcionario#getIdentificacao()}.
    * isso caracteriza o POLIMORFISMO: a mesma chamada getIdentificacao()
    * se comporta de forma diferente dependendo do objeto em memória *
     */
    public String getIdentificacao(){
        return "(Nome: " +this.nome +")>>>>"+" (CPF: "+this.cpf + ")";
    }
}
