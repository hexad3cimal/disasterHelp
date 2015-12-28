package com.disasterhelp.webapp.service;

import com.disasterhelp.webapp.beans.Area;

/**
 * Created by jovin on 15/12/15.
 */
public interface AreaService {
    public void add(Area area);
    public void edit(Area area);
    public Boolean getByAreaName(String areaName);
    public Area getByName(String areaName);
    public Integer getDisasterCount(String disaster)throws Exception;
    public Integer getAreaCount() throws Exception;
}
