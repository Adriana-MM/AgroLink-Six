
package com.co.dao;

import com.co.pojo.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioDao extends CrudRepository<Usuario,Integer> {
    
}
