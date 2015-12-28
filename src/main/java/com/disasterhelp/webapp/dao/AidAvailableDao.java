package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.AidAvailable;

/**
 * Created by jovin on 20/12/15.
 */
public interface AidAvailableDao {

    public void add(AidAvailable aidAvailable)throws Exception;
    public Integer getCount()throws Exception;
    public Integer getDisasterCount(String disaster)throws Exception;
}
