package com.brokers.invest.dao;

import com.brokers.invest.model.Agente;
import com.brokers.invest.model.AsignarAgente;
import com.brokers.invest.model.ParamIn;
import com.brokers.invest.model.RespGeneric;

import java.util.List;

public interface AgenteDAO {

    RespGeneric createAgente(Agente a);

    RespGeneric createAsignacion(AsignarAgente a);

    List<AsignarAgente> listAsignacion(ParamIn p);

    List<Agente> listAgenteAllRow(ParamIn p);

    Agente listAgenteById(ParamIn p);

}
