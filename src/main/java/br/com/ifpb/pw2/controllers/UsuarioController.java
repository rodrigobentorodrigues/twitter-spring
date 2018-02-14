package br.com.ifpb.pw2.controllers;

import br.com.ifpb.pw2.interfaces.PostService;
import br.com.ifpb.pw2.interfaces.UsuarioService;
import br.com.ifpb.pw2.model.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    private PostService postDao;

    @PostMapping(value = "/adicionar")
    public ModelAndView addUsuario(Usuario usuario, @RequestParam("foto") MultipartFile file)
            throws FileNotFoundException, IOException {
        ModelAndView mv = new ModelAndView("redirect:/");
        service.adicionar(usuario, file);
        return mv;
    }

    @PostMapping(value = "/autenticar")
    public ModelAndView attUsuario(Usuario usuario) {
        ModelAndView mv;
        Usuario aux = service.autenticar(usuario);
        if (aux != null) {
            mv = new ModelAndView("redirect:/home.jsp");
            session.setAttribute("usuario", aux);
            session.setAttribute("posts", postDao.todosPosts(aux));
        } else {
            mv = new ModelAndView("redirect:/");
        }
        return mv;
    }

    @GetMapping("/inicial")
    public String retornarHome() {
        return "redirect:/home.jsp";
    }
    
    @GetMapping("/logout")
    public ModelAndView encerrarSessao(){
        ModelAndView mv = new ModelAndView("redirect:/index.jsp");
        session.invalidate();
        return mv;
    }

}
