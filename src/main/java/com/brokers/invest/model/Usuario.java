package com.brokers.invest.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Usuario {
    private String nuDni;
    private String usrId;
    private String typeUsr;
    private String nombres;
    private String estado;
    private String apePat;
    private String apeMat;
    private String pass;
    private String flagCtaAct;
    private long perfilId;
    private long cuentaId;
}
