package br.ufpb.dcx.lab1v1.domain.disciplina;

import java.util.List;

public record DadosListagemDisciplina(
        int id,
        String nome,
        int likes,
        List<double> notas
) {


    public DadosListagemDisciplina(Disciplina disciplina) {
        this(disciplina.getId(), disciplina.getNome(), disciplina.getLikes(), disciplina.getNotas());
    }



}
