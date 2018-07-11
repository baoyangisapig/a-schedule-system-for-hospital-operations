package com.usst.mapper;

import com.usst.pojo.Nurse;

import java.util.ArrayList;

public interface NurseMapper {
    ArrayList<Nurse> ShowNurse();
    void UpdateStatus(int id);
}
