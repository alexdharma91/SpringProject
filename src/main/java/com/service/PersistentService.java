package com.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Date: 27.09.14
 * Time: 16:17
 */
@Component
public class PersistentService {

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void ggg(){
        int h = 0;
    }

}
