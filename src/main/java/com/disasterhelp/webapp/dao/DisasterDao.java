package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.Disaster;
import com.disasterhelp.webapp.beans.Helpline;

import java.util.List;

/**
 * Created by jovin on 4/12/15.
 */
public interface DisasterDao {

    public Disaster getById(Integer Id) throws Exception;
    public Disaster getByName(String disasterName) throws Exception;
    public void add(Disaster disaster) throws Exception;
    public void edit(Disaster disaster) throws Exception;
    public List<Helpline> getHelplineByDisaster(Disaster disaster)throws Exception;
    public Integer disasterCount()throws Exception;

}
