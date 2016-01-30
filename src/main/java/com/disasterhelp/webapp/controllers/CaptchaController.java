package com.disasterhelp.webapp.controllers;

import com.disasterhelp.webapp.Utils.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * Created by jovin on 20/1/16.
 */
@Controller
public class CaptchaController {

    @RequestMapping(value = "/getCaptcha")
    @ResponseBody
    public Response getCaptcha(HttpServletRequest request){

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

        ByteArrayOutputStream imageByte = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", imageByte);

        }catch (Exception e){

        }
        byte[] bytes = imageByte.toByteArray();
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

}
