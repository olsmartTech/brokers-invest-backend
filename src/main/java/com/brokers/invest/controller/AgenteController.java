package com.brokers.invest.controller;


import com.brokers.invest.constantes.Constantes;
import com.brokers.invest.exception.DaoException;
import com.brokers.invest.model.*;
import com.brokers.invest.service.AgenteService;
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
public class AgenteController {

    private static final Logger logger = LoggerFactory.getLogger(AgenteController.class);

    @Autowired
    AgenteService agenteService;

    @RequestMapping(value = Constantes.CREATE_AGENTE, method = RequestMethod.POST)
    @ApiOperation(value = "Crea clientes", tags = "Controlador Rest")
    public RespGeneric createAgente(@RequestBody Agente req) throws DaoException {
        logger.info("----------m:createAgente--------");
        logger.info("controler --> Empezando a registrar ");
        logger.info("para1: "+req.getOption());
        logger.info("para1: "+req.getRazonsocial());
        logger.info("para3: "+req.getRazonsocial());
        logger.info("para5: "+req.getNombres());
        logger.info("para6: "+req.getApepat());
        logger.info("para8: "+req.getTscrea());
        logger.info("para9: "+req.getTsmodi());
        RespGeneric response = agenteService.createAgente(req);
        logger.info("controler --> end create ");
        return response;
    }

    @RequestMapping(value = Constantes.LIST_AGENTE_ALL, method = RequestMethod.GET)
    public @ResponseBody
    List<Agente> listAgenteAllRow(@RequestParam(name="typebus") String typebus,
                                    @RequestParam(name="numdocum") String numdocum,
                                    @RequestParam(name="fullname") String fullname) {
        logger.info("filter: "+typebus);
        logger.info("numdocum: "+numdocum);
        logger.info("fullname: "+fullname);
        ParamIn p=new ParamIn();
        p.setOption("_ROW");
        p.setSearchName(typebus);
        p.setSearchDocum(numdocum);
        p.setSearchName(fullname);
        p.setAgenteId(0);
        List<Agente> lst = agenteService.listAgenteAllRow(p);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_AGENTE_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    Agente viewDataAgente(@RequestParam(name="option") String option,
                          @RequestParam(name="numdocum") String numdocum,
                          @RequestParam(name="fullname") String fullname) {
        logger.info("backend option: "+option);
        logger.info("backend numdocum: "+numdocum);
        logger.info("backend fullname: "+fullname);
        ParamIn p=new ParamIn();
        p.setOption(option);
        p.setAgenteId(0);
        p.setSearchDocum(numdocum);
        Agente agente = agenteService.listAgenteById(p);
        if(agente!=null){
            logger.info("size:>>> "+agente);
        }
        return agente;
    }

    @RequestMapping(value = Constantes.CREATE_ASIGNA_AGENTE, method = RequestMethod.POST)
    @ApiOperation(value = "Crea clientes", tags = "Controlador Rest")
    public RespGeneric createAsignation(@RequestBody AsignarAgente req) throws DaoException {
        logger.info("----------m:createAgente--------");
        logger.info("controler --> Empezando a registrar ");
        logger.info("para1: "+req.getOption());
        logger.info("para1: "+req.getCodagente());
        logger.info("para3: "+req.getCodcustomer());
        logger.info("para5: "+req.getNumdocum());
        logger.info("para6: "+req.getTipo());
        logger.info("para8: "+req.getTscrea());
        logger.info("para9: "+req.getTsmodi());
        RespGeneric response = agenteService.createAsignacion(req);
        logger.info("controler --> end create ");
        return response;
    }

    @RequestMapping(value = Constantes.LIST_ASSIGNATION_ROW_ALL, method = RequestMethod.GET)
    public @ResponseBody
    List<AsignarAgente> listAsignation(@RequestParam(name="customerid") long customerid) {
        logger.info("customerid: "+customerid);
        ParamIn p=new ParamIn();
        p.setCustomerId(customerid);
        List<AsignarAgente> lst = agenteService.listAsignacion(p);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

}
