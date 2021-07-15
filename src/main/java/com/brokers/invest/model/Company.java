package com.brokers.invest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Company {
    private String option;
    private long codcompany;
    private String namecompany;
    private String smallname;
    private String statecompany;
    private String usrcrea;
    private Date tscrea;
    private String usrmodi;
    private Date tsmodi;
    private long ctaorgaid;
}
