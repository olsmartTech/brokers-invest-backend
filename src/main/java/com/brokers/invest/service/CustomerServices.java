package com.brokers.invest.service;

import com.brokers.invest.model.*;

import java.util.List;

public interface CustomerServices {

    RespGeneric customerCrea(RequestCustomer c);

    List<Customer> listCustomer(ParamIn p);

    Customer viewCustomerById(ParamIn p);

    List<FormaTratar> listFormaTratar();

    //List<Agente> listAgenteAll();

    List<Grupos> listGruposAll();

}
