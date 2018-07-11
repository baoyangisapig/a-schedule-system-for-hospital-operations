package com.usst.dao;

import com.usst.SessionFactory.SessionBuilder;
import com.usst.mapper.ApplicationMapper;
import com.usst.mapper.CountMapper;
import com.usst.pojo.Application;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class ApplicationDao {
    public ArrayList<Application>  SelectByStatus(int status) throws Exception {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper countMapper=session.getMapper(ApplicationMapper.class);
        return countMapper.SelectByStatus(status);
    }
    public  void UpdateNurse(int id,String name,int id1,String name1,int app_id) throws Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper mapper=session.getMapper(ApplicationMapper.class);
        mapper.UpdateNurse(id,name,id1,name1,app_id);
        session.commit();
    }
    public void UpdateNurse1(int id,String name,int app_id) throws Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper mapper=session.getMapper(ApplicationMapper.class);
        mapper.UpdateNurse1(id,name,app_id);
        session.commit();
    }
    public  void UpdateStatus(int  id)throws  Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper mapper=session.getMapper(ApplicationMapper.class);
        mapper.UpdateStatus(id);
        session.commit();
    }
    public void UpdateStatus1(int id)throws Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper mapper=session.getMapper(ApplicationMapper.class);
        mapper.UpdateStatus1(id);
        session.commit();
    }

   public ArrayList<Application> SelectDay()throws Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper mapper=session.getMapper(ApplicationMapper.class);
        ArrayList<Application> list=mapper.SelectDay();
        return list;
    }
    public ArrayList<Application> SelectMonth()throws  Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper mapper=session.getMapper(ApplicationMapper.class);
        ArrayList<Application> list=mapper.SelectMonth();
        return list;
    }
    public  ArrayList<String> SelectRoom() throws  Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper mapper=session.getMapper(ApplicationMapper.class);
        ArrayList<String> list=mapper.SelectRoom();
        return  list;
    }

    public ArrayList<Application> SelectById(int id) throws Exception
    {

        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper mapper=session.getMapper(ApplicationMapper.class);
        return mapper.SelectById(id);
    }
    public ArrayList<Application> SelectById2(int id) throws Exception{
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper mapper=session.getMapper(ApplicationMapper.class);
        return mapper.SelectById2(id);
    }

    public  void InsertAll(int p_id,String p_name,String p_section,int d_id,String d_name,String d_section,String time,String name,String roomnumber)throws Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        ApplicationMapper mapper=session.getMapper(ApplicationMapper.class);
        mapper.InsertAll(p_id,p_name,p_section,d_id,d_name,d_section,time,name,roomnumber);
        session.commit();
    }

}
