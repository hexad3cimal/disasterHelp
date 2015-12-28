package com.disasterhelp.webapp.controllers;

import com.disasterhelp.webapp.Utils.MenuComparator;
import com.disasterhelp.webapp.Utils.NullCheck;
import com.disasterhelp.webapp.Utils.Response;
import com.disasterhelp.webapp.beans.*;
import com.disasterhelp.webapp.dao.DisasterDao;
import com.disasterhelp.webapp.dao.MenuDao;
import com.disasterhelp.webapp.service.*;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import javax.swing.text.html.FormSubmitEvent;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.List;

/**
 * Created by jovin on 5/12/15.
 */

@Controller
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
    public  List<MainMenu> menuList(){
        List<MainMenu> mainMenuList = menuDao.getMenuList();
        MenuComparator menuComparator = new MenuComparator();
        Collections.sort(mainMenuList, new MenuComparator() );
        return mainMenuList ;

    }

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

    @RequestMapping("{disaster}/home")
    public ModelAndView helplineListView(){
        return new ModelAndView("helpline");
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

    @RequestMapping("{disaster}/volunteer/getCount")
    @ResponseBody
    public Response totalVolunteerList(@PathVariable(value = "disaster") String disaster) {
        try {
            System.out.println("Disaster >>>>" + disaster);
            List<Integer> countList = new ArrayList<>();
            Integer volunteerCount = volunteerService.getVolunteerCount();
           countList.add(volunteerCount);
            Disaster disasterObject = disasterService.getByName(disaster);
            Integer areaCount = disasterObject.getAreas().size();
            countList.add(areaCount);
            Integer helplineCount = disasterObject.getHelplines().size();
            countList.add(helplineCount);
            Integer aidAvailableCount = disasterObject.getAidAvailables().size();
            countList.add(aidAvailableCount);
            Integer aidNeededCount = disasterObject.getAidNeededs().size();
            countList.add(aidNeededCount);
            return new Response(countList);

        } catch (Exception e) {
            e.printStackTrace();
            return new Response("error" + e.getMessage());
        }

    }

    @RequestMapping(value = ("{disaster}/volunteer/add") ,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response addVolunteer(@PathVariable(value = "disaster") String disaster,
                                 @RequestBody HashMap<String,Object> volunteer) {
        try {
            Disaster disasterObject = disasterService.getByName(disaster);
            Area areaObject = new Area();
            String area = volunteer.get("area").toString().toUpperCase();
            Volunteers volunteers = new Volunteers();
            if(!areaService.getByAreaName(area+" "+disaster.toUpperCase())){
                System.out.println("TRUE>>>>>>>>");
                areaObject = areaService.getByName(area+" "+disaster);
                volunteers.setArea(areaObject);
            }

            else {
                areaObject.setAreaName(area+" "+disaster.toUpperCase());
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
        }
catch (Exception e){
            e.printStackTrace();
    return new Response("Error");

}


    }

    @RequestMapping(value = "/getCaptcha")
    @ResponseBody public Response getCaptcha(HttpServletRequest request){

        Random r = new Random( System.currentTimeMillis() );
        Integer captcha = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
        String captchaString = String.valueOf(captcha);
        JLabel label = new JLabel(captchaString);
        label.setSize(45, 30);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        BufferedImage image = new BufferedImage(
                label.getWidth(), label.getHeight(),
                BufferedImage.TYPE_BYTE_BINARY);

        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        label.paint(g);
        g.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", baos);

        }catch (Exception e){

        }
        byte[] bytes = baos.toByteArray();
        String base64String = new sun.misc.BASE64Encoder().encode(bytes);

        request.getSession().setAttribute("captchaV", captcha);
        return new Response("data:image/png;base64,"+base64String);
    }


    @RequestMapping(value = "/validateCaptcha")
    @ResponseBody public Boolean validate(@RequestParam String captchaText,
                                           HttpServletRequest request){

       String captchaRequest =  request.getSession().getAttribute("captchaV").toString();
        System.out.println("Captcaha v >>>>>."+captchaRequest);
        System.out.println("Captcaha b >>>>>."+captchaText);
        if (captchaRequest.equalsIgnoreCase(captchaText)){

            return new Boolean(true);
        }

        else
            return new Boolean(false);


    }

    @RequestMapping(value = "{disaster}/aid/add",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @ResponseBody
    public Response addAid(@PathVariable (value = "disaster") String disaster,
                           @RequestBody HashMap<String,Object> aid ){
        try {
            Area area = new Area();
            Disaster disasterObject = disasterService.getByName(disaster);
            area = areaService.getByName(aid.get("area").toString().toUpperCase() + " "+disaster.toUpperCase());
            if(NullCheck.isEmpty(area)){

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

        }
        catch (Exception e){
            e.printStackTrace();
            return new Response("Error");
        }
    }


    @RequestMapping(value = "/{disaster}/helpline/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response addHelpline(@PathVariable (value = "disaster") String disaster,
                                @RequestBody HashMap<String,Object> helpline){

        try{
            Area area = new Area();
            Disaster disasterObject = disasterService.getByName(disaster);
            String areaName = helpline.get("area").toString().toUpperCase();
            System.out.println("Area anme>>>>>>>>"+areaName);
            area = areaService.getByName(areaName + " "+disaster.toUpperCase());
            if(NullCheck.isEmpty(area)){
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
        }
        catch (Exception e){
            e.printStackTrace();
            return new Response("Error");
        }
    }


    @RequestMapping(value = "/")
    public ModelAndView homePage(){

        return new ModelAndView("home");
    }

    @RequestMapping(value = "/disaster/add",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response addDisaster(@RequestBody HashMap<String,Object> disaster){

        Disaster disasterObject = new Disaster();
        MainMenu mainMenu = new MainMenu();
        try {
            String disasterName = disaster.get("disasterName").toString();
            disasterObject.setDisasterName(disasterName);
            disasterService.add(disasterObject);
            mainMenu.setTitle(disasterName);
            mainMenu.setLink("/webapp/"+disasterName+"/home");
            menuDao.add(mainMenu);
            return new Response("Success");
        }catch (Exception e){
            e.printStackTrace();
            return new Response("Error");
        }
    }

    @RequestMapping(value = "{disaster}/aid/request",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @ResponseBody
    public Response requestAid(@PathVariable (value = "disaster") String disaster,
                           @RequestBody HashMap<String,Object> aid ){
        try {
            Area area = new Area();
            Disaster disasterObject = disasterService.getByName(disaster);
            area = areaService.getByName(aid.get("area").toString().toUpperCase() + " "+disaster.toUpperCase());
            if(NullCheck.isEmpty(area)){

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

        }
        catch (Exception e){
            e.printStackTrace();
            return new Response("Error");
        }
    }


    @RequestMapping(value = "{disaster}/area/add",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @ResponseBody
    public Response areaAdd(@PathVariable (value = "disaster") String disaster,
                               @RequestBody HashMap<String,Object> areaMap ){
        try {
            Area area = new Area();
            Disaster disasterObject = disasterService.getByName(disaster);
            area = areaService.getByName(areaMap.get("area").toString().toUpperCase() + " "+disaster.toUpperCase());
            if(NullCheck.isEmpty(area)){

                area.setAreaName(areaMap.get("area").toString().toUpperCase());
                area.setDisaster(disasterObject);
                areaService.add(area);

            }
            else {
                return new Response("Already exists");

            }

            return new Response("Success");

        }
        catch (Exception e){
            e.printStackTrace();
            return new Response("Error");
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
