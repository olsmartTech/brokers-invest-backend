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
public class ProductBrokersDAOImpl  implements ProductBrokersDAO{

    private static final Logger logger = LoggerFactory.getLogger(ProductBrokersDAOImpl.class);

    @Autowired
    private DataSource dataSource;
    Connection con=null;

    @Override
    public List<Product> listProduct(long ctaorga) {
        List<Product> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_PRODUCT_BROKERS);
            st.setLong(1, ctaorga);
            //st.setLong(2, p.getAgenteId());
            //st.setString(3, "");
            ResultSet rs=st.executeQuery();
            Product product;
            while (rs.next()){
                product=new Product();
                product.setCodproduct(rs.getLong(1));
                product.setNameproduct(rs.getString(2));
                list.add(product);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SubProduct> listSubProduct(long cod) {
        List<SubProduct> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_SUB_PRODUCT_BROKERS);
            st.setLong(1, cod);
            ResultSet rs=st.executeQuery();
            SubProduct subProd;
            while (rs.next()){
                subProd=new SubProduct();
                subProd.setCodsubproduct(rs.getLong(1));
                subProd.setNamesubproduct(rs.getString(2));
                list.add(subProd);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public RespGeneric createAddPrduct(CompanyProduct req) {
        logger.info("daoImpl: m:customerCrea--------");
        logger.info("parametres: "+req);
        RespGeneric resp=new RespGeneric();
        try{
            con=dataSource.getConnection();
            CallableStatement cStmt = con.prepareCall(UtilsConsultas.CALL_CREATE_COMPANY_PRODUCT);
            cStmt.setString(1,req.getOption());
            cStmt.setLong(2,req.getCodcompany());
            cStmt.setLong(3,req.getCodproduct());
            cStmt.setLong(4,req.getCodsubproduct());
            cStmt.setString(5,req.getNameSubProduct());
            cStmt.setLong(6,req.getCuentaid());
            cStmt.setString(7,req.getUsrcrea());
            cStmt.setDate(8, new java.sql.Date(req.getTscrea().getTime()));
            cStmt.setString(9,req.getUsrmodi());
            cStmt.setDate(10, new java.sql.Date(req.getTscrea().getTime()));
            cStmt.setLong(11, req.getCtaorga());
            cStmt.registerOutParameter(12, Types.VARCHAR);
            cStmt.execute();
            logger.info("respuesta de la operacion >><  "+cStmt.getString(12));
            String codRpt=cStmt.getString(12);
            if(codRpt.equals("000")){
                resp.setCodResp("000");
                resp.setMsgRpt("LOS DATOS SE REGISTRARON CORRECTAMENTE");
                //resp.setVertify("0");
                logger.info("resultado existo--> "+cStmt.getString(6));
            }
            if(!codRpt.equals("000")){
                resp.setCodResp("999");
                resp.setMsgRpt("LOS DATOS SE REGISTRARON CORRECTAMENTE");
                logger.info("hubo error--> "+cStmt.getString(4));
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
    public List<CompanyProduct> listAddProduct(ParamIn p) {
        List<CompanyProduct> list=new ArrayList<>();
        try {
            logger.info("PARAM IN 1--->nothing ");
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_PRODUCT_COMPANY);
            st.setString(1, p.getOption());
            st.setLong(2, p.getCodcompany());
            st.setLong(3, p.getCodproduct());
            st.setLong(4, p.getCodsubproduct());
            ResultSet rs=st.executeQuery();
            CompanyProduct subProd;
            while (rs.next()){
                subProd=new CompanyProduct();
                subProd.setCodsubproduct(rs.getLong(1));
                subProd.setCodcompany(rs.getLong(2));
                subProd.setNameProduct(rs.getString(3));
                subProd.setNameSubProduct(rs.getString(4));
                list.add(subProd);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
