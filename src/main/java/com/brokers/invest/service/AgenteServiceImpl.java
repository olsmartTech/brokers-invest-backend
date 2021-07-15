package com.brokers.invest.service;

import com.brokers.invest.dao.AgenteDAO;
import com.brokers.invest.model.Agente;
import com.brokers.invest.model.AsignarAgente;
import com.brokers.invest.model.ParamIn;
import com.brokers.invest.model.RespGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenteServiceImpl implements AgenteService {

    @Autowired
    AgenteDAO agenteDAO;

    @Override
    public RespGeneric createAgente(Agente a) {
        return agenteDAO.createAgente(a);
    }

    @Override
    public List<Agente> listAgenteAllRow(ParamIn p) {
        return agenteDAO.listAgenteAllRow(p);
    }

    @Override
    public Agente listAgenteById(ParamIn p) {
        return agenteDAO.listAgenteById(p);
    }

    @Override
    public RespGeneric createAsignacion(AsignarAgente a) {
        return agenteDAO.createAsignacion(a);
    }

    @Override
    public List<AsignarAgente> listAsignacion(ParamIn p) {
        return agenteDAO.listAsignacion(p);
    }
}
