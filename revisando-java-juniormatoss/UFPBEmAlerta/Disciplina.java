import java.util.ArrayList;
import java.util.List;

class Disciplina {
    private int idauxiliar;
    private int id;
    private String nome;
    private List<Double> notas = new ArrayList<>();
    private List<Comentario> comentarios = new ArrayList<>();
    private int numeroDelikes;;

    public Disciplina(String nome) {
        super();
        id = idauxiliar++;
        this.nome = nome;

    }

    public Disciplina() {

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeLikes() {
        return numeroDelikes;
    }

    public void setLikes(int numeroDelikes) {
        this.numeroDelikes = numeroDelikes;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }
    private double notaMedia(){
        double notaMedia = 0;
        for(Double nota : notas){
            notaMedia += nota;
        }
        return notas.size() > 0 ? notaMedia / notas.size() : notas.size();
    }

    public double adicionarNota(Double nota) {
        notas.add(nota);
        return notaMedia();
    }
    

    public int adicionarLike() {
        return numeroDelikes++;
    }

    public void removerComentario(long idComentario, String email) {
        for (Comentario comentario : comentarios) {
            if (comentario.getId() == idComentario) {
                if(comentario.getEmailDoUsuario().equals(email)){
                    comentario.setRemovido(true);
                    return;
                }
            }
        }
    }

    public double calcularMediaNotas() {
        double notaMedia = 0;
        for (Double nota : notas) {
            notaMedia += nota;
        }
        return notas.size() > 0 ? notaMedia / notas.size() : notas.size();
    }
    public List<Comentario> getComentarios (){
        List<Comentario> comentariosValidos = new ArrayList<>();
        for(Comentario comentario: comentarios){
            if(!comentario.isRemovido()){
                comentariosValidos.add(comentario);
            }
        }
        return comentariosValidos;
    }
    public int incrementaLikes(){
        return numeroDelikes;
    }
    public Comentario adicionarComentario(String comentario, String email){
        Comentario umComentario = new Comentario(comentario, email);
        comentarios.add(umComentario);
        return umComentario;
    }
    
}
