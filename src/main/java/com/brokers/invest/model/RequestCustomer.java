package com.brokers.invest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter
public class RequestCustomer {
    private String  option;
    private long  codcustomer;
    private String  coddistrito;
    private String  tipoDocId;
    private String  numdocum;
    private String  razonsocial;
    private String  name;
    private String  apePat;
    private String  apeMat;
    private String  direccion;
    private String  celular;
    private String  correo;
    private String  tipoper;
    private Date fechaNac;
    private String  usrcrea;
    private Date  tscrea;
    private String  usrmodi;
    private Date tsmodi;
    //private String  description;
    private Integer codTratar;
    private String  flagTratarcomo;
    private String  statecustomer;
    private Integer codAgente;
    private Integer codGrupo;
    private String numDocuAgente;
    private Integer codSubAgente;
    private String numDocuSubAgente;
}
