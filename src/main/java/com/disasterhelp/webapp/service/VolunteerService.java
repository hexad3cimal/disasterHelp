package com.disasterhelp.webapp.service;

import com.disasterhelp.webapp.beans.Volunteers;

/**
 * Created by jovin on 15/12/15.
 */
public interface VolunteerService {

    public void add(Volunteers volunteers)throws Exception;
    public void edit(Volunteers volunteers)throws Exception;
    public Volunteers getByPhone(String phNo)throws Exception;
    public Integer getDisasterCount(String disaster)throws Exception;
    public Integer getVolunteerCount() throws Exception;

}
