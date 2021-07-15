package com.brokers.invest.constantes;

public class Constantes {
	public static final String CREATE_AFILIATION="/afiliation/create";
	public static final String LIST_PRODUCT="/rest/listProduct/{id}";
	public static final String LIST_DEPARTAMENTO="/rest/listDepart/{id}";
	public static final String LIST_SEARCH_USER_AFFILIATED="/rest/listAffiliatedUser";
	public static final String AUTENTICAR_CTA_USER="/rest/autenticarusr";
	public static final String VIEW_DATA_CTA_USER="/rest/datosctauser";
	public static final String LIST_ROLS_ACCOUNT_USER="/user/listRolsAcount";

	public static final String LIST_PROVINCIA="/rest/listProvincia/{cod}";
	public static final String LIST_DISTRITO="/rest/listDistrito/{cod}";
	public static final String LIST_DOCUM_IDENT="/rest/listDocumIden/{cod}";
	public static final String TEST_PROCEDURE="/rest/test/{param}";
	public static final String LIST_TIPO_DOCUMENT="/rest/listTipoDocum/{cod}";
	public static final String LIST_PERFILES="/rest/listPerfil/{cod}";
	//customer
	public static final String CREATE_CUSTOMER="/customer/create";
	public static final String LIST_CUSTOMER_ALL_ROW="/customer/listllrow";
	public static final String LIST_CUSTOMER_BY_ID="/customer/listbyid";
	//tratar como
	public static final String LIST_TRATAR_COMO="/customer/tratarcomo";
	//agentes
	public static final String LIST_AGENTE_ALL="/agente/agenteall";
	public static final String LIST_AGENTE_BY_ID="/agente/agentebyid";
	public static final String CREATE_AGENTE="/agente/create";
	//grupos
	public static final String LIST_GRUPOS_ALL="/customer/gruposall";
	//ASIGNACION
	public static final String CREATE_ASIGNA_AGENTE="/agente/createassignation";
	public static final String LIST_ASSIGNATION_ROW_ALL="/agente/listassignation";
	//COMPANY
	public static final String CREATE_COMPANY="/company/create";
	public static final String LIST_COMPANY_ALLROW="/company/listcomapnyall";
	public static final String LIST_COMPANY_BYID="/company/listcomapnybyid";
	public static final String LIST_COMPANY_VIGENCIA="/company/listvigencia";
	public static final String LIST_COMPANY_MONEY="/company/listmoney";
	public static final String LIST_COMPANY_FECHAPAGO="/company/fechapagos";
	//PRODUCT
	public static final String LIST_PRODUCT_ALL="/product/listproductall";
	public static final String LIST_SUB_PRODUCT_ALL="/product/listsubproductall";
	public static final String LIST_CREATE_PRODUCT_COMPANY="/product/addproductcom";
	public static final String LIST_PRODUCT_COMPANY="/product/listcompanyprod";


}