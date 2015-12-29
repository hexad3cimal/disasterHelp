package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.AidAvailable;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jovin on 20/12/15.
 */
@Repository("AidAvailableDao")
public class AidAvailableDaoImpl implements AidAvailableDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void add(AidAvailable aidAvailable) throws Exception {
        sessionFactory.getCurrentSession().save(aidAvailable);
    }

    @Override
    public Integer getCount() throws Exception {
        return ((Long)sessionFactory.getCurrentSession().createQuery("select count(*) from AidAvailable")
                .uniqueResult()).intValue();
    }

    @Override
    public Integer getDisasterCount(String disaster) throws Exception {
        System.out.println("Reachded daooooo>>>" + disaster);
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(AidAvailable.class,"aidAvailable");
        criteria.createAlias("aidAvailable.disaster", "disaster", JoinType.LEFT_OUTER_JOIN);
        criteria.add(Restrictions.eq("disaster.disasterName", disaster));
       return ((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//        List count = criteria.list();
//        System.out.println("list size>>>>"+count.size());
//       return count.size();

    }
}
