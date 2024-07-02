package com.keralty.usuarios.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.inject.Inject;

import com.keralty.usuarios.global.UserFunctions;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import com.keralty.usuarios.utils.Agent;

public class AbstractRepository {

    @Inject
    protected Agent agent;

    @Inject
    protected UserFunctions userFunctionsSrv;

    @PersistenceContext
    protected EntityManager em;
    
    public void setEntityManager(EntityManager em) {
    	this.em = em;
    }

    public int solveCountQuery(SQLSelect select) {
        return new TypedQueryBuilder<>(em, Long.class).build4Count(select).getSingleResult().intValue();
    }
}
