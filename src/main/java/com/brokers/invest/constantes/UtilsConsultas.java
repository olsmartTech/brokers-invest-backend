package com.brokers.invest.constantes;

public class UtilsConsultas {
	public static final String CALL_AFILIATION_ACOUNT="{call fn_create_cta_user(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String CALL_AFILIATION_TEST="{call FN_Probando_sp(?,?)}";
	public static final String CALL_LIST_PRODUCT="{call fn_list_product(?)}";
	public static final String CALL_LIST_DEPART="{call fn_list_depart()}";
	public static final String CALL_LIST_PROVINCIA="{call fn_list_provincia(?)}";
	public static final String CALL_LIST_DISTRITO="{call fn_list_distrito(?)}";
	public static final String CALL_LIST_TIPO_DOCUMENT="{call fn_list_tipo_doc_iden()}";
	public static final String CALL_LIST_PERFILES="{call fn_list_perfiles()}";
	public static final String CALL_LIST_USER_AFILIATED="{call fn_listar_user_afiliated(?,?,?)}";
	public static final String CALL_SP_AUTHETICATESER="{call fn_verify_cta_user(?,?)}";
	public static final String CALL_SP_DATA_CTA_USER="{call fn_view_data_person(?)}";
	public static final String CALL_SP_ROLES_ACCOUNT="{call fn_list_roles_by_cta(?)}";
	// SP PARA LA TABLA CUSTOMER
	public static final String CALL_CREATE_CUSTOMER="{call fn_create_customer(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String CALL_LIST_CUSTOMER_ALL_ROW="{call fn_list_customer(?,?)}";
	public static final String CALL_LIST_CUSTOMER_BY_ID="{call fn_list_customer(?,?)}";
	public static final String CALL_LIST_TRATAR_COMO_ALL_ROW="{call fn_list_tratar_como()}";
    ///agentes
	public static final String CALL_CREATE_AGENTE="{call fn_create_agentes(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String CALL_LIST_AGENTE_ALL="{call fn_list_agente(?,?,?)}";
	//ASIGNAR AGENTE
	public static final String CALL_CREATE_ASIGNAR_AGENTE="{call fn_create_asignacion_agent(?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String CALL_LIST_LIST_ASIGNACION_ALL="{call fn_list_asignacion(?)}";
	//GRUPOS
	public static final String CALL_LIST_GRUPOS_ALL="{call fn_list_grupos()}";
	///Companys
	public static final String CALL_CREATE_COMPANY="{call fn_create_company(?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String CALL_LIST_COMPANY="{call fn_list_company(?,?,?,?)}";
	//PRODUCT
	public static final String CALL_LIST_PRODUCT_BROKERS="{call fn_list_prduct_brokers(?)}";
	public static final String CALL_LIST_SUB_PRODUCT_BROKERS="{call fn_list_sub_prduct(?)}";
	//PRODUCT ASIGNATE
	public static final String CALL_CREATE_COMPANY_PRODUCT="{call fn_create_company_product(?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String CALL_LIST_PRODUCT_COMPANY="{call fn_product_assignate(?,?,?,?)}";
    // VIGENCIA
	public static final String CALL_LIST_VIGENCIA="{call fn_list_vigencia(?)}";
	public static final String CALL_LIST_MONEY="{call fn_list_money()}";
	public static final String CALL_LIST_FOCHA_PAGO="{call fn_list_fechapago()}";

}
