package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.MainMenu;

import java.util.List;

/**
 * Created by jovin on 8/12/15.
 */
public interface MenuDao {

    public List<MainMenu> getMenuList();
    public void add(MainMenu mainMenu);
}
