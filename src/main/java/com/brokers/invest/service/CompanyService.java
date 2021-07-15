package com.brokers.invest.service;

import com.brokers.invest.model.*;

import java.util.List;

public interface CompanyService {
    RespGeneric createCompany(Company a);

    List<Company> listCompanyRow(ParamIn p);

    Company listCompanyById(ParamIn p);

    List<Vigencia> listVigencia(long ctaorga);

    List<Money> listMoney();

    List<FechaPago> listFechasPago();
}
