package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.AgentexProducto;
import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.FrecuenciaAct;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.Productos;
import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.persistence.Sucursal;
import com.keralty.usuarios.persistence.TipoIdentificacion;
import java.util.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalServicesJpaRepository {

    Collection<Productos> assocOperator001(Long tGSINC1PRODUCTOptpatrNumero) throws SystemException;

    Boolean assocOperator002(Long tGSINC1PRODUCTOptpatrNumero) throws SystemException;

    Collection<FrecuenciaAct> assocOperator003() throws SystemException;

    Collection<FrecuenciaAct> assocOperator004() throws SystemException;

    Collection<Regional> assocOperator039(Long tGSINC1SUCURSALptpatrCodigo) throws SystemException;

    Boolean assocOperator040(Long tGSINC1SUCURSALptpatrCodigo) throws SystemException;

    Collection<Sucursal> assocOperator042(Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException;

    Boolean assocOperator043(Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException;

    Collection<FrecuenciaAct> assocOperator044() throws SystemException;

    Collection<FrecuenciaAct> assocOperator045() throws SystemException;

    Collection<Sucursal> assocOperator063(Long tGSINC1ASESORptpatrCodigoSucursal) throws SystemException;

    Collection<Asesor> assocOperator065(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException;

    Collection<Asesor> assocOperator066(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException;

    Boolean assocOperator067(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException;

    Collection<FrecuenciaAct> assocOperator068() throws SystemException;

    Collection<FrecuenciaAct> assocOperator069() throws SystemException;

    Collection<TipoIdentificacion> assocOperator096(Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException;

    Boolean assocOperator097(Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException;

    Collection<FrecuenciaAct> assocOperator098() throws SystemException;

    Collection<FrecuenciaAct> assocOperator099() throws SystemException;

    Collection<Sucursal> assocOperator139() throws SystemException;

    Collection<Funcionario> assocOperator140(String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException;

    Boolean assocOperator141(String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException;

    Collection<FrecuenciaAct> assocOperator144() throws SystemException;

    Collection<FrecuenciaAct> assocOperator145() throws SystemException;

    Collection<Productos> assocOperator147(String tGSINC1AGENTEXPRODpProducto) throws SystemException;

    Boolean assocOperator148(String tGSINC1AGENTEXPRODpProducto) throws SystemException;

    Collection<AgentexProducto> assocOperator150(Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException;

    Boolean assocOperator151(Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException;

    Collection<Asesor> assocOperator166(String tGPOSPROCESS1ASESORpUsuario) throws SystemException;

    Collection<Asesor> assocOperator167() throws SystemException;

    Boolean assocOperator168() throws SystemException;

    Collection<Asesor> assocOperator169() throws SystemException;

    Boolean assocOperator170() throws SystemException;

    Boolean assocOperator171(String tCREARAGENTEptpatrUsuarioLDAP) throws SystemException;

    Long assocOperator172(String tMODIFICARAGENTEptpatrUsuarioLDAP, Funcionario tMODIFICARAGENTEptpthisAgente) throws SystemException;

    Collection<Funcionario> assocOperator173(String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException;

    Long assocOperator174(String tGNEWASESORAGENCIAptpatrUsuarioLDAP) throws SystemException;

    Long assocOperator175(String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException;

    Collection<Funcionario> assocOperator176(String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException;

    Long assocOperator177(String tGMODASESORAGENCIAptptUsuarioLDAP, Asesor tGMODASESORAGENCIAptpthisAsesor) throws SystemException;

    Long assocOperator178(String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException;
}
