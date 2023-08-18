import java.util.List;

class SistemaDeAvaliacaoDisciplinas {
    private UsuarioRepository usuarioRepository;
    private DisciplinaRepository disciplinaRepository;

    public SistemaDeAvaliacaoDisciplinas() {
        usuarioRepository = new UsuarioRepository();
        disciplinaRepository = new DisciplinaRepository();
    }

    public void adicionarUsuario(Aluno usuario) {
        usuarioRepository.adicionarUsuario(usuario);
    }

    public List<Aluno> recuperarUsuarios() {
        return usuarioRepository.recuperarUsuarios();
    }

    public Aluno realizarLogin(String email, String senha) {
        return usuarioRepository.realizarLogin(email, senha);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinaRepository.adicionarDisciplina(disciplina);
    }

    public List<Disciplina> recuperarDisciplinas() {
        return disciplinaRepository.recuperarDisciplinas();
    }

    public Disciplina atualizarNomeDisciplina(int id, String novoNome) {
        return disciplinaRepository.atualizarNomeDisciplina(id, novoNome);
    }

    public void adicionarNota(int id, int novaNota) {
        disciplinaRepository.adicionarNota(id, (double) novaNota);
    }

    public Disciplina adicionarComentario(int id, Comentario comentario) {
        return disciplinaRepository.adicionarComentario(id, comentario);
    }

    public void removerComentario(int idComentario) {
        disciplinaRepository.removerComentario(idComentario);
    }

    public Disciplina removerDisciplina(int id) {
        return disciplinaRepository.removerDisciplina(id);
    }

    public Disciplina recuperarDisciplina(int id) {
        return disciplinaRepository.recuperarDisciplina(id);
    }

    public List<Disciplina> recuperarDisciplinasOrdenadasPorNotaMedia() {
        return disciplinaRepository.recuperarDisciplinasOrdenadasPorNotaMedia();
    }
}