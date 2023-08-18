import java.util.ArrayList;
import java.util.List;

class UsuarioRepository {
    private List<Aluno> usuarios;

    public UsuarioRepository() {
        usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Aluno usuario) {
        usuarios.add(usuario);
    }

    public List<Aluno> recuperarUsuarios() {
        return usuarios;
    }

    public Aluno realizarLogin(String email, String senha) {
        for (Aluno usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}