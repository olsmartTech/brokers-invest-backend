package com.brokers.invest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AsignarAgente {
    private String option;
    private long codagente;
    private long codcustomer;
    private String razonsocial;
    private String tipo;
    private String numdocum;
    private String stateasig;
    private String usrcrea;
    private Date tscrea;
    private String usrmodi;
    private Date tsmodi;
}
