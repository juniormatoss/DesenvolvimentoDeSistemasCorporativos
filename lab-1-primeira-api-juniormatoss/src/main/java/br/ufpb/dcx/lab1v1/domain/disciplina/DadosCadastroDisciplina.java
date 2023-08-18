package br.ufpb.dcx.lab1v1.domain.disciplina;

import java.util.List;

public record DadosCadastroDisciplina(
        int id,
        String nome,
        int likes,
        List<double> notas
) {
}
