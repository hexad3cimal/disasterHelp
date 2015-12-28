package com.disasterhelp.webapp.service;

import com.disasterhelp.webapp.beans.Helpline;
import com.disasterhelp.webapp.dao.HelplineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jovin on 5/12/15.
 */
@Service("HelplineService")
@Transactional
public class HelplineServiceImpl implements HelplineService {

    @Autowired
    HelplineDao helplineDao;

    @Override
    public void add(Helpline helpline) throws Exception {

        helplineDao.add(helpline);
    }

    @Override
    public void update(Helpline helpline) throws Exception {

        helplineDao.update(helpline);
    }

    @Override
    public void delete(Integer id) throws Exception {

        helplineDao.delete(id);
    }

    @Override
    public Helpline getByNo(String no) throws Exception {

        return helplineDao.getByNo(no);
    }

    @Override
    public Integer getDisasterCount(String disaster) throws Exception {
        return helplineDao.getDisasterCount(disaster);
    }

    @Override
    public Integer getHelplineCount() throws Exception {
        return helplineDao.getHelplineCount();
    }


}
