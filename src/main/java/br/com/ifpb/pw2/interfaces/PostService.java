package br.com.ifpb.pw2.interfaces;

import br.com.ifpb.pw2.model.Post;
import br.com.ifpb.pw2.model.Usuario;
import java.util.List;

/**
 *
 * @author rodrigobento
 */
public interface PostService {
    
    boolean cadastrar(Post post);
    List<Post> todosPosts(Usuario usuario);
    Post buscaPorId(int id);
    
}
