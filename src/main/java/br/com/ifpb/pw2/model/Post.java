package br.com.ifpb.pw2.model;

/**
 *
 * @author Rodrigo Bento
 */
public class Post {

    private int id;
    private String mensagem;
    private Usuario usuario;

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", mensagem=" + mensagem + ", usuario=" + usuario + '}';
    }
    
}
