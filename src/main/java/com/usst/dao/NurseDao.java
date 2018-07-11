package com.usst.dao;

import com.usst.SessionFactory.SessionBuilder;
import com.usst.mapper.NurseMapper;
import com.usst.pojo.Nurse;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class NurseDao {
    public ArrayList<Nurse> ShowNurse() throws  Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        NurseMapper nurseMapper=session.getMapper(NurseMapper.class);
        return  nurseMapper.ShowNurse();
    }
    public  void UpdateStatus(int id)throws Exception
    {
        SessionBuilder builder= new SessionBuilder();
        SqlSession session=builder.SessionProducer();
        NurseMapper nurseMapper=session.getMapper(NurseMapper.class);
        nurseMapper.UpdateStatus(id);
        session.commit();
    }
}
