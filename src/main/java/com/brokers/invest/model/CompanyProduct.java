package com.brokers.invest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CompanyProduct {
    private String option;
    private long codproduct;
    private long codcompany;
    private long codsubproduct;
    private long cuentaid;
    private String nameProduct;
    private String nameSubProduct;
    private String  usrcrea;
    private Date tscrea;
    private String  usrmodi;
    private Date tsmodi;
    private long ctaorga;
}
