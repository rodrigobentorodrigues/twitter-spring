package br.com.ifpb.pw2.controllers;

import br.com.ifpb.pw2.interfaces.PostDAO;
import br.com.ifpb.pw2.interfaces.UsuarioDAO;
import br.com.ifpb.pw2.interfaces.UsuarioService;
import br.com.ifpb.pw2.model.Usuario;
import java.util.Arrays;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rodrigo Bento
 */
@RequestMapping("/")
@Controller
public class IndexController {
    
    @Autowired
    private UsuarioService service;
    @Autowired
    private PostDAO postDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(){
        return "/index.jsp";
    }
    
    @GetMapping("{nome}")
    public ModelAndView getUsuario(@PathVariable String nome) {
        String aux = nome.split("@")[1];
        Usuario buscaPorNome = service.buscaPorNome(aux);
        ModelAndView mv = new ModelAndView("/usuario.jsp");
        if (buscaPorNome != null) {
            mv.addObject("usuarioAux", buscaPorNome);
            mv.addObject("postsAux", postDao.todosPosts(buscaPorNome));
        }
        return mv;
    }
    
}
