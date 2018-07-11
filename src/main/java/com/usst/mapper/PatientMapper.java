package com.usst.mapper;

import com.usst.pojo.Patient;

public interface PatientMapper {
    Patient SelectById(int id);
    void InsertAll(String name,String number,String section);
    Patient SelectByName(String name);
}
