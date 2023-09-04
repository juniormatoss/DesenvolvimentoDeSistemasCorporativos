package br.ufpb.dcx.lab1v1.domain.disciplina;

import java.util.List;

public record DadosDetalhamentoDisciplina(int id, String nome, int likes, List<Double> notas) {

    public DadosDetalhamentoDisciplina(Disciplina disciplina) {
        this(disciplina.getId(), disciplina.getNome(), disciplina.getLikes(), disciplina.getNotas());
    }


}
