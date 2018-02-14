package br.com.ifpb.pw2.infra;

import br.com.ifpb.pw2.interfaces.PostDAO;
import br.com.ifpb.pw2.interfaces.UsuarioService;
import br.com.ifpb.pw2.model.Post;
import br.com.ifpb.pw2.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodrigo Bento
 */
@Repository
public class PostDAOImpl implements PostDAO{

    @Autowired
    private Connection con;
    @Autowired
    private UsuarioService usuService;
    
    @Override
    public boolean cadastrar(Post post) {
        boolean cond = false;
        String sql = "INSERT INTO post (mensagem, usuario_id) VALUES (?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, post.getMensagem());
            stmt.setInt(2, post.getUsuario().getId());
            cond = stmt.executeUpdate() > 0;
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cond;
    }

    @Override
    public List<Post> todosPosts(Usuario usuario) {
        String sql = "SELECT * FROM post WHERE usuario_id = ?";
        List<Post> posts = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Post post = new Post();
                post.setMensagem(rs.getString("mensagem"));
                post.setUsuario(usuario);
                post.setId(rs.getInt("id"));
                posts.add(post);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post buscaPorId(int id) {
        Post post = null;
        String sql = "SELECT * FROM post WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Usuario aux = usuService.buscaPorId(rs.getInt("usuario_id"));
                post = new Post();
                post.setId(id);
                post.setMensagem(rs.getString("mensagem"));
                post.setUsuario(aux);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return post;
    }
    
}
