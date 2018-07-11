package com.usst.controller;

import com.usst.dao.ApplicationDao;
import com.usst.dao.CountDao;
import com.usst.dao.DoctorDao;
import com.usst.dao.PatientDao;
import com.usst.pojo.Application;
import com.usst.pojo.Count;
import com.usst.pojo.Doctor;
import com.usst.pojo.Patient;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Random;


@Controller
@RequestMapping(value="/demo")
@SessionAttributes(value={"countid","username"})

public class FirController {
    @ResponseBody()  //将返回值作为请求类型而不是html页面返回
    @RequestMapping(value = "result",produces="text/html;charset=UTF-8;")
    public String MyResult(@RequestParam(value="status")String status) throws Exception
    {
        if(status.equals("4"))
        {
            ArrayList<Application> list=new ApplicationDao().SelectMonth();
            return new JSONArray(list).toString();
        }
        else if(status.equals("5"))
        {
            ArrayList<Application> list=new ApplicationDao().SelectDay();
            return new JSONArray(list).toString();
        }
        else
        {
            ArrayList<Application> list=new ApplicationDao().SelectByStatus(Integer.parseInt(status));

            JSONArray array=new JSONArray(list);
            return array.toString();

        }


    }
    @RequestMapping("search")
    public  ModelAndView LoginDemo(ModelAndView mv,@RequestParam(value = "username")String username,@RequestParam(value = "password")String password)
    {
        if(username.equals("admin")&&password.equals("admin"))
        {
            mv.setViewName("welcomepage/doctor.html");
            return  mv;
        }
        else
        {
            Count count = null;
            try {
                count=new CountDao().SelectBy(username,password);
                int countid=count.getP_id();
                mv.addObject("countid",countid);
            }catch (Exception e)
            {
                mv.setViewName("welcomepage/index.html");
                return  mv;
            }
            if(count.getStatus().equals("1"))
            {
                mv.setViewName("welcomepage/operation.html");
                return mv;
            }
            else
            {
                mv.setViewName("welcomepage/patient.html");
                return mv;
            }
        }
    }
    @RequestMapping("logindemo")
    public ModelAndView SearchDemo(ModelAndView mv) throws Exception
    {
            mv.setViewName("welcomepage/index.html");
            return  mv;
    }
    @RequestMapping("login")
    public ModelAndView Login(@RequestParam("yourname")String name1,@RequestParam("choose")String choose,@RequestParam("ks")String keshi,@RequestParam("username1")String username1,@RequestParam("password1")String password1, ModelAndView mv) throws Exception
    {
        String name=new String(name1.getBytes("iso-8859-1"),"utf-8");
        String username=new String(username1.getBytes("iso-8859-1"),"utf-8");
        String password=new String(password1.getBytes("iso-8859-1"),"utf-8");
        String mychoose=new String(choose.getBytes("iso-8859-1"),"utf-8");
        String muks=new String(keshi.getBytes("iso-8859-1"),"utf-8");
       String number=new Random().nextInt(90000)+10000+"";
        int id=-1;
        if(mychoose.equals("option1"))
        {
            new PatientDao().InsertAll(name,number,muks);
            Patient patient=new PatientDao().SelectByName(name);
            id=patient.getId();
            new CountDao().InsertAll(id,"2",username,password);
        }
        else
        {
            new DoctorDao().InsertAll(name,number,muks);
            Doctor doctor=new DoctorDao().SelectByName(name);
            id=doctor.getId();
            new CountDao().InsertAll(id,"1",username,password);
        }

        System.out.println(username+","+password+mychoose+muks);
        mv.setViewName("welcomepage/index.html");
        return mv;
    }
}
