package com.brokers.invest.controller;


import com.brokers.invest.constantes.Constantes;
import com.brokers.invest.exception.DaoException;
import com.brokers.invest.model.*;
import com.brokers.invest.service.CompanyService;
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
public class CompanyController {

    private static final Logger logger = LoggerFactory.getLogger(AgenteController.class);

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = Constantes.CREATE_COMPANY, method = RequestMethod.POST)
    @ApiOperation(value = "Crea company", tags = "Controlador Rest")
    public RespGeneric createCompany(@RequestBody Company req) throws DaoException {
        logger.info("----------m:createAgente--------");
        logger.info("controler --> Empezando a registrar ");
        logger.info("OPTION: "+req.getOption());
        logger.info("NAME LARG: "+req.getNamecompany());
        logger.info("NAME SMALL: "+req.getSmallname());
        logger.info("USER CREA: "+req.getUsrcrea());
        logger.info("FECHA REG: "+req.getTscrea());
        logger.info("USER MOD: "+req.getUsrmodi());
        logger.info("TSMODI: "+req.getTsmodi());
        logger.info("CTAORGA: "+req.getTsmodi());
        RespGeneric response = companyService.createCompany(req);
        logger.info("controler --> end create ");
        return response;
    }

    @RequestMapping(value = Constantes.LIST_COMPANY_ALLROW, method = RequestMethod.GET)
    public @ResponseBody
    List<Company> listCompanyAllRow(@RequestParam(name="name") String name,
                                  @RequestParam(name="ctaorga") long ctaorga) {
        logger.info("filter: "+name);
        logger.info("ctaorga: "+ctaorga);
        ParamIn p=new ParamIn();
        p.setOption("_ALLROW");
        p.setSearchName(name);
        p.setCtaorga(ctaorga);
        List<Company> lst = companyService.listCompanyRow(p);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_COMPANY_BYID, method = RequestMethod.GET)
    public @ResponseBody
    List<Company> listCompanyById(@RequestParam(name="codcompany") long codcompany,
                                    @RequestParam(name="ctaorga") long ctaorga) {
        logger.info("filter: "+codcompany);
        logger.info("ctaorga: "+ctaorga);
        ParamIn p=new ParamIn();
        p.setOption("_BYID");
        p.setCompanyId(codcompany);
        p.setCtaorga(ctaorga);
        p.setSearchName("");
        List<Company> lst = companyService.listCompanyRow(p);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_COMPANY_VIGENCIA, method = RequestMethod.GET)
    public @ResponseBody
    List<Vigencia> listVigencia(@RequestParam(name="ctaorga") long ctaorga) {
        logger.info("ctaorga: "+ctaorga);
        List<Vigencia> lst = companyService.listVigencia(ctaorga);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_COMPANY_MONEY, method = RequestMethod.GET)
    public @ResponseBody
    List<Money> listMoney() {
        logger.info("======sin parametros: ");
        List<Money> lst = companyService.listMoney();
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_COMPANY_FECHAPAGO, method = RequestMethod.GET)
    public @ResponseBody
    List<FechaPago> listFechaPagos() {
        logger.info("======sin parametros: ");
        List<FechaPago> lst = companyService.listFechasPago();
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }
}
