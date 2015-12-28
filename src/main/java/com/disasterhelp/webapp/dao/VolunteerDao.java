package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.Volunteers;

import java.util.List;

/**
 * Created by jovin on 13/12/15.
 */
public interface VolunteerDao {

    public void add(Volunteers volunteers)throws Exception;
    public void edit(Volunteers volunteers)throws Exception;
    public Volunteers getByPhone(String phNo)throws Exception;
    public Integer getDisasterCount(String disaster)throws Exception;
    public Integer getVolunteerCount()throws Exception;
}
