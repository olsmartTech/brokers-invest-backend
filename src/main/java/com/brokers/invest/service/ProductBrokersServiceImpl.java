package com.brokers.invest.service;

import com.brokers.invest.dao.ProductBrokersDAO;
import com.brokers.invest.model.*;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBrokersServiceImpl implements ProductBrokersService  {

    @Autowired
    ProductBrokersDAO productBrokersDAO;

    @Override
    public List<Product> listProduct(long ctaorga) {
        return productBrokersDAO.listProduct(ctaorga);
    }

    @Override
    public List<SubProduct> listSubProduct(long cod) {
        return productBrokersDAO.listSubProduct(cod);
    }

    @Override
    public RespGeneric createAddPrduct(CompanyProduct a) {
        return productBrokersDAO.createAddPrduct(a);
    }

    @Override
    public List<CompanyProduct> listAddProduct(ParamIn p) {
        return productBrokersDAO.listAddProduct(p);
    }

}
