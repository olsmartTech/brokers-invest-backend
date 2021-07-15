package com.brokers.invest.dao;

import com.brokers.invest.model.*;

import java.util.List;

public interface CompanyDAO {

    RespGeneric createCompany(Company a);

    List<Company> listCompanyRow(ParamIn p);

    Company listCompanyById(ParamIn p);


    List<Vigencia> listVigencia(long ctaorga);

    List<Money> listMoney();

    List<FechaPago> listFechasPago();

}
