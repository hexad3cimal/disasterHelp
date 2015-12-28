package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.AidNeeded;

/**
 * Created by jovin on 20/12/15.
 */
public interface AidNeededDao {
    public void add(AidNeeded aidNeeded)throws Exception;
    public Integer getCount()throws Exception;
    public Integer getDisasterCount(String disaster)throws Exception;
    public Integer getAidNeededCount() throws Exception;
}
