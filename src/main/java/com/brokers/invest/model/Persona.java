package com.brokers.invest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {
    //PERSONA_ID,TIPO_DOC_ID,NUM_DOC,TIPO_PERS,CORREO,NUM_CEL,JURIS_ID,REG_PUB_ID,USR_CREA,TS_CREA, USR_MODI,TS_MODI
    private long personaId;
    private String tipoDocId;
    private String numDoc;
    private String correo;
    private String numCel;
    private String flagCtaAct;
}