package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.MainMenu;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jovin on 8/12/15.
 */
@Repository("MenuDao")
@Transactional
public class MenuDaoImpl implements MenuDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<MainMenu> getMenuList() {
        return sessionFactory.getCurrentSession().createCriteria(MainMenu.class).setCacheable(true).list();
    }

    @Override
    public void add(MainMenu mainMenu) {
        sessionFactory.getCurrentSession().save(mainMenu);
    }
}
