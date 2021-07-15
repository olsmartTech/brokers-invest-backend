package com.brokers.invest.dao;

import com.brokers.invest.model.*;

import java.util.List;

public interface ProductBrokersDAO {

    List<Product> listProduct(long ctaorga);

    List<SubProduct> listSubProduct(long cod);

    RespGeneric createAddPrduct(CompanyProduct a);

    List<CompanyProduct> listAddProduct(ParamIn p);

}
