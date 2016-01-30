package com.disasterhelp.webapp.controllers;

import com.disasterhelp.webapp.Utils.NullCheck;
import com.disasterhelp.webapp.Utils.Response;
import com.disasterhelp.webapp.beans.*;
import com.disasterhelp.webapp.dao.MenuDao;
import com.disasterhelp.webapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by jovin on 20/1/16.
 */
@Controller
public class DataTableController {

    @Autowired
    HelplineService helplineService;
    @Autowired
    MenuDao menuDao;
    @Autowired
    DisasterService disasterService;
    @Autowired
    VolunteerService volunteerService;
    @Autowired
    AreaService areaService;
    @Autowired
    AidAvailableService aidAvailableService;
    @Autowired
    AidNeededService aidNeededService;


    @RequestMapping("{disaster}/helpline/getlist")
    @ResponseBody
    public Response helplineList(@PathVariable(value = "disaster") String disaster,
                                 @RequestParam(value = "areaSearch") String areaSearch) {
        List<Helpline> helplineList = new ArrayList<>();
        if (!NullCheck.isEmpty(areaSearch)) {
            areaSearch = areaSearch.replace("\"", "");

            try {
                System.out.println("Disaster >>>>" + disaster);
                Area area = areaService.getByName(areaSearch+" "+disaster.toUpperCase());
                if(!NullCheck.isEmpty(area)) {
                    Set<Helpline> helplineSet = area.getHelplines();
                    for (Helpline helpline : helplineSet) {
                        helplineList.add(helpline);
                    }
                }
                return new Response(helplineList);

            } catch (Exception e) {
                e.printStackTrace();
                return new Response("error" + e.getMessage());
            }

        }
        else {
            return new Response(helplineList);
        }

    }
    @RequestMapping("{disaster}/volunteer/getlist")
    @ResponseBody
    public Response volunteerList(@PathVariable(value = "disaster") String disaster,
                                  @RequestParam(value = "areaSearch") String areaSearch) {
        List<Volunteers> volunteerList = new ArrayList<>();
        if (!NullCheck.isEmpty(areaSearch)) {
            areaSearch = areaSearch.replace("\"", "");

            try {
                System.out.println("Disaster >>>>" + disaster);
//                Disaster disasterObject = disasterService.getByName(disaster);
                Area area = areaService.getByName(areaSearch+" "+disaster.toUpperCase());
                if(!NullCheck.isEmpty(area)) {
                    Set<Volunteers> volunteerSet = area.getVolunteerses();
                    for (Volunteers volunteers : volunteerSet) {
                        volunteerList.add(volunteers);
                    }
                }
                return new Response(volunteerList);

            } catch (Exception e) {
                e.printStackTrace();
                return new Response("error" + e.getMessage());
            }

        }
        else {
            return new Response(volunteerList);
        }
    }


    @RequestMapping("{disaster}/aid/aidAvailableList")
    @ResponseBody
    public Response aidAvailableList(@PathVariable(value = "disaster") String disaster,
                                     @RequestParam(value = "areaSearch") String areaSearch) {
        List<AidAvailable> aidAvailableList = new ArrayList<>();
        if (!NullCheck.isEmpty(areaSearch)) {
            areaSearch = areaSearch.replace("\"", "");

            try {
                System.out.println("Disaster >>>>" + disaster);
//                Disaster disasterObject = disasterService.getByName(disaster);
                Area area = areaService.getByName(areaSearch+" "+disaster.toUpperCase());
                if(!NullCheck.isEmpty(area)) {
                    Set<AidAvailable> aidAvailableSet = area.getAidAvailables();
                    for (AidAvailable aidAvailable : aidAvailableSet) {
                        aidAvailableList.add(aidAvailable);
                    }
                }
                return new Response(aidAvailableList);

            } catch (Exception e) {
                e.printStackTrace();
                return new Response("error" + e.getMessage());
            }

        }
        else {
            return new Response(aidAvailableList);
        }
    }


    @RequestMapping("{disaster}/aid/aidNeededList")
    @ResponseBody
    public Response aidNeededList(@PathVariable(value = "disaster") String disaster,
                                  @RequestParam(value = "areaSearch") String areaSearch) {
        List<AidNeeded> aidNeededList = new ArrayList<>();
        if (!NullCheck.isEmpty(areaSearch)) {
            areaSearch = areaSearch.replace("\"", "");

            try {
                System.out.println("Disaster >>>>" + disaster);
//                Disaster disasterObject = disasterService.getByName(disaster);
                Area area = areaService.getByName(areaSearch+" "+disaster.toUpperCase());
                if(!NullCheck.isEmpty(area)) {
                    Set<AidNeeded> aidNeededSet = area.getAidNeededs();
                    for (AidNeeded aidNeeded : aidNeededSet) {
                        aidNeededList.add(aidNeeded);
                    }
                }
                return new Response(aidNeededList);

            } catch (Exception e) {
                e.printStackTrace();
                return new Response("error" + e.getMessage());
            }

        }
        else {
            return new Response(aidNeededList);
        }
    }


}
