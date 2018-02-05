package br.com.ifpb.pw2.model;

/**
 *
 * @author Rodrigo Bento
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String senha;
    private byte[] imagem;

    public Usuario() {
    }

    public Usuario(int id, String nome, String senha, byte[] imagem) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", senha=" + senha + ", imagem=" + imagem + '}';
    }
    
    
}
