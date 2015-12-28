package com.disasterhelp.webapp.service;

import com.disasterhelp.webapp.beans.Volunteers;
import com.disasterhelp.webapp.dao.VolunteerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jovin on 15/12/15.
 */
@Transactional
@Service("VolunteerService")
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    VolunteerDao volunteerDao;
    @Override
    public void add(Volunteers volunteers) throws Exception {
        volunteerDao.add(volunteers);
    }

    @Override
    public void edit(Volunteers volunteers) throws Exception {
        volunteerDao.edit(volunteers);
    }

    @Override
    public Volunteers getByPhone(String phNo) throws Exception {
        return volunteerDao.getByPhone(phNo);
    }

    @Override
    public Integer getDisasterCount(String disaster) throws Exception {
        return volunteerDao.getDisasterCount(disaster);
    }

    @Override
    public Integer getVolunteerCount() throws Exception {
        return volunteerDao.getVolunteerCount();
    }


}
