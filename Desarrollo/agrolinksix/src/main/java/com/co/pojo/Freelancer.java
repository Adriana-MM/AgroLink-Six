package com.co.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="freelancer")
public class Freelancer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idfreelancer;
    private Integer idusuario;
    private String pnombre;
    private String snombre;
    private String papellido;
    private String sapellido;
    private String correo;
    private String enlacecvlac;
    private String imagen;
    private String descripcion;
    private Integer idregion;
    private Integer idcategoria;
    private Integer idestado;
    private Integer puntuacion;
    private Integer telefono;
}
