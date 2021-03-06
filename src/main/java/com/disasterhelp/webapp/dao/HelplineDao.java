package com.disasterhelp.webapp.dao;

import com.disasterhelp.webapp.beans.Helpline;

import java.util.List;

/**
 * Created by jovin on 5/12/15.
 */
public interface HelplineDao {

    public void add(Helpline helpline)throws Exception;
    public void update(Helpline helpline)throws Exception;
    public void delete(Integer id)throws Exception;
    public Helpline getByNo(String no)throws Exception;
    public List<Helpline> helplineList(String disaster)throws Exception;
    public Integer getDisasterCount(String disaster)throws Exception;
    public Integer getHelplineCount() throws Exception;

}
