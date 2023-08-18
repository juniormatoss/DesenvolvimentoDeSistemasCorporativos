package br.ufpb.dcx.lab1v1.domain.disciplina;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {

    private int id;
    private String nome;
    private int likes;
    private List<double> notas = new ArrayList<double>();


    public Disciplina(DadosCadastroDisciplina dados) {
        this.nome = dados.nome();
        this.likes = dados.likes();
        this.notas = dados.notas();
    }

    public void atualizarInformacoes(DadosAtualizacaoDisciplina dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.likes() != 0) {
            this.likes = dados.likes();
        }

        if (dados.notas() != null) {
            this.notas = dados.notas();
        }
    }

    public double calcularMediaNotas() {
        if (notas == null || notas.isEmpty()) {
            return 0.0; // Retorna 0 se não houver notas ou a lista de notas estiver vazia
        }

        double somaNotas = 0.0;
        for (Double nota : notas) {
            somaNotas += nota;
        }

        return somaNotas / notas.size();
    }


}
