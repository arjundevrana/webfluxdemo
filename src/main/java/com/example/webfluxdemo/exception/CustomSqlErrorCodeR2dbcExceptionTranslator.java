package com.example.webfluxdemo.exception;

import io.r2dbc.spi.R2dbcException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.data.r2dbc.support.SqlErrorCodeR2dbcExceptionTranslator;

public class CustomSqlErrorCodeR2dbcExceptionTranslator  extends SqlErrorCodeR2dbcExceptionTranslator {
    protected DataAccessException customTranslate(String task, String sql, R2dbcException r2dbcex) {

        if (r2dbcex.getErrorCode() == -12345) {
            return new DeadlockLoserDataAccessException(task, r2dbcex);
        }

        return null;
    }
}
