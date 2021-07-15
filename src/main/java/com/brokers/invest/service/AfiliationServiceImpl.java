package com.brokers.invest.service;

import com.brokers.invest.dao.AfiliacionDAO;
import com.brokers.invest.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AfiliationServiceImpl implements AfiliationService {

    private static final Logger logger = LoggerFactory.getLogger(AfiliationServiceImpl.class);

    @Autowired
    AfiliacionDAO afiliacionDAO;

    @Override
    public ResponseAfilician createAfiliation(RequesAfilicion req) {
        logger.info("service: m:createAfiliation--------");
        return afiliacionDAO.createAfiliation(req);
    }

    @Override
    public List<UsuarioAfiliate> listUserAfiliated(ParamIn in) {
        return afiliacionDAO.listUserAfiliated(in);
    }

    @Override
    public List<ProductBean> listProductById(int codCompany) {
        return afiliacionDAO.listProductById(codCompany);
    }

    @Override
    public ResponseAfilician testProcedure(String param) {
        return afiliacionDAO.testProcedure(param);
    }

    @Override
    public List<Departamento> listDepart() {
        return afiliacionDAO.listDepart();
    }

    @Override
    public List<Provincia> listProvincia(String codDep) {
        return afiliacionDAO.listProvincia(codDep);
    }

    @Override
    public List<Distrito> listDistrito(String codProv) {
        return afiliacionDAO.listDistrito(codProv);
    }

    @Override
    public List<TypeDocumen> listDocumIden(String cod) {
        return afiliacionDAO.listDocumIden(cod);
    }

    @Override
    public List<Perfil> listPerfiles() {
        return afiliacionDAO.listPerfiles();
    }

    @Override
    public List<Usuario> lstAuthenticateUser(RequestAuthen req) {
        return afiliacionDAO.lstAuthenticateUser(req);
    }

    @Override
    public List<PersNatu> lstDataCtaUser(long cuentaId) {
        return afiliacionDAO.lstDataCtaUser(cuentaId);
    }

    @Override
    public List<Permiso> listRolsAccount(long cuentaId) {
        return afiliacionDAO.listRolsAccount(cuentaId);
    }

}
