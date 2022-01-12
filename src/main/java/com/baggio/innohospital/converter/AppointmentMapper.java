package com.baggio.innohospital.converter;

import com.baggio.innohospital.config.TimeFormat;
import com.baggio.innohospital.data.Appointment;
import com.baggio.innohospital.dto.AppointmentDto;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AppointmentMapper {

    public Appointment toAppointment(AppointmentDto appointmentDto) {
        if (appointmentDto == null) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setId(appointmentDto.getId());
        appointment.setPatientId(appointmentDto.getPatientId());
        appointment.setAppointmentDate(ZonedDateTime.parse(appointmentDto.getAppointmentDate(), DateTimeFormatter.ofPattern(TimeFormat.DATE_TIME_ISO_EXTENDED_WITH_OFFSET_FORMAT)));
        appointment.setTimeZone(ZonedDateTime.parse(appointmentDto.getTimeZone(), DateTimeFormatter.ofPattern(TimeFormat.DATE_TIME_ISO_EXTENDED_WITH_OFFSET_FORMAT)));

        return appointment;
    }

    public AppointmentDto toAppointmentDto(Appointment appointment) {
        if (appointment == null) {
            return null;
        }

        AppointmentDto appointmentDto = new AppointmentDto();

        appointmentDto.setId(appointment.getId());
        appointmentDto.setPatientId(appointment.getPatientId());
        appointmentDto.setAppointmentDate(appointment.getAppointmentDate().toString());
        appointmentDto.setTimeZone(appointment.getTimeZone().toString());

        return appointmentDto;
    }

}
