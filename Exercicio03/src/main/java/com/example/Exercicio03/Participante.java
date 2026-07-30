package com.example.Exercicio03;

public class Participante {
    private String nome;
    private int idade;
    private String equipe;

    public Participante() {
    }

    public Participante(String nome, int idade, String equipe) {
        this.nome = nome;
        setIdade(idade);
        this.equipe = equipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {

        if (idade < 14 || idade > 21) {
            throw new IllegalArgumentException("Idade inválida.");
        }

        this.idade = idade;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return nome + ";" + idade + ";" + equipe;
    }

}
