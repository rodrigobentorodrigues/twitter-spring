package br.com.ifpb.pw2.controllers;

import br.com.ifpb.pw2.interfaces.PostService;
import br.com.ifpb.pw2.interfaces.UsuarioDAO;
import br.com.ifpb.pw2.model.Post;
import br.com.ifpb.pw2.model.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rodrigo Bento
 */
@Controller
@RequestMapping("/post")
public class PostController {
    
    @Autowired
    private PostService postDao;
    @Autowired
    private UsuarioDAO usuDao;
    @Autowired
    private HttpSession session;
    
    @PostMapping(value = "/cadastrar")
    public ModelAndView cadastrarPost(@RequestParam("mensagem") String mensagem, 
            @RequestParam("usuario") int id){
        Usuario usuario = usuDao.buscaPorId(id);
        Post post = new Post();
        post.setUsuario(usuario);
        post.setMensagem(mensagem);
        ModelAndView mv = new ModelAndView("redirect:/home.jsp");
        postDao.cadastrar(post);
        session.setAttribute("posts", postDao.todosPosts(usuario));
        return mv;
    }
    
    @GetMapping(value = "/{id}")
    public ModelAndView visualizarPost(@PathVariable Integer id){
        Post buscaPorId = postDao.buscaPorId(id);
        ModelAndView mv = new ModelAndView("/post.jsp");
        mv.addObject("post", buscaPorId);
        mv.addObject("usuarioAux", buscaPorId.getUsuario());
        return mv;
    }
    
}
