package com.baggio.innohospital.service;

import com.baggio.innohospital.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {

    AppointmentDto saveAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> getAll();

}
