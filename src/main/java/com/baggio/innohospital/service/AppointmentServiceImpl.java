package com.baggio.innohospital.service;

import com.baggio.innohospital.data.Appointment;
import com.baggio.innohospital.dto.AppointmentDto;
import com.baggio.innohospital.converter.AppointmentMapper;
import com.baggio.innohospital.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository repository;

    private final AppointmentMapper mapper;

    @Override
    public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = repository.save(mapper.toAppointment(appointmentDto));
        return mapper.toAppointmentDto(appointment);
    }

    @Override
    public List<AppointmentDto> getAll() {
        return repository.findAll().stream().map(mapper::toAppointmentDto).collect(Collectors.toList());
    }

}
