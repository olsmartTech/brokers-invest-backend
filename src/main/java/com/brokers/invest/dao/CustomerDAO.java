package com.brokers.invest.dao;

import com.brokers.invest.model.*;

import java.util.List;

public interface CustomerDAO {

    RespGeneric customerCrea(RequestCustomer c);

    List<Customer> listCustomer(ParamIn p);

    Customer viewCustomerById(ParamIn p);

    List<FormaTratar> listFormaTratar();

    //List<Agente> listAgenteAll();

    List<Grupos> listGruposAll();

}
