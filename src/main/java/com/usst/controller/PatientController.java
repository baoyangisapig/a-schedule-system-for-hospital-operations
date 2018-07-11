package com.usst.controller;

import com.usst.dao.ApplicationDao;
import com.usst.dao.DoctorDao;
import com.usst.dao.PatientDao;
import com.usst.pojo.Doctor;
import com.usst.pojo.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/patient")
@SessionAttributes(value = {"countid"})
public class PatientController {
    @RequestMapping(value = "operation",produces="text/html;charset=UTF-8;")
    public ModelAndView Upload(@ModelAttribute("countid")String id, ModelAndView mv, @RequestParam(value = "op_name")String name, @RequestParam(value = "op_people")String people,@RequestParam("time")String time,@RequestParam("roomnumber") String roomnumber)throws  Exception
    {
        String name1=new String(name.getBytes("iso-8859-1"),"utf-8");
        String people1=new String(people.getBytes("iso-8859-1"),"utf-8");
        String time1=new String(time.getBytes("iso-8859-1"),"utf-8");
        String roomnumber1=new String(roomnumber.getBytes("iso-8859-1"),"utf-8");
        System.out.println(time1+","+roomnumber);
        Doctor doctor=new DoctorDao().SelectByName(people1);
        Patient patient=new PatientDao().SelectById(Integer.parseInt(id));
        new ApplicationDao().InsertAll(patient.getId(),patient.getName(),patient.getSection(),doctor.getId(),doctor.getName(),doctor.getSection(),time1,name1,roomnumber1);
        mv.setViewName("welcomepage/patient.html");
        return  mv;
    }
}
