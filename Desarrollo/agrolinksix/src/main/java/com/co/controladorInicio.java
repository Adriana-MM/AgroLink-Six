
package com.co;

import com.co.dao.CategoriaDao;
import com.co.dao.FreelancerDao;
import com.co.dao.UsuarioDao;
import com.co.pojo.Freelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        var freelancers = freelancerDao.findAll();
        model.addAttribute("freelancers",freelancers);
        return "perfil";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/actualizar")
    public String actualizar(){
        return "actualizar";
    }
    
    @PostMapping("/guardarme")
    public String guardarme(Freelancer freelancers){
        freelancerDao.save(freelancers);
        return "redirect:/miperfil";
    }
        @GetMapping("/actualizarme/{idfreelancer}")
    public String actaualizarme(@PathVariable("idfreelancer") Integer idfreelancer, Model model){
          var freelancers = freelancerDao.findById(idfreelancer);
        model.addAttribute("freelancers",freelancers);
                var categorias = categoriaDao.findAll();
              model.addAttribute("categorias",categorias);
        return "actualizarme";
    }
    

    
    @GetMapping("/freelancer")
    public String freelancer(Model model){
                var freelancers = freelancerDao.findAll();
        
        model.addAttribute("freelancers",freelancers);
        return "freelancers";
    }
    
    @GetMapping("/miperfil")
    public String miperfil(Model model){
           var freelancers = freelancerDao.findAll();
        
        model.addAttribute("freelancers",freelancers);
        return "miperfil";
    }
    
    @GetMapping("/registrarse")
    public String registrarse(Model model){
        var categorias = categoriaDao.findAll();
              model.addAttribute("categorias",categorias);
        return "registrarse";
    }
    
    @GetMapping("/administrador")
    public String administrador(Model model){
         var freelancers = freelancerDao.findAll();
          model.addAttribute("freelancers",freelancers);
        return "administrador";
    }
    
    @PostMapping("/guardar")
    public String guardar(Freelancer freelancers){
        freelancerDao.save(freelancers);
        return "redirect:/perfil";
    }
    
       @GetMapping("/actualizar/{idfreelancer}")
    public String editar(@PathVariable("idfreelancer") Integer idfreelancer, Model model){
        var freelancers = freelancerDao.findById(idfreelancer);
        model.addAttribute("freelancers",freelancers);
                var categorias = categoriaDao.findAll();
              model.addAttribute("categorias",categorias);
        return "actualizar";
    }
    
}
