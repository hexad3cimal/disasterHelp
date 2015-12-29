package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.AidNeeded;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jovin on 20/12/15.
 */
@Repository("AidNeededDao")
public class AidNeededDaoImpl implements AidNeededDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void add(AidNeeded aidNeeded) throws Exception {
        sessionFactory.getCurrentSession().save(aidNeeded);
    }

    @Override
    public Integer getCount() throws Exception {
        return ((Long)sessionFactory.getCurrentSession().createQuery("select count(*) from AidNeeded")
        .uniqueResult()).intValue();
    }

    @Override
    public Integer getDisasterCount(String disaster) throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AidNeeded.class,"aidNeeded")
                .createAlias("aidNeeded.disaster","disaster", JoinType.LEFT_OUTER_JOIN);
        criteria.add(Restrictions.eq("disaster.disasterName", disaster));
        return ((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//        List count = criteria.list();
//        return count.size();
    }

    @Override
    public Integer getAidNeededCount() throws Exception {
        return ((Long)(sessionFactory.getCurrentSession().createCriteria(AidNeeded.class)
                .setProjection(Projections.rowCount()).uniqueResult())).intValue();
    }
}
