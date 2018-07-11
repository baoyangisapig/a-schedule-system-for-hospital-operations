package com.usst.dao;

import com.usst.SessionFactory.SessionBuilder;
import com.usst.mapper.CountMapper;
import com.usst.pojo.Count;
import org.apache.ibatis.session.SqlSession;

public class CountDao {
   public Count SelectBy(String username,String password) throws Exception
   {
       SessionBuilder builder= new SessionBuilder();
       SqlSession session=builder.SessionProducer();
       CountMapper countMapper=session.getMapper(CountMapper.class);
       return countMapper.SelectBy(username,password);
   }
   public void InsertAll(int p_id,String status,String username,String password)throws  Exception
   {
       SessionBuilder builder= new SessionBuilder();
       SqlSession session=builder.SessionProducer();
       CountMapper countMapper=session.getMapper(CountMapper.class);
       countMapper.InsertAll(p_id,status,username,password);
       session.commit();
   }
}
