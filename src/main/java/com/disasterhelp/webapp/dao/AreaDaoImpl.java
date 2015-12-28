package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.Area;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jovin on 15/12/15.
 */
@Repository("AreaDao")
public class AreaDaoImpl implements AreaDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void add(Area area) {
        sessionFactory.getCurrentSession().save(area);

    }

    @Override
    public void edit(Area area) {
        sessionFactory.getCurrentSession().update(area);
    }

    @Override
    public Boolean getByAreaName(String areaName) {
        return sessionFactory.getCurrentSession().createQuery("from Area where areaName =:areaName")
                .setParameter("areaName",areaName).list().isEmpty();
    }

    @Override
    public Area getByName(String areaName) {
        return (Area)sessionFactory.getCurrentSession().createQuery("from Area where areaName =:areaName")
                .setParameter("areaName",areaName).uniqueResult();
    }

    @Override
    public Integer getDisasterCount(String disaster) throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Area.class,"area")
                .createAlias("area.disaster", "disaster", JoinType.LEFT_OUTER_JOIN);
        criteria.add(Restrictions.eq("disaster.disasterName", disaster));
        criteria.setProjection(Projections.rowCount());
        List count = criteria.list();
        return count.size();
    }

    @Override
    public Integer getAreaCount() throws Exception {
        return ((Long)(sessionFactory.getCurrentSession().createCriteria(Area.class)
                .setProjection(Projections.rowCount()).uniqueResult())).intValue();
    }


}
