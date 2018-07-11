package com.usst.mapper;

import com.usst.pojo.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ApplicationMapper {
    ArrayList<Application> SelectByStatus(int status);
    void UpdateNurse(int id,String name,int id1,String name1,int app_id);
    void UpdateNurse1(int id,String name,int app_id);
    void UpdateStatus(int id);
    void UpdateStatus1(int id);
    ArrayList<Application> SelectDay();
    ArrayList<Application> SelectMonth();
    ArrayList<String> SelectRoom();
    ArrayList<Application> SelectById(int id);
    ArrayList<Application> SelectById2(int id);
    void InsertAll(int p_id,String p_name,String p_section,int d_id,String d_name,String d_section,String time,String name,String roomnumber);

}
