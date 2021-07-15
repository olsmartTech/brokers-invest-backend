package com.brokers.invest.dao;

import com.brokers.invest.constantes.UtilsConsultas;
import com.brokers.invest.model.*;
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
public class CustomerDAOImpl implements CustomerDAO{

    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

    @Autowired
    private DataSource dataSource;
    Connection con=null;

    @Override
    public RespGeneric customerCrea(RequestCustomer req) {
        logger.info("daoImpl: m:customerCrea--------");
        logger.info("parametres: "+req);
        RespGeneric resp=new RespGeneric();
        try{
            con=dataSource.getConnection();
            CallableStatement cStmt = con.prepareCall(UtilsConsultas.CALL_CREATE_CUSTOMER);
            cStmt.setString(1,req.getOption());
            cStmt.setLong(2,req.getCodcustomer());
            cStmt.setString(3,req.getCoddistrito());
            cStmt.setString(4,req.getTipoDocId());
            cStmt.setString(5,req.getNumdocum());
            cStmt.setString(6, req.getRazonsocial());
            cStmt.setString(7, req.getName());
            cStmt.setString(8, req.getApePat());
            cStmt.setString(9, req.getApeMat());
            cStmt.setString(10, req.getDireccion());
            cStmt.setString(11, req.getCelular());
            cStmt.setString(12, req.getCorreo());
            cStmt.setString(13, req.getTipoper());
            cStmt.setDate(14, new java.sql.Date(req.getFechaNac().getTime()));
            cStmt.setString(15, req.getUsrcrea());
            cStmt.setDate(16, new java.sql.Date(req.getTscrea().getTime()));
            cStmt.setString(17, req.getUsrmodi());
            cStmt.setDate(18, new java.sql.Date(req.getTsmodi().getTime()));
            cStmt.setInt(19, req.getCodTratar());
            cStmt.setString(20, req.getFlagTratarcomo());
            //cStmt.setString(21, req.getStatecustomer());
            cStmt.setInt(21, req.getCodAgente());
            cStmt.setInt(22, req.getCodGrupo());
            /*new*/
            cStmt.setString(23, req.getNumDocuAgente());
            cStmt.setInt(24, req.getCodSubAgente());
            cStmt.setString(25, req.getNumDocuSubAgente());
            cStmt.registerOutParameter(26, Types.VARCHAR);
            cStmt.execute();
            logger.info("respuesta de la operacion >><  "+cStmt.getString(26));
            String codRpt=cStmt.getString(26);
            if(codRpt.equals("000")){
                resp.setCodResp("000");
                resp.setMsgRpt("LOS DATOS SE REGISTRARON CORRECTAMENTE");
                //resp.setVertify("0");
                logger.info("resultado existo--> "+cStmt.getString(26));
            }
            if(!codRpt.equals("000")){
                resp.setCodResp("999");
                resp.setMsgRpt("LOS DATOS SE REGISTRARON CORRECTAMENTE");
                logger.info("hubo error--> "+cStmt.getString(26));
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
    public List<Customer> listCustomer(ParamIn p) {
        List<Customer> listUser=new ArrayList<>();
        try {
            logger.info("PARAM IN 1---> "+p.getOption());
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_CUSTOMER_ALL_ROW);
            st.setString(1, p.getOption());
            st.setLong(2, p.getCustomerId());
            ResultSet rs=st.executeQuery();
            Customer cus;
            while (rs.next()){
                cus=new Customer();
                cus.setCodcustomer(rs.getLong(1));
                cus.setCoddistrito(rs.getString(2));
                cus.setTipo_doc_id(rs.getString(3));
                cus.setAbrev(rs.getString(4));
                cus.setNumdocum(rs.getString(5));
                cus.setRazonsocial(rs.getString(6));
                cus.setName(rs.getString(7));
                cus.setApePat(rs.getString(8));
                cus.setApeMat(rs.getString(9));
                cus.setDireccion(rs.getString(10));
                cus.setCelular(rs.getString(11));
                cus.setCorreo(rs.getString(12));
                cus.setTipoper(rs.getString(13));
                cus.setFecha_nac(rs.getDate(14));
                cus.setUsrcrea(rs.getString(15));
                cus.setTscrea(rs.getDate(16));
                cus.setUsrmodi(rs.getString(17));
                cus.setTsmodi(rs.getDate(18));
                cus.setCodtratar(rs.getInt(19));
                cus.setTratarDesc(rs.getString(20));
                cus.setFlagTratarcomo(rs.getString(21));
                cus.setStatecustomer(rs.getString(22));
                cus.setCodagete(rs.getInt(23));
                cus.setDescAgente(rs.getString(24));
                cus.setCodgrupo(rs.getInt(25));
                cus.setDescGrupo(rs.getString(26));
                cus.setUbigeo(rs.getString(27));
                listUser.add(cus);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return listUser;
    }

    @Override
    public Customer viewCustomerById(ParamIn p) {
        Customer cus=null;
        try {
            logger.info("PARAM IN 1---> "+p.getOption());
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_CUSTOMER_BY_ID);
            st.setString(1, p.getOption());
            st.setLong(2, p.getCustomerId());
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                cus=new Customer();
                cus.setCodcustomer(rs.getLong(1));
                cus.setCoddistrito(rs.getString(2));
                cus.setTipo_doc_id(rs.getString(3));
                cus.setAbrev(rs.getString(4));
                cus.setNumdocum(rs.getString(5));
                cus.setRazonsocial(rs.getString(6));
                cus.setName(rs.getString(7));
                cus.setApePat(rs.getString(8));
                cus.setApeMat(rs.getString(9));
                cus.setDireccion(rs.getString(10));
                cus.setCelular(rs.getString(11));
                cus.setCorreo(rs.getString(12));
                cus.setTipoper(rs.getString(13));
                cus.setFecha_nac(rs.getDate(14));
                cus.setUsrcrea(rs.getString(15));
                cus.setTscrea(rs.getDate(16));
                cus.setUsrmodi(rs.getString(17));
                cus.setTsmodi(rs.getDate(18));
                cus.setCodtratar(rs.getInt(19));
                cus.setTratarDesc(rs.getString(20));
                cus.setFlagTratarcomo(rs.getString(21));
                cus.setStatecustomer(rs.getString(22));
                cus.setCodagete(rs.getInt(23));
                cus.setDescAgente(rs.getString(24));
                cus.setCodgrupo(rs.getInt(25));
                cus.setDescGrupo(rs.getString(26));
                cus.setUbigeo(rs.getString(27));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return cus;
    }

    @Override
    public List<FormaTratar> listFormaTratar() {
        List<FormaTratar> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_TRATAR_COMO_ALL_ROW);
            //st.setString(1, p.getOption());
            ResultSet rs=st.executeQuery();
            FormaTratar f;
            while (rs.next()){
                f=new FormaTratar();
                f.setCodtratar(rs.getInt(1));
                f.setDescription(rs.getString(2));
                list.add(f);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }


    @Override
    public List<Grupos> listGruposAll() {
        List<Grupos> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_GRUPOS_ALL);
            //st.setString(1, p.getOption());
            ResultSet rs=st.executeQuery();
            Grupos f;
            while (rs.next()){
                f=new Grupos();
                f.setCodGrupos(rs.getInt(1));
                f.setDescription(rs.getString(2));
                list.add(f);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
