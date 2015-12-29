package com.disasterhelp.webapp.service;

import com.disasterhelp.webapp.beans.AidAvailable;
import com.disasterhelp.webapp.dao.AidAvailableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jovin on 20/12/15.
 */
@Transactional
@Service("AidAvailableService")
public class AidAvailableServiceImpl implements AidAvailableService {
@Autowired
AidAvailableDao aidAvailableDao;


    @Override
    public void add(AidAvailable aidAvailable) throws Exception {
        aidAvailableDao.add(aidAvailable);
    }

    @Override
    public Integer getCount() throws Exception {
        return aidAvailableDao.getCount();
    }

    @Override
    public Integer getDisasterCount(String disaster) throws Exception {
        return aidAvailableDao.getDisasterCount(disaster);
    }
}
