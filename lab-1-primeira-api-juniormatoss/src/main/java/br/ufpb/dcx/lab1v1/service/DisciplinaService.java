package br.ufpb.dcx.lab1v1.service;

import br.ufpb.dcx.lab1v1.domain.disciplina.Disciplina;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    private List<Disciplina> disciplinas = new ArrayList<>();


    //adicionar
    public void adicionar(Disciplina disciplina){
        disciplinas.add(disciplina);
    }

    //listar
    public List<Disciplina> listar() {

        return disciplinas;
    }

    //listar a classe disciplina
    public Disciplina listarDisciplina(int id) {
        return disciplinas.get(id);
    }

    // pegar por id
    public List<Disciplina> pegarPorId(int id) {
        List<Disciplina> disciplinasPorId = new ArrayList<>();

        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                disciplinasPorId.add(disciplina);
            }
        }

        return disciplinasPorId;
    }

    public void deletar(int id) {

        this.disciplinas.remove(id);
    }

    public void atualizar(int id, Disciplina disciplina) {

        int disciplinaId = this.disciplinas.get(id).getId();

        if (disciplinaId == id) {
            this.disciplinas.set(id, disciplina);
        }


    }

    public Disciplina adicionarNota(int id, double nota) {

        Disciplina disciplina = this.disciplinas.get(id);
        disciplina.getNotas().add(nota);
        return disciplina;

    }
// < Inicio sobrecarga

    public Disciplina adicionarLike(int id) {
        Disciplina disciplina = this.disciplinas.get(id);
        disciplina.setLikes(disciplina.getLikes() + 1);

        return disciplina;

    }

    public Disciplina adicionarLike(int id, int like) {
        var disciplina = this.disciplinas.get(id);
        disciplina.setLikes(like);

        return disciplina;
    }

// Fim sobrecarga >

    public List<Disciplina> obterRankingDisciplinas() {

        List<Disciplina> ranking = disciplinas.stream()
                .sorted(Comparator.comparingDouble(Disciplina::calcularMediaNotas).reversed())
                .collect(Collectors.toList());

        return ranking;
    }


}
