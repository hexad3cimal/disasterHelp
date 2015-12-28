package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.Helpline;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jovin on 5/12/15.
 */
@Repository("HelplineDao")
public class HelplineDaoImpl implements HelplineDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void add(Helpline helpline) throws Exception {
        sessionFactory.getCurrentSession().save(helpline);
    }

    @Override
    public void update(Helpline helpline) throws Exception {
        sessionFactory.getCurrentSession().update(helpline);
    }

    @Override
    public void delete(Integer id) throws Exception {


    }

    @Override
    public Helpline getByNo(String no) throws Exception {
        return (Helpline)sessionFactory.getCurrentSession().createQuery("from Helpline where helplineno =:helplineno")
                .setParameter("helplineno",no).uniqueResult();
    }

    @Override
    public List<Helpline> helplineList(String disaster) throws Exception {
        return sessionFactory.getCurrentSession().createCriteria(Helpline.class,"helpline").
                        createAlias("helpline.disaster", "disaster", JoinType.LEFT_OUTER_JOIN)
                .add(Restrictions.eq("disaster.disasterName",disaster))
                .setCacheable(true).list();

    }

    @Override
    public Integer getDisasterCount(String disaster) throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Helpline.class,"helpline")
                .createAlias("helpline.disaster", "disaster", JoinType.LEFT_OUTER_JOIN);
        criteria.add(Restrictions.eq("disaster.disasterName", disaster));
        return ((Long)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();

    }


    @Override
    public Integer getHelplineCount() throws Exception {
        return ((Long)(sessionFactory.getCurrentSession().createCriteria(Helpline.class)
                .setProjection(Projections.rowCount()).uniqueResult())).intValue();
    }


}
