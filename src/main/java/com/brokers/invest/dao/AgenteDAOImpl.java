package com.brokers.invest.dao;

import com.brokers.invest.constantes.UtilsConsultas;
import com.brokers.invest.model.Agente;
import com.brokers.invest.model.AsignarAgente;
import com.brokers.invest.model.ParamIn;
import com.brokers.invest.model.RespGeneric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AgenteDAOImpl implements AgenteDAO{

    private static final Logger logger = LoggerFactory.getLogger(AgenteDAOImpl.class);

    @Autowired
    private DataSource dataSource;
    Connection con=null;

    @Override
    public RespGeneric createAgente(Agente req) {
        logger.info("daoImpl: m:customerCrea--------");
        logger.info("parametres: "+req);
        RespGeneric resp=new RespGeneric();
        try{
            con=dataSource.getConnection();
            CallableStatement cStmt = con.prepareCall(UtilsConsultas.CALL_CREATE_AGENTE);
            cStmt.setString(1,req.getOption());
            cStmt.setLong(2,req.getCodagente());
            cStmt.setString(3,req.getTipoDocId());
            cStmt.setString(4,req.getNumdocum());
            cStmt.setString(5, req.getRazonsocial());
            cStmt.setString(6, req.getNombres());
            cStmt.setString(7, req.getApepat());
            cStmt.setString(8, req.getApemat());
            cStmt.setString(9, req.getUsrcrea());
            cStmt.setDate(10, new java.sql.Date(req.getTscrea().getTime()));
            cStmt.setString(11, req.getUsrmodi());
            cStmt.setDate(12, new java.sql.Date(req.getTsmodi().getTime()));
            cStmt.setString(13, req.getStateagente());
            cStmt.registerOutParameter(14, Types.VARCHAR);
            cStmt.execute();
            logger.info("respuesta de la operacion >><  "+cStmt.getString(14));
            String codRpt=cStmt.getString(14);
            if(codRpt.equals("000")){
                resp.setCodResp("000");
                resp.setMsgRpt("LOS DATOS SE REGISTRARON CORRECTAMENTE");
                //resp.setVertify("0");
                logger.info("resultado existo--> "+cStmt.getString(14));
            }
            if(!codRpt.equals("000")){
                resp.setCodResp("999");
                resp.setMsgRpt("LOS DATOS SE REGISTRARON CORRECTAMENTE");
                logger.info("hubo error--> "+cStmt.getString(14));
            }
        }catch(Exception e){
            logger.info("ZONA DE EXCEPTION error --> ");
            resp.setCodResp("-1");
            resp.setMsgRpt("HUBO UN ERROR EN LA BD AL MOMENTO DE REGISTRAR LOS DATOS");
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public RespGeneric createAsignacion(AsignarAgente req) {
        logger.info("daoImpl: m:createAsignacion--------");
        logger.info("parametres: "+req);
        RespGeneric resp=new RespGeneric();
        try{
            con=dataSource.getConnection();
            CallableStatement cStmt = con.prepareCall(UtilsConsultas.CALL_CREATE_ASIGNAR_AGENTE);
            cStmt.setString(1,req.getOption());
            cStmt.setLong(2,req.getCodagente());
            cStmt.setLong(3,req.getCodcustomer());
            cStmt.setString(4,req.getTipo());
            cStmt.setString(5,req.getNumdocum());
            cStmt.setString(6, req.getStateasig());
            cStmt.setString(7, req.getUsrcrea());
            cStmt.setDate(8, new java.sql.Date(req.getTscrea().getTime()));
            cStmt.setString(9, req.getUsrmodi());
            cStmt.setDate(10, new java.sql.Date(req.getTsmodi().getTime()));
            cStmt.registerOutParameter(11, Types.VARCHAR);
            cStmt.execute();
            logger.info("respuesta de la operacion >><  "+cStmt.getString(11));
            String codRpt=cStmt.getString(11);
            if(codRpt.equals("000")){
                resp.setCodResp("000");
                resp.setMsgRpt("LOS DATOS SE REGISTRARON CORRECTAMENTE");
                //resp.setVertify("0");
                logger.info("resultado existo--> "+cStmt.getString(11));
            }
            if(!codRpt.equals("000")){
                resp.setCodResp("999");
                resp.setMsgRpt("LOS DATOS SE REGISTRARON CORRECTAMENTE");
                logger.info("hubo error--> "+cStmt.getString(11));
            }
        }catch(Exception e){
            logger.info("ZONA DE EXCEPTION error --> ");
            resp.setCodResp("-1");
            resp.setMsgRpt("HUBO UN ERROR EN LA BD AL MOMENTO DE REGISTRAR LOS DATOS");
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<AsignarAgente> listAsignacion(ParamIn p) {
        List<AsignarAgente> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_LIST_ASIGNACION_ALL);
            st.setLong(1, p.getCustomerId());
            //st.setLong(2, p.getAgenteId());
            //st.setString(3, "");
            ResultSet rs=st.executeQuery();
            AsignarAgente asig;
            while (rs.next()){
                asig=new AsignarAgente();
                asig.setCodagente(rs.getLong(1));
                asig.setCodcustomer(rs.getLong(2));
                asig.setRazonsocial(rs.getString(3));
                asig.setTipo(rs.getString(4));
                asig.setNumdocum(rs.getString(5));
                asig.setStateasig(rs.getString(6));
                list.add(asig);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Agente> listAgenteAllRow(ParamIn p) {
        List<Agente> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_AGENTE_ALL);
            st.setString(1, p.getOption());
            st.setLong(2, p.getAgenteId());
            st.setString(3, "");
            ResultSet rs=st.executeQuery();
            Agente agente;
            while (rs.next()){
                agente=new Agente();
                agente.setCodagente(rs.getInt(1));
                agente.setTipoDocId(rs.getString(2));
                agente.setAbrev(rs.getString(3));
                agente.setNumdocum(rs.getString(4));
                agente.setRazonsocial(rs.getString(5));
                agente.setNombres(rs.getString(6));
                agente.setApepat(rs.getString(7));
                agente.setApemat(rs.getString(8));
                agente.setUsrcrea(rs.getString(9));
                agente.setTscrea(rs.getDate(10));
                agente.setUsrmodi(rs.getString(11));
                agente.setTsmodi(rs.getDate(12));
                agente.setStateagente(rs.getString(13));
                list.add(agente);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Agente listAgenteById(ParamIn p) {
        Agente agente=null;
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_AGENTE_ALL);
            st.setString(1, p.getOption());
            st.setLong(2, p.getAgenteId());
            st.setString(3, p.getSearchDocum());
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                agente=new Agente();
                agente.setCodagente(rs.getInt(1));
                agente.setTipoDocId(rs.getString(2));
                agente.setAbrev(rs.getString(3));
                agente.setNumdocum(rs.getString(4));
                agente.setRazonsocial(rs.getString(5));
                agente.setNombres(rs.getString(6));
                agente.setApepat(rs.getString(7));
                agente.setApemat(rs.getString(8));
                agente.setUsrcrea(rs.getString(9));
                agente.setTscrea(rs.getDate(10));
                agente.setUsrmodi(rs.getString(11));
                agente.setTsmodi(rs.getDate(12));
                agente.setStateagente(rs.getString(13));
            }
            if(agente==null){
                agente=new Agente();
                agente.setCodagente(-1);
                agente.setTipoDocId("");
                agente.setAbrev("");
                agente.setNumdocum("");
                agente.setRazonsocial("");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return agente;
    }
}
