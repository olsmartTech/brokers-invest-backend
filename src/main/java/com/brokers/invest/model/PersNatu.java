package com.brokers.invest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersNatu {
    private long perNatuId;
    private String nombre;
    private String apeMat;
    private String apePat;
    private Persona person;
}
