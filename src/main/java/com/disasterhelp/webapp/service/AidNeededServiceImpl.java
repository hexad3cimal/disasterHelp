package com.disasterhelp.webapp.service;

import com.disasterhelp.webapp.beans.AidNeeded;
import com.disasterhelp.webapp.dao.AidNeededDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jovin on 20/12/15.
 */
@Service("AidNeededService")
@Transactional
public class AidNeededServiceImpl implements AidNeededService {
    @Autowired
    AidNeededDao aidNeededDao;
    @Override
    public void add(AidNeeded aidNeeded) throws Exception {
        aidNeededDao.add(aidNeeded);
    }

    @Override
    public Integer getDisasterCount(String disaster) throws Exception {
        return aidNeededDao.getDisasterCount(disaster);
    }

    @Override
    public Integer getAidNeededCount() throws Exception {
        return aidNeededDao.getAidNeededCount();
    }


}
