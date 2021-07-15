package com.brokers.invest.controller;

import com.brokers.invest.constantes.Constantes;
import com.brokers.invest.exception.DaoException;
import com.brokers.invest.model.*;
import com.brokers.invest.service.AgenteService;
import com.brokers.invest.service.ProductBrokersService;
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
public class ProductBrokersController {

    private static final Logger logger = LoggerFactory.getLogger(ProductBrokersController.class);

    @Autowired
    ProductBrokersService productBrokersService;

    @RequestMapping(value = Constantes.LIST_PRODUCT_ALL, method = RequestMethod.GET)
    public @ResponseBody
    List<Product> listProduct(@RequestParam(name="ctaorga") long ctaorga) {
        logger.info("numdocum: "+ctaorga);
        List<Product> lst = productBrokersService.listProduct(ctaorga);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_SUB_PRODUCT_ALL, method = RequestMethod.GET)
    public @ResponseBody
    List<SubProduct> listSubProduct(@RequestParam(name="codproduct") long codproduct) {
        logger.info("codproduct: >>> "+codproduct);
        List<SubProduct> lst = productBrokersService.listSubProduct(codproduct);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

    @RequestMapping(value = Constantes.LIST_CREATE_PRODUCT_COMPANY, method = RequestMethod.POST)
    @ApiOperation(value = "Agrega productos a la company", tags = "Controlador Rest")
    public RespGeneric createCompanyProd(@RequestBody CompanyProduct req) throws DaoException {
        logger.info("----------m:createAgente--------");
        logger.info("controler --> Empezando a registrar ");
        logger.info("para1: "+req.getOption());
        logger.info("codcompany: "+req.getCodcompany());
        logger.info("codproducto: "+req.getCodproduct());
        logger.info("codsubproducto: "+req.getCodsubproduct());
        logger.info("desc sub producto: "+req.getNameSubProduct());
        logger.info("cuentaid: "+req.getCuentaid());
        RespGeneric response = productBrokersService.createAddPrduct(req);
        logger.info("controler --> end create ");
        return response;
    }

    @RequestMapping(value = Constantes.LIST_PRODUCT_COMPANY, method = RequestMethod.GET)
    public @ResponseBody
    List<CompanyProduct> listCompanyProduc(@RequestParam(name="codcompany") long codcompany,
                                           @RequestParam(name="codproduct") long codproduct,
                                           @RequestParam(name="codsubprod") long codsubprod,
                                           @RequestParam(name="option") String option) {
        logger.info("codcomapny: >>> "+codcompany);
        logger.info("codproduct: >>> "+codproduct);
        logger.info("codsubprod: >>> "+codsubprod);
        logger.info("option: >>> "+option);
        ParamIn p=new ParamIn();
        p.setCodcompany(codcompany);
        p.setCodproduct(codproduct);
        p.setCodsubproduct(codsubprod);
        p.setOption(option);
        List<CompanyProduct> lst = productBrokersService.listAddProduct(p);
        if(lst!=null){
            logger.info("size:>>> "+lst.size());
        }
        return lst;
    }

}
