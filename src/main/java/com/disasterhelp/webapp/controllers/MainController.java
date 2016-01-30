package com.disasterhelp.webapp.controllers;

import com.disasterhelp.webapp.Utils.MenuComparator;
import com.disasterhelp.webapp.Utils.NullCheck;
import com.disasterhelp.webapp.Utils.Response;
import com.disasterhelp.webapp.beans.*;
import com.disasterhelp.webapp.dao.MenuDao;
import com.disasterhelp.webapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.List;

/**
 * Created by jovin on 5/12/15.
 */

@Controller
@SessionAttributes("menuList")
public class MainController {
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


    @ModelAttribute("menuList")
    public List<MainMenu> menuList() {
        System.out.println("reached model attribute");
        List<MainMenu> mainMenuList = menuDao.getMenuList();
        MenuComparator menuComparator = new MenuComparator();
        Collections.sort(mainMenuList, new MenuComparator());
        return mainMenuList;

    }


    @RequestMapping("{disaster}/home")
    public ModelAndView helplineListView(@PathVariable(value = "") String disaster) {
        try {
            if (!NullCheck.isEmpty(disasterService.getByName(disaster)))
                return new ModelAndView("disasterHome");
            else
                return new ModelAndView("disaster404");

        } catch (Exception e) {
            return new ModelAndView("disaster404");
        }

    }


    @RequestMapping(value = ("{disaster}/volunteer/add"), method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response addVolunteer(@PathVariable(value = "disaster") String disaster,
                                 @RequestBody HashMap<String, Object> volunteer) {
        try {
            Disaster disasterObject = disasterService.getByName(disaster);
            Area areaObject = new Area();
            String area = volunteer.get("area").toString().toUpperCase();
            Volunteers volunteers = new Volunteers();
            if (!areaService.getByAreaName(area + " " + disaster.toUpperCase())) {
                System.out.println("TRUE>>>>>>>>");
                areaObject = areaService.getByName(area + " " + disaster);
                volunteers.setArea(areaObject);
            } else {
                areaObject.setAreaName(area + " " + disaster.toUpperCase());
                areaObject.setDisaster(disasterService.getByName(disaster));
                areaService.add(areaObject);
                volunteers.setArea(areaObject);
            }
            volunteers.setDisaster(disasterService.getByName(disaster));
            volunteers.setContactNo(volunteer.get("contactNo").toString());
            volunteers.setFullName(volunteer.get("volunteerName").toString());
            volunteers.setGender(volunteer.get("volunteerGender").toString());
            volunteers.setType(volunteer.get("supportType").toString());
            volunteerService.add(volunteers);
            return new Response("Success");
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error");

        }


    }


    @RequestMapping(value = "{disaster}/aid/add", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public Response addAid(@PathVariable(value = "disaster") String disaster,
                           @RequestBody HashMap<String, Object> aid) {
        try {
            Area area = new Area();
            Disaster disasterObject = disasterService.getByName(disaster);
            area = areaService.getByName(aid.get("area").toString().toUpperCase() + " " + disaster.toUpperCase());
            if (NullCheck.isEmpty(area)) {

                area.setAreaName(aid.get("area").toString().toUpperCase());
                area.setDisaster(disasterObject);
                areaService.add(area);

            }

            AidAvailable aidAvailable = new AidAvailable();
            aidAvailable.setArea(area);
            aidAvailable.setDisaster(disasterObject);
            aidAvailable.setAidType(aid.get("supportType").toString());
            aidAvailable.setContactNo(aid.get("contactNo").toString());
            aidAvailableService.add(aidAvailable);
            return new Response("Success");

        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error");
        }
    }


    @RequestMapping(value = "/{disaster}/helpline/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response addHelpline(@PathVariable(value = "disaster") String disaster,
                                @RequestBody HashMap<String, Object> helpline) {

        try {
            Area area = new Area();
            Disaster disasterObject = disasterService.getByName(disaster);
            String areaName = helpline.get("area").toString().toUpperCase();
            System.out.println("Area anme>>>>>>>>" + areaName);
            area = areaService.getByName(areaName + " " + disaster.toUpperCase());
            if (NullCheck.isEmpty(area)) {
                area.setAreaName(areaName);
                area.setDisaster(disasterObject);
                areaService.add(area);

            }

            Helpline helplineObject = new Helpline();
            helplineObject.setArea(area);
            helplineObject.setDisaster(disasterObject);
            helplineObject.setHelplineno(helpline.get("contactNo").toString());
            helplineObject.setType(helpline.get("supportType").toString());
            helplineService.add(helplineObject);
            return new Response("Success");
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error");
        }
    }


    @RequestMapping(value = "/")
    public ModelAndView homePage() {

        return new ModelAndView("home");
    }

    @RequestMapping(value = "/disaster/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response addDisaster(@RequestBody HashMap<String, Object> disaster) {

        Disaster disasterObject = new Disaster();
        MainMenu mainMenu = new MainMenu();
        try {
            String disasterName = disaster.get("disasterName").toString();
            disasterObject.setDisasterName(disasterName);
            disasterService.add(disasterObject);
            mainMenu.setTitle(disasterName);
            mainMenu.setLink("/webapp/" + disasterName + "/home");
            menuDao.add(mainMenu);
            return new Response("Success");
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error");
        }
    }

    @RequestMapping(value = "{disaster}/aid/request", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public Response requestAid(@PathVariable(value = "disaster") String disaster,
                               @RequestBody HashMap<String, Object> aid) {
        try {
            Area area = new Area();
            Disaster disasterObject = disasterService.getByName(disaster);
            area = areaService.getByName(aid.get("area").toString().toUpperCase() + " " + disaster.toUpperCase());
            if (NullCheck.isEmpty(area)) {

                area.setAreaName(aid.get("area").toString().toUpperCase());
                area.setDisaster(disasterObject);
                areaService.add(area);

            }

            AidNeeded aidNeeded = new AidNeeded();
            aidNeeded.setArea(area);
            aidNeeded.setDisaster(disasterObject);
            aidNeeded.setAidType(aid.get("supportType").toString());
            aidNeeded.setContactNo(aid.get("contactNo").toString());
            aidNeededService.add(aidNeeded);
            return new Response("Success");

        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error");
        }
    }


    @RequestMapping(value = "{disaster}/area/add", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public Response areaAdd(@PathVariable(value = "disaster") String disaster,
                            @RequestBody HashMap<String, Object> areaMap) {
        try {
            Area area = new Area();
            Disaster disasterObject = disasterService.getByName(disaster);
            area = areaService.getByName(areaMap.get("area").toString().toUpperCase() + " " + disaster.toUpperCase());
            if (NullCheck.isEmpty(area)) {

                area.setAreaName(areaMap.get("area").toString().toUpperCase());
                area.setDisaster(disasterObject);
                areaService.add(area);

            } else {
                return new Response("Already exists");

            }

            return new Response("Success");

        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Error");
        }
    }


}
