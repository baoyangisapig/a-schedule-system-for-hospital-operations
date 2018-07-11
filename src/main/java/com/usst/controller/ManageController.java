package com.usst.controller;

import com.mysql.cj.xdevapi.JsonArray;
import com.usst.dao.ApplicationDao;
import com.usst.dao.NurseDao;
import com.usst.pojo.Nurse;
import org.json.JSONArray;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.font.NumericShaper;
import java.util.ArrayList;

@Controller
@RequestMapping(value="/manage")
@SessionAttributes(value = {"id"})
public class ManageController {
    @RequestMapping(value ="nurse",produces="text/html;charset=UTF-8;")
    public ModelAndView Manage(ModelAndView mv, @RequestParam(value="patient")String patient, @RequestParam(value="name")String name, @RequestParam(value ="id")String id)throws  Exception
    {
            mv.setViewName("welcomepage/Manage.jsp");
            String newpatient=new String(patient.getBytes("iso-8859-1"),"utf-8");
            String newname=new String(name.getBytes("iso-8859-1"),"utf-8");
            mv.addObject("patient",newpatient);
            mv.addObject("name",newname);
            mv.addObject("id",id);


            return mv;
    }
    @ResponseBody
    @RequestMapping(value="show",produces="text/html;charset=UTF-8;")
    public  String ShowNurse() throws  Exception
    {
        ArrayList<Nurse> list=new NurseDao().ShowNurse();
        JSONArray array=new JSONArray(list);
        return  array.toString();

    }
    @ResponseBody
    @RequestMapping(value = "do",produces="text/html;charset=UTF-8;")
    public  ModelAndView Do(@ModelAttribute("id") String myid1, ModelAndView mv, @RequestParam(value = "s1")String s1) throws  Exception
    {
        System.out.println(s1);
        String[] array=s1.split(",");
        ArrayList<Nurse> list=new NurseDao().ShowNurse();

        int myid=Integer.parseInt(myid1);
        int id=list.get(Integer.parseInt(array[0])).getId();
        String name=list.get(Integer.parseInt(array[0])).getName();
        if(array.length>1)
        {
            int id1=list.get(Integer.parseInt(array[1])).getId();
            String name1=list.get(Integer.parseInt(array[1])).getName();
            new ApplicationDao().UpdateNurse(id,name,id1,name1,myid);
            new NurseDao().UpdateStatus(id1);
        }
        else
        {
            new ApplicationDao().UpdateNurse1(id,name,myid);
        }
        new ApplicationDao().UpdateStatus(myid);
        new NurseDao().UpdateStatus(id);

        mv.setViewName("welcomepage/doctor.html");

        return mv;
    }
    @RequestMapping(value="room")
    public  ModelAndView ShowRoom(ModelAndView mv)
    {
        mv.setViewName("welcomepage/index1.html");
        return mv;
    }
    @ResponseBody
    @RequestMapping(value = "vision",produces="text/html;charset=UTF-8;")
    public String Room() throws Exception
    {
        ArrayList<String> list=new ApplicationDao().SelectRoom();
        JSONArray array=new JSONArray(list);
        return  array.toString();
    }

}
