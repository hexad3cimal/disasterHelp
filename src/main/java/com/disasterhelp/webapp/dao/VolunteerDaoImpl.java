package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.Volunteers;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jovin on 13/12/15.
 */
@Repository("VolunteerDao")
public class VolunteerDaoImpl implements VolunteerDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void add(Volunteers volunteers) throws Exception {
        sessionFactory.getCurrentSession().save(volunteers);
    }

    @Override
    public void edit(Volunteers volunteers) throws Exception {
        sessionFactory.getCurrentSession().update(volunteers);
    }

    @Override
    public Volunteers getByPhone(String phNo) throws Exception {
        return (Volunteers)sessionFactory.getCurrentSession().
                createQuery("From Volunteers where contactNo=:contactNo")
                .setParameter("contactNo",phNo).setCacheable(true).uniqueResult();
    }

    @Override
    public Integer getDisasterCount(String disaster) throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Volunteers.class,"volunteers")
                .createAlias("volunteers.disaster", "disaster", JoinType.LEFT_OUTER_JOIN);
        criteria.add(Restrictions.eq("disaster.disasterName", disaster));
        return ((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();

    }

    @Override
    public Integer getVolunteerCount() throws Exception {
        return ((Long)(sessionFactory.getCurrentSession().createCriteria(Volunteers.class)
                .setProjection(Projections.rowCount()).uniqueResult())).intValue();
    }


}
