package com.example.Exercicio_02;

public class LutadorCorpoACorpo  extends Personagem {

    private int forca;

    public LutadorCorpoACorpo(String nome, int vida, int forca) {
        super(nome, vida);
        this.forca = forca;
    }

    public int getForca() {
        return forca;
    }
}
