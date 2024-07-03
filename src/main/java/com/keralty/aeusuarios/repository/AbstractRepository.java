package com.keralty.aeusuarios.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.inject.Inject;

import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import com.keralty.aeusuarios.utils.Agent;

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
