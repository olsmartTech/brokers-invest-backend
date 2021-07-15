package com.brokers.invest.service;

import com.brokers.invest.model.Agente;
import com.brokers.invest.model.AsignarAgente;
import com.brokers.invest.model.ParamIn;
import com.brokers.invest.model.RespGeneric;

import java.util.List;

public interface AgenteService  {

    RespGeneric createAgente(Agente a);

    List<Agente> listAgenteAllRow(ParamIn p);

    Agente listAgenteById(ParamIn p);

    RespGeneric createAsignacion(AsignarAgente a);

    List<AsignarAgente> listAsignacion(ParamIn p);

}
