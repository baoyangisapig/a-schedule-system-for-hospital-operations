package com.usst.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.usst.dao.ApplicationDao;
import com.usst.pojo.Application;
import jdk.management.resource.internal.inst.AbstractPlainDatagramSocketImplRMHooks;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "doctor")
@SessionAttributes(value = {"countid"})
public class DoctorController {
    @RequestMapping(value = "status1",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String One(@ModelAttribute(value ="countid")String countid) throws Exception
    {
        System.out.println(countid);
        int id=Integer.parseInt(countid);
        ArrayList<Application> list=new ApplicationDao().SelectById(id);
        return new JSONArray(list).toString();
    }
    @RequestMapping(value="status2",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public  String notone(@ModelAttribute(value ="countid")String countid) throws  Exception
    {
        System.out.println(countid);
        int id=Integer.parseInt(countid);

        ArrayList<Application> list=new ApplicationDao().SelectById2(id);
        return new JSONArray(list).toString();
    }
    @RequestMapping(value="do",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public  ModelAndView Do(@ModelAttribute(value="countid") String countid,ModelAndView mv,@RequestParam("s1")String s1) throws Exception {
        String[] array=s1.split(",");
        int length=array.length;

        ArrayList<Application> list=new ApplicationDao().SelectById(Integer.parseInt(countid));

        for(int i=0;i<length;i++)
        {
            int id=list.get(Integer.parseInt(array[i])).getId();
            new ApplicationDao().UpdateStatus1(id);
        }
        System.out.println(length+","+list.size());
        mv.setViewName("welcomepage/operation.html");
        return mv;
    }
}
