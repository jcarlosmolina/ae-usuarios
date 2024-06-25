package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.persistence.Persona;
import com.keralty.aeusuarios.persistence.ReportesDominio;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.persistence.Usuario;
import com.keralty.aeusuarios.persistence.UsuarioReg;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLGetOne;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLPopulation;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLSum;
import java.util.Collection;
import java.util.List;

public interface SolicitudJpaRepositoryCustom {

    List<Solicitud> solveQuery(SQLSelect query);
    
    List<Solicitud> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000() throws SystemException;

    Boolean assocOperator000Range1() throws SystemException;
    
    SQLExists assocOperator000Range1Query(SQLSelect superQuery) throws SystemException;

    Long assocOperator001() throws SystemException;

    Long assocOperator001Range1() throws SystemException;
    
    SQLCount assocOperator001Range1Query(SQLSelect superQuery) throws SystemException;

    Boolean assocOperator002(Solicitud instance) throws SystemException;

    Boolean assocOperator002Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator002Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator003(Solicitud instance) throws SystemException;

    Boolean assocOperator003Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator004(Solicitud instance) throws SystemException;

    Boolean assocOperator004Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator004Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator005(Solicitud instance) throws SystemException;

    Boolean assocOperator005Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator005Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator006(Solicitud instance) throws SystemException;

    Boolean assocOperator006Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator006Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator007(Solicitud instance) throws SystemException;

    Boolean assocOperator007Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator007Range1Query(Solicitud instance) throws SystemException;

    Double assocOperator008(Solicitud instance) throws SystemException;

    Double assocOperator008Range1(Solicitud instance) throws SystemException;
    
    SQLSum assocOperator008Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator009(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator009Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator009Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator010(Solicitud instance) throws SystemException;

    Boolean assocOperator010Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator010Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator011(Solicitud instance) throws SystemException;

    Boolean assocOperator011Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator011Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator012(Solicitud instance) throws SystemException;

    Boolean assocOperator012Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator012Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator013(Solicitud instance) throws SystemException;

    Boolean assocOperator013Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator013Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator014(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator014Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator014Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator015(Solicitud instance) throws SystemException;

    Boolean assocOperator015Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator015Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator016(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator016Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator016Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator017(Solicitud instance) throws SystemException;

    Boolean assocOperator017Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator017Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator018(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator018Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator018Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator019(Solicitud instance) throws SystemException;

    Boolean assocOperator019Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator019Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator020(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator020Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator020Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator021(Solicitud instance) throws SystemException;

    Boolean assocOperator021Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator021Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator022(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator022Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator022Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator023(Solicitud instance) throws SystemException;

    Boolean assocOperator023Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator023Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator024(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator024Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator024Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator025(Solicitud instance) throws SystemException;

    Boolean assocOperator025Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator025Range1Query(Solicitud instance) throws SystemException;

    Double assocOperator026(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator026Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator026Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator027(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator027Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator027Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator028(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator028Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator028Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator029(Solicitud instance) throws SystemException;

    Long assocOperator029Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator029Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator030(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator030Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator030Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator031(Solicitud instance) throws SystemException;

    Boolean assocOperator031Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator031Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator032(Solicitud instance) throws SystemException;

    Boolean assocOperator032Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator032Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator033(Solicitud instance) throws SystemException;

    Boolean assocOperator033Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator033Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator034(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator034Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator034Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator035(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator035Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator035Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator036(Solicitud instance) throws SystemException;

    Long assocOperator036Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator036Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator037(Solicitud instance) throws SystemException;

    Long assocOperator037Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator037Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator038(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator038Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator038Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator039(Solicitud instance) throws SystemException;

    Boolean assocOperator039Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator039Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator040(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator040Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator040Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator041(Solicitud instance) throws SystemException;

    Boolean assocOperator041Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator041Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator042(Solicitud instance) throws SystemException;

    Boolean assocOperator042Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator042Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator043(Solicitud instance) throws SystemException;

    Long assocOperator043Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator043Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator044(Solicitud instance) throws SystemException;

    Long assocOperator044Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator044Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator045(Solicitud instance) throws SystemException;

    Collection<UsuarioReg> assocOperator045Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator045Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator046(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator046Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator046Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator047(Solicitud instance) throws SystemException;

    Long assocOperator047Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator047Range1Query(Solicitud instance) throws SystemException;

    String assocOperator048(Solicitud instance) throws SystemException;

    String assocOperator048Range1(Solicitud instance) throws SystemException;
    
    SQLGetOne assocOperator048Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator049(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator049Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator049Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator050(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator050Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator050Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator051(Solicitud instance) throws SystemException;

    Long assocOperator051Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator051Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator052(Solicitud instance) throws SystemException;

    Long assocOperator052Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator052Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator053(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator053Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator053Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator054(Solicitud instance) throws SystemException;

    Boolean assocOperator054Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator054Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator055(Solicitud instance) throws SystemException;

    Boolean assocOperator055Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator055Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator056(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator056Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator056Range1Query(Solicitud instance) throws SystemException;

    Double assocOperator057(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator057Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator057Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator058(Solicitud instance) throws SystemException;

    Collection<ReportesDominio> assocOperator058Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator058Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator059(Solicitud instance) throws SystemException;

    Boolean assocOperator059Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator059Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator060(Solicitud instance) throws SystemException;

    Boolean assocOperator060Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator060Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator061(Solicitud instance) throws SystemException;

    Boolean assocOperator061Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator061Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator062(Solicitud instance) throws SystemException;

    Long assocOperator062Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator062Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator063(Solicitud instance) throws SystemException;

    Boolean assocOperator063Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator063Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator064(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator064Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator064Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator065(Solicitud instance) throws SystemException;

    Boolean assocOperator065Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator065Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator066(Solicitud instance) throws SystemException;

    Boolean assocOperator066Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator066Range1Query(Solicitud instance) throws SystemException;

    Long assocOperator067(Solicitud instance) throws SystemException;

    Long assocOperator067Range1(Solicitud instance) throws SystemException;
    
    SQLCount assocOperator067Range1Query(Solicitud instance) throws SystemException;

    String assocOperator068(Solicitud instance) throws SystemException;

    String assocOperator068Range1(Solicitud instance) throws SystemException;
    
    SQLGetOne assocOperator068Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator069(Solicitud instance) throws SystemException;

    Boolean assocOperator069Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator069Range1Query(Solicitud instance, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator070(Solicitud instance) throws SystemException;

    Boolean assocOperator070Range1(Solicitud instance) throws SystemException;
    
    SQLExists assocOperator070Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator071() throws SystemException;

    Boolean assocOperator071Range1() throws SystemException;
    
    SQLExists assocOperator071Range1Query(SQLSelect superQuery) throws SystemException;

    Boolean assocOperator072(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator072Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator072Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator073(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator073Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator073Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator074(Persona voPersona) throws SystemException;

    Boolean assocOperator074Range1(Persona voPersona) throws SystemException;
    
    SQLExists assocOperator074Range1Query(Persona voPersona, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator075() throws SystemException;

    Boolean assocOperator075Range1() throws SystemException;
    
    SQLExists assocOperator075Range1Query(SQLSelect superQuery) throws SystemException;

    Boolean assocOperator076(Solicitud instance) throws SystemException;

    Collection<Usuario> assocOperator076Range1(Solicitud instance) throws SystemException;
    
    SQLPopulation assocOperator076Range1Query(Solicitud instance) throws SystemException;

    Boolean assocOperator077(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator077Range1(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator077Range1Query(TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator078(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator078Range1(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator078Range1Query(TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator079(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator079Range1(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator079Range1Query(TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator080(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator080Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator080Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator081(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator081Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator081Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator082(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator082Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator082Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator083(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator083Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator083Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator084(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator084Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator084Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator085(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator085Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator085Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator086(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;

    Boolean assocOperator086Range1(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException;
    
    SQLExists assocOperator086Range1Query(TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException;

    public List<Solicitud> executeQuery(String query);

    public List<Solicitud> executeQuery(String query, List<SQLParam> params);
}
