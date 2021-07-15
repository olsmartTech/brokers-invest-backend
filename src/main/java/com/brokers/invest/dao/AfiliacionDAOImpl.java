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
import java.util.Date;
import java.util.List;

@Repository
public class AfiliacionDAOImpl implements AfiliacionDAO {

    private static final Logger logger = LoggerFactory.getLogger(AfiliacionDAOImpl.class);

    @Autowired
    private DataSource dataSource;
    Connection con=null;

    @Override
    public ResponseAfilician createAfiliation(RequesAfilicion req) {
        logger.info("daoImpl: m:createAfiliation--------");
        logger.info("parametres: "+req);
        ResponseAfilician resp=new ResponseAfilician();
        try{
            con=dataSource.getConnection();
            CallableStatement cStmt = con.prepareCall(UtilsConsultas.CALL_AFILIATION_ACOUNT);
            cStmt.setString(1,req.getPaisId());
            cStmt.setString(2,req.getDptoId());
            cStmt.setString(3,req.getProvId());
            cStmt.setString(4,req.getDistId());
            cStmt.setString(5, req.getTipoDocId());
            cStmt.setString(6, req.getNumDoc());
            cStmt.setString(7, req.getCorreo());
            cStmt.setString(8, req.getNumcel());
            cStmt.setString(9, req.getUsrCrea());
            cStmt.setString(10, req.getUsrModi());
            cStmt.setString(11, req.getNombre());
            cStmt.setString(12, req.getApePat());
            cStmt.setString(13, req.getApeMat());
            cStmt.setString(14, req.getGenero());
            cStmt.setString(15, req.getAddres());
            cStmt.setString(16, req.getOrigApp());
            cStmt.setString(17, req.getTipAfi());
            cStmt.setString(18, req.getTipoPers());
            cStmt.setString(19, req.getTipoUsr());
            cStmt.setString(20, req.getIpAdd());
            cStmt.setString(21, req.getCtasSprl());
            cStmt.setString(22, req.getFlagLectBio());
            cStmt.setString(23, req.getCodLectBio());
            cStmt.setString(24, req.getZonaCrea());
            cStmt.setString(25, req.getOficCrea());
            cStmt.setLong(26, req.getPerfilId());
            cStmt.registerOutParameter(27, Types.VARCHAR);
            cStmt.execute();
            logger.info("respuesta de la operacion >><  "+cStmt.getString(27));
            String codRpt=cStmt.getString(27);
            if(codRpt.equals("000")){
                resp.setPassword(req.getNumDoc());
                resp.setCtaUser(req.getNumDoc());
                resp.setFechaAfiliacion(new Date()+"");
                resp.setCodSeguimiento("000");
                resp.setMsgSeguimiento("LOS DATOS SE REGISTRARON CORRECTAMENTE");
                //resp.setVertify("0");
                logger.info("resultado existo--> "+cStmt.getString(27));
            }
            if(!codRpt.equals("000")){
                resp.setPassword(req.getNumDoc());
                resp.setCtaUser(req.getNumDoc());
                resp.setFechaAfiliacion(new Date()+"");
                resp.setCodSeguimiento(codRpt);
                resp.setCodResp(codRpt);
                resp.setMsgSeguimiento("AL PARECER EL USUARIO U OTRO DATO ESTA DUPLICADO");
                logger.info("hubo error--> "+cStmt.getString(27));
            }
        }catch(Exception e){
            logger.info("ZONA DE EXCEPTION error --> ");
            resp.setPassword("");
            resp.setCtaUser("");
            resp.setFechaAfiliacion(new Date()+"");
            resp.setCodSeguimiento("-1");
            resp.setMsgSeguimiento("HUBO UN ERROR EN LA BD AL MOMENTO DE REGISTRAR LOS DATOS");
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<ProductBean> listProductById(int codCompany) {
        List<ProductBean> list=new ArrayList();
        try {
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_AFILIATION_TEST);
            st.setInt(1,codCompany);
            ResultSet rs=st.executeQuery();
            ProductBean bean;
            while (rs.next()){
                bean=new ProductBean();
                bean.setCodProducto(rs.getInt(1));
                bean.setDescription(rs.getString(2));
                list.add(bean);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<UsuarioAfiliate> listUserAfiliated(ParamIn in) {
        List<UsuarioAfiliate> listUser=new ArrayList<>();
        try {
            logger.info("PARAM IN 1---> "+in.getSearchDocum());
            logger.info("PARAM IN 2---> "+in.getSearchName());
            logger.info("PARAM IN 3---> "+in.getTypeUser());
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_USER_AFILIATED);
            st.setString(1, in.getTypeUser());
            st.setString(2, in.getSearchDocum());
            st.setString(3, in.getSearchName());
            ResultSet rs=st.executeQuery();
            UsuarioAfiliate user;
            while (rs.next()){
                user=new UsuarioAfiliate();
                user.setCuentaId((int)rs.getLong(1));
                user.setUsuario(rs.getString(2));
                user.setFullNombre(rs.getString(3));
                user.setCorreo(rs.getString(4));
                user.setGenero(rs.getString(5));
                user.setNumCel(rs.getString(6));
                user.setEstado(rs.getString(7));
                user.setEstadoDesc(rs.getString(8));
                user.setUsrCrea(rs.getString(9));
                user.setTsCrea(rs.getDate(10));
                listUser.add(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return listUser;
    }

    @Override
    public ResponseAfilician testProcedure(String param) {
        ResponseAfilician bean=new ResponseAfilician();
        try {
            logger.info("PARAM IN ---> "+param);
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_AFILIATION_TEST);
            st.setString(1, param);
            st.registerOutParameter(2, Types.VARCHAR);
            st.execute();
            String codResp=st.getString(2);
            logger.info("respuesta del sp:--> "+st.getString(2));
            bean.setCodSeguimiento("0");
            bean.setMsgSeguimiento(codResp);
        }catch (Exception ex){
            ex.printStackTrace();
            bean.setCodSeguimiento("0");
            bean.setMsgSeguimiento("HUBO UN ERROR AL CONECTAR A LA BD");
        }
        return bean;
    }

    @Override
    public List<Departamento> listDepart() {
        //RespDepart bean=new RespDepart();
        List<Departamento> list=new ArrayList();
        try {
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_DEPART);
            //st.setInt(1,codCompany);
            ResultSet rs=st.executeQuery();
            Departamento dep;
            while (rs.next()){
                dep=new Departamento();
                dep.setDepartId(rs.getString(1));
                dep.setNameDepart(rs.getString(2));
                list.add(dep);
            }
            //bean.setListDepart(list);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }


    @Override
    public List<Provincia> listProvincia(String codDep) {
        //RespProv bean=new RespProv();
        List<Provincia> list=new ArrayList();
        try {
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_PROVINCIA);
            st.setString(1,codDep);
            ResultSet rs=st.executeQuery();
            Provincia prov;
            while (rs.next()){
                prov=new Provincia();
                prov.setProvId(rs.getString(1));
                prov.setNameProv(rs.getString(2));
                list.add(prov);
            }
            //bean.setListProv(list);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Distrito> listDistrito(String codProv) {
        //RespDist bean=new RespDist();
        List<Distrito> list=new ArrayList();
        try {
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_DISTRITO);
            st.setString(1,codProv);
            ResultSet rs=st.executeQuery();
            Distrito dist;
            while (rs.next()){
                dist=new Distrito();
                dist.setDistId(rs.getString(1));
                dist.setNameDist(rs.getString(2));
                list.add(dist);
            }
            //bean.setListDist(list);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TypeDocumen> listDocumIden(String cod) {
        //RespDocIden bean=new RespDocIden();
        List<TypeDocumen> list=new ArrayList();
        try {
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_TIPO_DOCUMENT);
            //st.setString(1,cod);
            ResultSet rs=st.executeQuery();
            TypeDocumen doc;
            while (rs.next()){
                doc=new TypeDocumen();
                doc.setDocumentId(rs.getString(1));
                doc.setAbrev(rs.getString(2));
                list.add(doc);
            }
            //bean.setListTipoDoc(list);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Perfil> listPerfiles() {
        List<Perfil> list=new ArrayList();
        try {
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_LIST_PERFILES);
            //st.setString(1,cod);
            ResultSet rs=st.executeQuery();
            Perfil per;
            while (rs.next()){
                per=new Perfil();
                per.setPerfilId(rs.getLong(1));
                per.setNombre(rs.getString(2));
                list.add(per);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Usuario> lstAuthenticateUser(RequestAuthen req) {
        List<Usuario> list=new ArrayList();
        try {
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_SP_AUTHETICATESER);
            st.setString(1,req.getUserId());
            st.setString(2,req.getPassword());
            ResultSet rs=st.executeQuery();
            Usuario doc;
            while (rs.next()){
                doc=new Usuario();
                doc.setCuentaId(rs.getLong(1));
                doc.setUsrId(rs.getString(2));
                doc.setTypeUsr(rs.getString(3));
                doc.setEstado(rs.getString(4));
                doc.setFlagCtaAct(rs.getString(5));
                doc.setPerfilId(rs.getLong(6));
                list.add(doc);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<PersNatu> lstDataCtaUser(long cuentaId) {
        List<PersNatu> list=new ArrayList();
        try {
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_SP_DATA_CTA_USER);
            st.setLong(1,cuentaId);
            ResultSet rs=st.executeQuery();
            PersNatu pn;
            while (rs.next()){
                pn=new PersNatu();
                Persona p=new Persona();
                p.setCorreo(rs.getString(1));
                p.setNumDoc(rs.getString(2));
                p.setFlagCtaAct(rs.getString(6));
                pn.setPerson(p);
                pn.setNombre(rs.getString(3));
                pn.setApePat(rs.getString(4));
                pn.setApeMat(rs.getString(5));
                list.add(pn);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Permiso> listRolsAccount(long cuentaId) {
        List<Permiso> list=new ArrayList();
        try {
            con=dataSource.getConnection();
            CallableStatement st= con.prepareCall(UtilsConsultas.CALL_SP_ROLES_ACCOUNT);
            st.setLong(1,cuentaId);
            ResultSet rs=st.executeQuery();
            Permiso pn;
            while (rs.next()){
                pn=new Permiso();
                pn.setPermisoId(rs.getLong(1));
                pn.setDescription(rs.getString(2));
                list.add(pn);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
