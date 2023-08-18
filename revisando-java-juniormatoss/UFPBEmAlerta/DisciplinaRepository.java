import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class DisciplinaRepository {
    private List<Disciplina> disciplinas;

    public DisciplinaRepository() {
        disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Disciplina> recuperarDisciplinas() {
        return disciplinas;
    }

    public Disciplina atualizarNomeDisciplina(int id, String novoNome) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                disciplina.setNome(novoNome);
                return disciplina;
            }
        }
        return null;
    }

    public void adicionarNota(int id, Double novaNota) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                disciplina.getNotas().add(novaNota);
                return;
            }
        }
    }

    public Disciplina adicionarComentario(int id, Comentario comentario) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                disciplina.getComentarios().add(comentario);
                return disciplina;
            }
        }
        return null;
    }

    public void removerComentario(int idComentario) {
        for (Disciplina disciplina : disciplinas) {
            List<Comentario> comentarios = disciplina.getComentarios();
            for (Comentario comentario : comentarios) {
                if (comentario.getId() == idComentario) {
                    comentario.setRemovido(true);
                    return;
                }
            }
        }
    }

    public Disciplina removerDisciplina(int id) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getId() == id) {
                Disciplina disciplinaRemovida = disciplinas.remove(i);
                removerComentariosDaDisciplina(disciplinaRemovida);
                return disciplinaRemovida;
            }
        }
        return null;
    }

    public Disciplina recuperarDisciplina(int id) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                return disciplina;
            }
        }
        return null;
    }

    public List<Disciplina> recuperarDisciplinasOrdenadasPorNotaMedia() {
        List<Disciplina> disciplinasOrdenadas = new ArrayList<>(disciplinas);
        Collections.sort(disciplinasOrdenadas, Comparator.comparingDouble(Disciplina::calcularMediaNotas).reversed());
        return disciplinasOrdenadas;
    }

    private void removerComentariosDaDisciplina(Disciplina disciplina) {
        List<Comentario> comentarios = disciplina.getComentarios();
        comentarios.removeIf(Comentario::isRemovido);
    }
}