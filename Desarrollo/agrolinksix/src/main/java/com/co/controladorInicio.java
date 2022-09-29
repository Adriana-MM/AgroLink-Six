
package com.co;

import com.co.dao.CategoriaDao;
import com.co.dao.FreelancerDao;
import com.co.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author adria
 */
@Controller
public class controladorInicio {
    

    @Autowired
    private CategoriaDao categoriaDao;
    
    @Autowired
    private FreelancerDao freelancerDao;
    
    @GetMapping("/")
    public String inicio(Model model){
        var categorias = categoriaDao.findAll();
        var freelancers = freelancerDao.findAll();
        model.addAttribute("categorias",categorias);
        model.addAttribute("freelancers",freelancers);
        return "index";
    }
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @GetMapping("/perfil")
    public String perfil(Model model){
        var usuarios = usuarioDao.findAll();
        model.addAttribute("usuarios",usuarios);
        return "perfil";
    }
    
    
    
}
