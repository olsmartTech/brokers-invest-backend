package com.brokers.invest.service;

import com.brokers.invest.dao.CustomerDAO;
import com.brokers.invest.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerServices{

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public RespGeneric customerCrea(RequestCustomer req) {
        return customerDAO.customerCrea(req);
    }

    @Override
    public List<Customer> listCustomer(ParamIn p) {
        return customerDAO.listCustomer(p);
    }

    @Override
    public Customer viewCustomerById(ParamIn p) {
        return customerDAO.viewCustomerById(p);
    }

    @Override
    public List<FormaTratar> listFormaTratar() {
        return customerDAO.listFormaTratar();
    }

    @Override
    public List<Grupos> listGruposAll() {
        return customerDAO.listGruposAll();
    }
}
