package br.com.ifpb.pw2.infra;

import br.com.ifpb.pw2.interfaces.PostDAO;
import br.com.ifpb.pw2.interfaces.PostService;
import br.com.ifpb.pw2.model.Post;
import br.com.ifpb.pw2.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodrigobento
 */
@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostDAO dao;

    @Override
    public boolean cadastrar(Post post) {
        return dao.cadastrar(post);
    }

    @Override
    public List<Post> todosPosts(Usuario usuario) {
        return dao.todosPosts(usuario);
    }

    @Override
    public Post buscaPorId(int id) {
        return dao.buscaPorId(id);
    }
    
}
