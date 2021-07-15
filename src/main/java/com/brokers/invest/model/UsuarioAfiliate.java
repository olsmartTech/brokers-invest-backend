package com.brokers.invest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter
public class UsuarioAfiliate {
    private Integer cuentaId;
    private String usuario;
    private String fullNombre;
    private String correo;
    private String numCel;
    private String genero;
    private String estado;
    private String estadoDesc;
    private String usrCrea;
    private Date tsCrea;
    private String tipoUpdate;
}
