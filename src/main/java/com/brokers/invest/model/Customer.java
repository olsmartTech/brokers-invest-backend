package com.brokers.invest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter
public class Customer {
    private String  option;
    private long  codcustomer;
    private String  coddistrito;
    private String  tipo_doc_id;
    private String  abrev;
    private String  numdocum;
    private String  razonsocial;
    private String  name;
    private String  apePat;
    private String  apeMat;
    private String  direccion;
    private String  celular;
    private String  correo;
    private String  tipoper;
    private Date  fecha_nac;
    private String  usrcrea;
    private Date  tscrea;
    private String  usrmodi;
    private Date tsmodi;
    private Integer  codtratar;
    private String  tratarDesc;
    private String  flagTratarcomo;
    private String  statecustomer;
    private int codagete;
    private String  descAgente;
    private int codgrupo;
    private String  descGrupo;
    private String  ubigeo;
}
