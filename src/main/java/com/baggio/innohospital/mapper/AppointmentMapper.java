package com.baggio.innohospital.mapper;

import com.baggio.innohospital.data.Appointment;
import com.baggio.innohospital.dto.AppointmentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    Appointment toAppointment(AppointmentDto appointmentDto);

    AppointmentDto toAppointmentDto(Appointment appointment);

}
