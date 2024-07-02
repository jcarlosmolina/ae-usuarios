package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.ReportesProcAlm;
import com.keralty.usuarios.sqlutils.SQLCount;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface ReportesProcAlmJpaRepositoryCustom {

    List<ReportesProcAlm> solveQuery(SQLSelect query);
    
    List<ReportesProcAlm> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Long assocOperator000() throws SystemException;

    Long assocOperator000Range1() throws SystemException;
    
    SQLCount assocOperator000Range1Query(SQLSelect superQuery) throws SystemException;

    public List<ReportesProcAlm> executeQuery(String query);

    public List<ReportesProcAlm> executeQuery(String query, List<SQLParam> params);
}
