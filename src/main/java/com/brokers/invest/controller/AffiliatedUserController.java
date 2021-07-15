package com.brokers.invest.controller;

import com.brokers.invest.constantes.Constantes;
import com.brokers.invest.exception.DaoException;
import com.brokers.invest.model.*;
import com.brokers.invest.service.AfiliationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
@Api(value = "BisacRest", produces = "application/json")
//@RequestMapping("/tramite/externo")
public class AffiliatedUserController {
    private static final Logger logger = LoggerFactory.getLogger(AffiliatedUserController.class);

    @Autowired
    AfiliationService afiliationService;

    @RequestMapping(value = Constantes.CREATE_AFILIATION, method = RequestMethod.POST)
    @ApiOperation(value = "Crea cuentas de usuario", tags = "Controlador Rest")
    public ResponseAfilician crearAfiliation(@RequestBody RequesAfilicion req) throws DaoException {
        logger.info("----------m:crearAfiliation--------");
        logger.info("controler --> Empezando a registrar ");
        logger.info("para1: "+req.getPaisId());
        logger.info("para2: "+req.getDptoId());
        logger.info("para3: "+req.getProvId());
        logger.info("para4: "+req.getAddres());
        logger.info("para5: "+req.getApePat());
        ResponseAfilician response = afiliationService.createAfiliation(req);
        logger.info("controler --> end create ");
        return response;
    }

    @RequestMapping(value = Constantes.LIST_SEARCH_USER_AFFILIATED, method = RequestMethod.GET)
    public @ResponseBody
    List<UsuarioAfiliate> listAffiliatedUser(@RequestParam(name="typeuser") String typeuser,
                                             @RequestParam(name="numdocum") String numdocum,
                                             @RequestParam(name="fullname") String fullname) {
        logger.info("typeuser: "+typeuser);
        logger.info("numdocum: "+numdocum);
        logger.info("fullname: "+fullname);
        ParamIn p=new ParamIn();
        p.setSearchDocum(typeuser);
        p.setSearchName(numdocum);
        p.setTypeUser(fullname);
        List<UsuarioAfiliate> lst = afiliationService.listUserAfiliated(p);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.AUTENTICAR_CTA_USER, method = RequestMethod.POST)
    public @ResponseBody
    List<Usuario> autenticationCtaUser(@RequestBody RequestAuthen req) {
        logger.info("user1: "+req.getUserId());
        logger.info("pass: "+req.getPassword());
        List<Usuario> lst = afiliationService.lstAuthenticateUser(req);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.VIEW_DATA_CTA_USER, method = RequestMethod.GET)
    public @ResponseBody
    List<PersNatu> viewDataCtaUser(@RequestParam(name="cuentaid") long cuentaid) {
        logger.info("=================M:viewDataCtaUser===============");
        logger.info("cuentaId: "+cuentaid);
        List<PersNatu> lst = afiliationService.lstDataCtaUser(cuentaid);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_ROLS_ACCOUNT_USER, method = RequestMethod.GET)
    public @ResponseBody
    List<Permiso> listRolesAccountUser(@RequestParam(name="cuentaid") long cuentaid) {
        logger.info("=================M:listRolesAccountUser===============");
        logger.info("cuentaId: "+cuentaid);
        List<Permiso> lst = afiliationService.listRolsAccount(cuentaid);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_DEPARTAMENTO, method = RequestMethod.GET)
    public @ResponseBody
    List<Departamento> listDepart(@PathVariable String id) {
        List<Departamento> lst = afiliationService.listDepart();
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_PROVINCIA, method = RequestMethod.GET)
    public @ResponseBody
    List<Provincia> listProvincia(@PathVariable String cod) {
        List<Provincia> lst = afiliationService.listProvincia(cod);
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_DISTRITO, method = RequestMethod.GET)
    public @ResponseBody
    List<Distrito> listDistrito(@PathVariable String cod) {
        List<Distrito> lst = afiliationService.listDistrito(cod);
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_TIPO_DOCUMENT, method = RequestMethod.GET)
    public @ResponseBody
    List<TypeDocumen> listTipoDocument(@PathVariable String cod) {
        List<TypeDocumen> lst = afiliationService.listDocumIden(cod);
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_PERFILES, method = RequestMethod.GET)
    public @ResponseBody
    List<Perfil> listPerfiles(@PathVariable int cod) {
        List<Perfil> lst = afiliationService.listPerfiles();
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_PRODUCT, method = RequestMethod.GET)
    public @ResponseBody
    List<ProductBean> listProduct(@PathVariable int id) {
        List<ProductBean> lst = null;
        lst = afiliationService.listProductById(id);
        return lst;
    }

    @RequestMapping(value = Constantes.TEST_PROCEDURE, method = RequestMethod.GET)
    public @ResponseBody
    ResponseAfilician testProcedure(@PathVariable int param) {
        return afiliationService.testProcedure("TEST");
    }

}

