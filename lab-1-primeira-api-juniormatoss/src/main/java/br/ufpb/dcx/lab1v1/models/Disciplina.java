package br.ufpb.dcx.lab1v1.models;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private int id;
    private String nome;
    private int Likes;
    private List<Double> notas;

    public Disciplina(int id, String nome, int likes) {
        this.id = id;
        this.nome = nome;
        this.Likes = likes;
        this.notas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

}
