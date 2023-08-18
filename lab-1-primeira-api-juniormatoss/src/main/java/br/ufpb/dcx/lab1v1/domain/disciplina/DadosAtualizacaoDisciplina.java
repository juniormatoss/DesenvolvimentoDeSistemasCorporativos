package br.ufpb.dcx.lab1v1.domain.disciplina;

import java.util.List;

public record DadosAtualizacaoDisciplina(
        String nome,
        int likes,
        List<double> notas
) {

}
