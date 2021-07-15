package com.brokers.invest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Agente {
   private String option;
   private long codagente;
   private String tipoDocId;
   private String abrev;
   private String numdocum;
   private String razonsocial;
   private String nombres;
   private String apepat;
   private String apemat;
   private String usrcrea;
   private Date tscrea;
   private String usrmodi;
   private Date tsmodi;
   private String stateagente;
}

