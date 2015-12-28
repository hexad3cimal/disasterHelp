package com.disasterhelp.webapp.service;

import com.disasterhelp.webapp.beans.Disaster;

/**
 * Created by jovin on 4/12/15.
 */
public interface DisasterService {

    public Disaster getById(Integer Id) throws Exception;
    public Disaster getByName(String disasterName) throws Exception;
    public void add(Disaster disaster) throws Exception;
    public void edit(Disaster disaster) throws Exception;
    public Integer disasterCount()throws Exception;

}
