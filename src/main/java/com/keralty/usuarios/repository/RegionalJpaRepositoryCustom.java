package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface RegionalJpaRepositoryCustom {

    List<Regional> solveQuery(SQLSelect query);
    
    List<Regional> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Regional> executeQuery(String query);

    public List<Regional> executeQuery(String query, List<SQLParam> params);
}
