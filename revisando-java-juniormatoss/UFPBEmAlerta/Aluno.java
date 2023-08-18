import java.util.Objects;

class Aluno {
    private String nome;
    private String email;
    private String senha;

    public Aluno(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Aluno(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email;
    }
    public boolean equals(Object obj){
        if(this == obj){
            return false;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Aluno other = (Aluno) obj;
        return Objects.equals(email, other.email);
    }

}
   