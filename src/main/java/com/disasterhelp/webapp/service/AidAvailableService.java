package com.disasterhelp.webapp.service;

import com.disasterhelp.webapp.beans.AidAvailable;

/**
 * Created by jovin on 20/12/15.
 */
public interface AidAvailableService {


    public void add(AidAvailable aidAvailable)throws Exception;
    public Integer getCount()throws Exception;
    public Integer getDisasterCount(String disaster)throws Exception;

}
