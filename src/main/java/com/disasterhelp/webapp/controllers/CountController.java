package com.disasterhelp.webapp.controllers;

import com.disasterhelp.webapp.Utils.Response;
import com.disasterhelp.webapp.beans.Helpline;
import com.disasterhelp.webapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jovin on 20/12/15.
 */
@Controller
public class CountController {
    @Autowired
    VolunteerService volunteerService;
    @Autowired
    HelplineService helplineService;
    @Autowired
    AreaService areaService;
    @Autowired
    DisasterService disasterService;
    @Autowired
    AidNeededService aidNeededService;
    @Autowired
    AidAvailableService aidAvailableService;

    @RequestMapping(value = "/TotalCount")
    @ResponseBody
    public Response TotalCount() {
        System.out.println("Reached total count >>>>>>>");
        List<Integer> totalCount = new ArrayList<>();
        try {
            totalCount.add(volunteerService.getVolunteerCount());
            totalCount.add(helplineService.getHelplineCount());
            totalCount.add(areaService.getAreaCount());
            totalCount.add(disasterService.disasterCount());
            totalCount.add(aidNeededService.getAidNeededCount());
            totalCount.add(aidAvailableService.getCount());
            return new Response(totalCount);

        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error");
        }


    }

    @RequestMapping(value = "/disasterCount" )
    @ResponseBody
    public Response disasterCount(@RequestParam(value = "disaster") String disaster){

        List<Integer> disasterCount = new ArrayList<>();
        try {
            disasterCount.add(aidAvailableService.getDisasterCount(disaster));
            disasterCount.add(volunteerService.getDisasterCount(disaster));
            disasterCount.add(helplineService.getDisasterCount(disaster));
            disasterCount.add(areaService.getDisasterCount(disaster));
            disasterCount.add(aidNeededService.getDisasterCount(disaster));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Response(disasterCount);
    }
}
