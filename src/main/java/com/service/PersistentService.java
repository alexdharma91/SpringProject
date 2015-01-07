package com.service;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class PersistentService {

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    private HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public <T> void saveAll(List<T> entities){
       getHibernateTemplate().saveOrUpdateAll(entities);
    }

    public <T> void save(T entity){
        getHibernateTemplate().saveOrUpdate(entity);
    }

    public <T> List <T> getAll(Class <T> clazz) {
        DetachedCriteria allCriteria = DetachedCriteria.forClass(clazz);
        return getHibernateTemplate().findByCriteria(allCriteria);
    }

    public <T> T get(Class <T> clazz, Long id){
        DetachedCriteria allCriteria = DetachedCriteria.forClass(clazz);
        allCriteria.add(Restrictions.idEq(id));
        return (T)getHibernateTemplate().findByCriteria(allCriteria).get(0);
    }

    public <T> void deleteAll(List<T> entities){
        getHibernateTemplate().deleteAll(entities);
    }

    public <T> void delete(T entity){
        getHibernateTemplate().delete(entity);
    }

}
