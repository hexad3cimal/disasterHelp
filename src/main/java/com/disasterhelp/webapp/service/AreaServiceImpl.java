package com.disasterhelp.webapp.service;

import com.disasterhelp.webapp.beans.Area;
import com.disasterhelp.webapp.dao.AreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jovin on 15/12/15.
 */
@Service("AreaService")
@Transactional
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaDao areaDao;
    @Override
    public void add(Area area) {
        areaDao.add(area);
    }

    @Override
    public void edit(Area area) {
    areaDao.edit(area);
    }

    @Override
    public Boolean getByAreaName(String areaName) {
        return areaDao.getByAreaName(areaName);
    }

    @Override
    public Area getByName(String areaName) {
        return areaDao.getByName(areaName);
    }

    @Override
    public Integer getDisasterCount(String disaster) throws Exception {
        return areaDao.getDisasterCount(disaster);
    }

    @Override
    public Integer getAreaCount() throws Exception {
        return areaDao.getAreaCount();
    }


}
