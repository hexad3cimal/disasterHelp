package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.Disaster;
import com.disasterhelp.webapp.beans.Helpline;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jovin on 4/12/15.
 */
@Repository("DisasterDao")
public class DisasterDaoImpl implements DisasterDao {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Disaster getById(Integer Id) throws Exception {
        return (Disaster) sessionFactory.getCurrentSession().get(Disaster.class,Id);
    }

    @Override
    public Disaster getByName(String disasterName) throws Exception {
        Disaster disaster = new Disaster();
        disaster= (Disaster) sessionFactory.getCurrentSession().createQuery("from Disaster where disasterName = :disaster")
                .setParameter("disaster", disasterName).list().get(0);
        Hibernate.initialize(disaster.getHelplines());
        Hibernate.initialize(disaster.getVolunteerses());
        return disaster;
    }

    @Override
    public void add(Disaster disaster) throws Exception {

        sessionFactory.getCurrentSession().save(disaster);

    }

    @Override
    public void edit(Disaster disaster) throws Exception {

        sessionFactory.getCurrentSession().update(disaster);

    }

    @Override
    public List<Helpline> getHelplineByDisaster(Disaster disaster) throws Exception {
        return null;
    }

    @Override
    public Integer disasterCount() throws Exception {
        return ((Long)(sessionFactory.getCurrentSession().createQuery("Select count(*) from Disaster")
                .setCacheable(true).uniqueResult())).intValue();
    }
}
