package com.brokers.invest.service;

import com.brokers.invest.dao.CompanyDAO;
import com.brokers.invest.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDAO companyDAO;

    @Override
    public RespGeneric createCompany(Company req) {
        return companyDAO.createCompany(req);
    }

    @Override
    public List<Company> listCompanyRow(ParamIn p) {
        return companyDAO.listCompanyRow(p);
    }

    @Override
    public Company listCompanyById(ParamIn p) {
        return companyDAO.listCompanyById(p);
    }

    @Override
    public List<Vigencia> listVigencia(long ctaorga) {
        return companyDAO.listVigencia(ctaorga);
    }

    @Override
    public List<Money> listMoney() {
        return companyDAO.listMoney();
    }

    @Override
    public List<FechaPago> listFechasPago() {
        return companyDAO.listFechasPago();
    }
}
