package com.brokers.invest.dao;

import com.brokers.invest.model.*;

import java.util.List;

public interface AfiliacionDAO {

    ResponseAfilician createAfiliation(RequesAfilicion req);

    List<ProductBean> listProductById(int codCompany);

    List<UsuarioAfiliate> listUserAfiliated(ParamIn in);

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
