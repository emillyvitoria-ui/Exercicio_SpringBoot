package com.example.Exercicio_02;

public class Atirador  extends Personagem {
    private int precisao;

    public Atirador(String nome, int vida, int precisao) {
        super(nome, vida);
        this.precisao = precisao;
    }

    public int getPrecisao() {
        return precisao;
    }

}
