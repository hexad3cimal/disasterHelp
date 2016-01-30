package com.disasterhelp.webapp.test;

import com.disasterhelp.webapp.beans.Disaster;
import com.disasterhelp.webapp.dao.DisasterDao;
import com.disasterhelp.webapp.service.DisasterService;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

/**
 * Created by jovin on 21/1/16.
 */
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DisasterServiceTest {

    @Mock
    DisasterDao disasterDao;

    @InjectMocks
    @Autowired
    DisasterService disasterService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void disasterDaoTest() throws Exception{
        Disaster disaster = new Disaster();
        disaster.setId(1);
        when(disasterDao.getById(1)).thenReturn(disaster);
        Assert.assertEquals(disaster,disasterDao.getById(2));
    }
}
