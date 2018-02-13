
package br.com.ifpb.pw2.controllers;

import br.com.ifpb.pw2.interfaces.PostDAO;
import br.com.ifpb.pw2.interfaces.UsuarioService;
import br.com.ifpb.pw2.model.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rodrigo Bento
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    @Autowired
    private HttpSession session;
    @Autowired
    private PostDAO postDao;
    
    @PostMapping(value = "/adicionar")
    public ModelAndView addUsuario(Usuario usuario, @RequestParam("foto") MultipartFile file) 
            throws FileNotFoundException, IOException{
        ModelAndView mv = new ModelAndView("redirect:/");
        service.adicionar(usuario, file);
        return mv;
    }
    
    @PostMapping(value = "/autenticar")
    public ModelAndView attUsuario(Usuario usuario){
        ModelAndView mv;
        Usuario aux = service.autenticar(usuario);
        if(aux != null){
            List<String> todosPosts = postDao.todosPosts(aux);
            mv = new ModelAndView("redirect:/home.jsp");
            session.setAttribute("usuario", aux);
            session.setAttribute("posts", todosPosts);
        } else {
            mv = new ModelAndView("redirect:/");
        }        
        return mv;
    }
    
}
