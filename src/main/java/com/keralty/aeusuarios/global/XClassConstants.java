package com.keralty.aeusuarios.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>XClass</code> model class.
 */
public final class XClassConstants {

    private XClassConstants() {

    }

    // Class
    /** <code>XClass</code> class id. */
    public static final String CLASS_ID = "Clas_1458206408704152_Alias";
    /** <code>XClass</code> class name. */
    public static final String CLASS_NAME = "XClass";
    /** <code>XClass</code> class alias. */
    public static final String CLASS_ALIAS = "Clase";
    /** <code>XClass</code> class table name. */
    public static final String TBL_NAME = "XClass";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "xClassxcodigo,xClassxdescripcion";

    public static final String DSICXCLASS = "IC_XClass";
    

    // Attribute (xClassxcodigo)
    /** <code>xClassxcodigo</code> attribute id. */
    public static final String ATTR_ID_XCLASSXCODIGO = "Clas_1458206408704152Atr_1_Alias";
    /** <code>xClassxcodigo</code> attribute name. */
    public static final String ATTR_NAME_XCLASSXCODIGO = "xClassxcodigo";
    /** <code>xClassxcodigo</code> attribute alias. */
    public static final String ATTR_ALIAS_XCLASSXCODIGO = "Codigo";

    /** <code>xClassxcodigo</code> attribute facet sequence. */
    public static final String PATH_FACETS_XCLASSXCODIGO = "";
    /** Agents allowed to view the attribute xClassxcodigo **/
    public static final String XCLASSXCODIGO_AGENTS = "Admin,SuperAdmin,Asesor,AreaMedica,Afiliaciones,RespRegional,Gestor,MesaDeApoyo,Funcionario,Admin,SuperAdmin,Asesor,AreaMedica,Afiliaciones,RespRegional,Gestor,MesaDeApoyo";
    // Attribute (xClassxdescripcion)
    /** <code>xClassxdescripcion</code> attribute id. */
    public static final String ATTR_ID_XCLASSXDESCRIPCION = "Clas_1458206408704152Atr_2_Alias";
    /** <code>xClassxdescripcion</code> attribute name. */
    public static final String ATTR_NAME_XCLASSXDESCRIPCION = "xClassxdescripcion";
    /** <code>xClassxdescripcion</code> attribute alias. */
    public static final String ATTR_ALIAS_XCLASSXDESCRIPCION = "Descripción";

    /** <code>xClassxdescripcion</code> attribute facet sequence. */
    public static final String PATH_FACETS_XCLASSXDESCRIPCION = "";
    /** Agents allowed to view the attribute xClassxdescripcion **/
    public static final String XCLASSXDESCRIPCION_AGENTS = "Admin,SuperAdmin,Asesor,AreaMedica,Afiliaciones,RespRegional,Gestor,MesaDeApoyo,Funcionario,Admin,SuperAdmin,Asesor,AreaMedica,Afiliaciones,RespRegional,Gestor,MesaDeApoyo";


    // Field (xcodigo)
    /** <code>xcodigo</code> field name. */
    public static final String FLD_XCLASSXCODIGO = "xcodigo";    
    /** <code>xcodigo</code> field length. */
    public static final int FLD_XCLASSXCODIGOLENGTH = 20;
    /** <code>xClassxcodigo</code> attribute field name. */
    public static final String ATTR_FIELD_XCLASSXCODIGO = "xClassxcodigo";
    // Field (xdescripcion)
    /** <code>xdescripcion</code> field name. */
    public static final String FLD_XCLASSXDESCRIPCION = "xdescripcion";    
    /** <code>xdescripcion</code> field length. */
    public static final int FLD_XCLASSXDESCRIPCIONLENGTH = 100;
    /** <code>xClassxdescripcion</code> attribute field name. */
    public static final String ATTR_FIELD_XCLASSXDESCRIPCION = "xClassxdescripcion";



    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1458206408704152Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Crear";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "";
    // Inbound arguments
    /** <code>xClasscreateinstancepatrxcodigo</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_XCLASSCREATEINSTANCEPATRXCODIGO = "p_atrxcodigo";
    /** <code>xClasscreateinstancepatrxcodigo</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_XCLASSCREATEINSTANCEPATRXCODIGO = "Clas_1458206408704152Ser_1Arg_1_Alias";
    /** <code>xClasscreateinstancepatrxcodigo</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_XCLASSCREATEINSTANCEPATRXCODIGO = "Codigo";
    /** <code>xClasscreateinstancepatrxdescripcion</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_XCLASSCREATEINSTANCEPATRXDESCRIPCION = "p_atrxdescripcion";
    /** <code>xClasscreateinstancepatrxdescripcion</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_XCLASSCREATEINSTANCEPATRXDESCRIPCION = "Clas_1458206408704152Ser_1Arg_2_Alias";
    /** <code>xClasscreateinstancepatrxdescripcion</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_XCLASSCREATEINSTANCEPATRXDESCRIPCION = "Descripción";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1458206408704152Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Borrar";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "";
    // Inbound arguments
    /** <code>xClassdeleteinstancepthisXClass</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_XCLASSDELETEINSTANCEPTHISXCLASS = "p_thisXClass";
    /** <code>xClassdeleteinstancepthisXClass</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_XCLASSDELETEINSTANCEPTHISXCLASS = "Clas_1458206408704152Ser_2Arg_1_Alias";
    /** <code>xClassdeleteinstancepthisXClass</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_XCLASSDELETEINSTANCEPTHISXCLASS = "Clase";


    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_XCLASSXDESCRIPCION.toUpperCase(), Constants.Type.STRING.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_XCLASSXCODIGO.toUpperCase(), XCLASSXCODIGO_AGENTS);
    	attributeAgents.put(ATTR_NAME_XCLASSXDESCRIPCION.toUpperCase(), XCLASSXDESCRIPCION_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'XClass', it returns the identification keys
     * - If className is a facet of the inheritance net of 'XClass', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_XCLASSXCODIGO);
        }
        // Facet 'XClass' (This facet)
        if (XClassConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_XCLASSXCODIGO);
        }
        return returnList;
    }
}
