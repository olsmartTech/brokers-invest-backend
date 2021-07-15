package com.brokers.invest.service;

import com.brokers.invest.model.*;

import java.util.List;

public interface AfiliationService {

    ResponseAfilician createAfiliation(RequesAfilicion req);

    List<UsuarioAfiliate> listUserAfiliated(ParamIn in);

    List<ProductBean> listProductById(int codCompany);

    ResponseAfilician testProcedure(String param);

    List<Departamento> listDepart();

    List<Provincia> listProvincia(String codDep);

    List<Distrito> listDistrito(String codProv);

    List<TypeDocumen> listDocumIden(String cod);

    List<Perfil> listPerfiles();

    List<Usuario> lstAuthenticateUser(RequestAuthen req);

    List<PersNatu> lstDataCtaUser(long cuentaId);

    List<Permiso> listRolsAccount(long cuentaId);
}
