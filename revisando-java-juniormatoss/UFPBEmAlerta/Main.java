import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Exemplo de uso do sistema
        SistemaDeAvaliacaoDisciplinas sistema = new SistemaDeAvaliacaoDisciplinas();

        Aluno usuario1 = new Aluno("João", "joao@example.com", "senha123");
        Aluno usuario2 = new Aluno("Maria", "maria@example.com", "senha456");

        sistema.adicionarUsuario(usuario1);
        sistema.adicionarUsuario(usuario2);

        List<Aluno> usuarios = sistema.recuperarUsuarios();
        for (Aluno usuario : usuarios) {
            System.out.println(usuario);
        }

        Disciplina disciplina1 = new Disciplina("Sistemas de Informação");
        Disciplina disciplina2 = new Disciplina("Banco de Dados");

        sistema.adicionarDisciplina(disciplina1);
        sistema.adicionarDisciplina(disciplina2);

        List<Disciplina> disciplinas = sistema.recuperarDisciplinas();
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina);
        }
    }
}