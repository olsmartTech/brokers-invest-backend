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
public class CompanyDAOImpl implements CompanyDAO{
    private static final Logger logger = LoggerFactory.getLogger(CompanyDAOImpl.class);

    @Autowired
    private DataSource dataSource;
    Connection con=null;


    @Override
    public RespGeneric createCompany(Company req) {
        logger.info("daoImpl: m:createCompany--------");
        logger.info("parametres: "+req);
        RespGeneric resp=new RespGeneric();
        try{
            con=dataSource.getConnection();
            CallableStatement cStmt = con.prepareCall(UtilsConsultas.CALL_CREATE_COMPANY);
            cStmt.setString(1,req.getOption());
            cStmt.setLong(2,req.getCodcompany());
            cStmt.setString(3,req.getNamecompany());
            cStmt.setString(4,req.getSmallname());
            cStmt.setString(5, req.getStatecompany());
            cStmt.setString(6, req.getUsrcrea());
            cStmt.setDate(7, new java.sql.Date(req.getTscrea().getTime()));
            cStmt.setString(8, req.getUsrmodi());
            cStmt.setDate(9, new java.sql.Date(req.getTsmodi().getTime()));
            cStmt.setLong(10, req.getCtaorgaid());
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
    public List<Company> listCompanyRow(ParamIn p) {
        List<Company> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_COMPANY);
            st.setString(1,"_ALLROW");
            st.setLong(2, p.getCompanyId());
            st.setLong(3, p.getCtaorga());
            st.setString(4,p.getSearchName());
            ResultSet rs=st.executeQuery();
            Company company=null;
            while (rs.next()){
                company=new Company();
                company.setCodcompany(rs.getLong(1));
                company.setNamecompany(rs.getString(2));
                company.setSmallname(rs.getString(3));
                company.setStatecompany(rs.getString(4));
                company.setUsrcrea(rs.getString(5));
                company.setTscrea(rs.getDate(6));
                list.add(company);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Company listCompanyById(ParamIn p) {
        Company company=null;
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_COMPANY);
            st.setString(1,"_BYID");
            st.setLong(2, p.getCompanyId());
            st.setLong(3, p.getCtaorga());
            st.setString(4,p.getSearchName());
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                company=new Company();
                company.setCodcompany(rs.getLong(1));
                company.setNamecompany(rs.getString(2));
                company.setSmallname(rs.getString(3));
                company.setStatecompany(rs.getString(4));
                company.setUsrcrea(rs.getString(5));
                company.setTscrea(rs.getDate(6));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return company;
    }

    @Override
    public List<Vigencia> listVigencia(long ctaorga) {
        List<Vigencia> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_VIGENCIA);
            st.setLong(1, ctaorga);
            ResultSet rs=st.executeQuery();
            Vigencia vigencia=null;
            while (rs.next()){
                vigencia=new Vigencia();
                vigencia.setCodvigencia(rs.getLong(1));
                vigencia.setDescvigencia(rs.getString(2));
                vigencia.setNumvigencia(rs.getInt(3));
                list.add(vigencia);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Money> listMoney() {
        List<Money> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_MONEY);
            //st.setLong(1, ctaorga);
            ResultSet rs=st.executeQuery();
            Money money=null;
            while (rs.next()){
                money=new Money();
                money.setCodmoney(rs.getLong(1));
                money.setDescmoney(rs.getString(2));
                money.setSimbolo(rs.getString(3));
                list.add(money);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<FechaPago> listFechasPago() {
        List<FechaPago> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_FOCHA_PAGO);
            //st.setLong(1, ctaorga);
            ResultSet rs=st.executeQuery();
            FechaPago fechaPago=null;
            while (rs.next()){
                fechaPago=new FechaPago();
                fechaPago.setCodfechapago(rs.getLong(1));
                fechaPago.setDescpago(rs.getString(2));
                list.add(fechaPago);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
