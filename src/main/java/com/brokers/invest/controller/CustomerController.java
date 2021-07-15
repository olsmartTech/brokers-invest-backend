package com.brokers.invest.controller;

import com.brokers.invest.constantes.Constantes;
import com.brokers.invest.exception.DaoException;
import com.brokers.invest.model.*;
import com.brokers.invest.service.CustomerServices;
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
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerServices customerServices;

    @RequestMapping(value = Constantes.CREATE_CUSTOMER, method = RequestMethod.POST)
    @ApiOperation(value = "Crea clientes", tags = "Controlador Rest")
    public RespGeneric crearCustomer(@RequestBody RequestCustomer req) throws DaoException {
        logger.info("----------m:crearAfiliation--------");
        logger.info("controler --> Empezando a registrar ");
        logger.info("para1: "+req.getOption());
        logger.info("para1: "+req.getRazonsocial());
        logger.info("para2: "+req.getCoddistrito());
        logger.info("para3: "+req.getRazonsocial());
        logger.info("para4: "+req.getCorreo());
        logger.info("para5: "+req.getName());
        logger.info("para6: "+req.getApePat());
        logger.info("para7: "+req.getFechaNac());
        logger.info("para8: "+req.getTscrea());
        logger.info("para9: "+req.getTsmodi());
        RespGeneric response = customerServices.customerCrea(req);
        logger.info("controler --> end create ");
        return response;
    }

    @RequestMapping(value = Constantes.LIST_CUSTOMER_ALL_ROW, method = RequestMethod.GET)
    public @ResponseBody
    List<Customer> listCustomerAllRow(@RequestParam(name="filter") String filter) {
        logger.info("filter: "+filter);
        //logger.info("numdocum: "+numdocum);
        //logger.info("fullname: "+fullname);
        ParamIn p=new ParamIn();
        p.setOption("_ROW");
        p.setSearchName(filter);
        List<Customer> lst = customerServices.listCustomer(p);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_CUSTOMER_BY_ID, method = RequestMethod.GET)
    public @ResponseBody
    Customer viewDataCustomerById(@RequestParam(name="customerid") long customerid) {
        logger.info("filter: "+customerid);
        //logger.info("numdocum: "+numdocum);
        //logger.info("fullname: "+fullname);

        ParamIn p=new ParamIn();
        p.setOption("_BYID");
        p.setCustomerId(customerid);
        Customer cust = customerServices.viewCustomerById(p);
        if(cust!=null){
            logger.info("size:>>> "+cust);
        }
        return cust;
    }

    @RequestMapping(value = Constantes.LIST_TRATAR_COMO, method = RequestMethod.GET)
    public @ResponseBody
    List<FormaTratar> listTratarComo(@RequestParam(name="filter") String filter) {
        logger.info("filter: "+filter);
        //logger.info("numdocum: "+numdocum);
        //logger.info("fullname: "+fullname);
        ParamIn p=new ParamIn();
        p.setOption("_ROW");
        p.setSearchName(filter);
        List<FormaTratar> lst = customerServices.listFormaTratar();
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    /*@RequestMapping(value = Constantes.LIST_AGENTE_ALL, method = RequestMethod.GET)
    public @ResponseBody
    List<Agente> listAgentesall(@RequestParam(name="filter") String filter) {
        logger.info("filter: "+filter);
        ParamIn p=new ParamIn();
        p.setOption("_ROW");
        p.setSearchName(filter);
        List<Agente> lst = customerServices.listAgenteAll();
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }*/

    @RequestMapping(value = Constantes.LIST_GRUPOS_ALL, method = RequestMethod.GET)
    public @ResponseBody
    List<Grupos> listGruposAll(@RequestParam(name="filter") String filter) {
        logger.info("filter: "+filter);
        ParamIn p=new ParamIn();
        p.setOption("_ROW");
        p.setSearchName(filter);
        List<Grupos> lst = customerServices.listGruposAll();
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }
}
