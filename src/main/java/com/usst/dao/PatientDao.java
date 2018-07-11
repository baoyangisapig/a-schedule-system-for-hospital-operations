package com.usst.dao;

import com.usst.SessionFactory.SessionBuilder;
import com.usst.mapper.NurseMapper;
import com.usst.mapper.PatientMapper;
import com.usst.pojo.Patient;
import org.apache.ibatis.session.SqlSession;

public class PatientDao {
    public Patient SelectById(int id) throws Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        PatientMapper mapper=session.getMapper(PatientMapper.class);
        return  mapper.SelectById(id);

    }
    public  void InsertAll(String name,String number,String section) throws  Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        PatientMapper mapper=session.getMapper(PatientMapper.class);
        mapper.InsertAll(name,number,section);
        session.commit();

    }
    public  Patient SelectByName(String name)throws Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        PatientMapper mapper=session.getMapper(PatientMapper.class);
        return mapper.SelectByName(name);
    }
}
