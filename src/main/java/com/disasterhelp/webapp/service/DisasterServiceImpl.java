package com.disasterhelp.webapp.service;

import com.disasterhelp.webapp.beans.Disaster;
import com.disasterhelp.webapp.dao.DisasterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jovin on 4/12/15.
 */
@Transactional
@Service("DisasterService")
public class DisasterServiceImpl implements DisasterService {
    @Autowired
    DisasterDao disasterDao;

    @Override
    public Disaster getById(Integer Id) throws Exception {
        return disasterDao.getById(Id);
    }

    @Override
    public Disaster getByName(String disasterName) throws Exception {
        return this.disasterDao.getByName(disasterName);
    }

    @Override
    public void add(Disaster disaster) throws Exception {
            disasterDao.add(disaster);
    }

    @Override
    public void edit(Disaster disaster) throws Exception {
            disasterDao.edit(disaster);
    }

    @Override
    public Integer disasterCount() throws Exception {
        return disasterDao.disasterCount();
    }
}
