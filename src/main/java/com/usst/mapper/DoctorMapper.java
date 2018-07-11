package com.usst.mapper;

import com.usst.pojo.Doctor;

public interface DoctorMapper {
    Doctor SelectByName(String name);
    void InsertAll(String name,String number,String section);
}
