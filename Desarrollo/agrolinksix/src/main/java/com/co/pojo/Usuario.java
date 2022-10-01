
package com.co.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    
    @Id
    private Integer idusuario;
    private Integer idrol;
    private String password;
    
    
}
