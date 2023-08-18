import java.sql.Date;

class Comentario {
    static private long idAuxiliar;
    private long id;
    private String comentario;
    private String emailDoUsuario;
    private boolean removido = false;

    public Comentario(String comentario, String emailDoUsuario) {
        super();
        this.id = idAuxiliar++;
        this.comentario = comentario;
        this.emailDoUsuario = emailDoUsuario;

    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public long getId() {
        return id;
    }
    public String getEmailDoUsuario() {
        return emailDoUsuario;
    }

    public boolean isRemovido() {
        return removido;
    }

    public void setRemovido(boolean removido) {
        this.removido = removido;
    }
    

    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
        return false;
        if(getClass()!= obj.getClass())
            return false;
        Comentario other = (Comentario) obj;
        return id == other.id;
    }   















   

    



    
}