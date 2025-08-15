package com.example.medicagent.service;

import com.example.medicagent.entity.Appointment;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AppointmentService extends IService<Appointment> {
     Appointment getOne(Appointment appointment);
}