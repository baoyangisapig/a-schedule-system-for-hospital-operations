package com.usst.mapper;

import com.usst.pojo.Count;

public interface CountMapper {
 Count SelectBy(String username,String password);
 void InsertAll(int p_id,String status,String username,String password);
}
