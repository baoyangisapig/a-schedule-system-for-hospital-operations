package com.usst.dao;

import com.usst.SessionFactory.SessionBuilder;
import com.usst.mapper.CountMapper;
import com.usst.mapper.DoctorMapper;
import com.usst.pojo.Doctor;
import org.apache.ibatis.session.SqlSession;

public class DoctorDao {
   public Doctor SelectByName(String name)throws  Exception
   {
       SessionBuilder builder= new SessionBuilder();
       SqlSession session=builder.SessionProducer();
       DoctorMapper doctorMapper=session.getMapper(DoctorMapper.class);
       return  doctorMapper.SelectByName(name);
   }
   public void InsertAll(String name,String number,String section) throws Exception
   {
       SessionBuilder builder= new SessionBuilder();
       SqlSession session=builder.SessionProducer();
       DoctorMapper doctorMapper=session.getMapper(DoctorMapper.class);
       doctorMapper.InsertAll(name,number,section);
       session.commit();
   }
}
