package com.baggio.innohospital.service;

import com.baggio.innohospital.data.Appointment;
import com.baggio.innohospital.dto.AppointmentDto;
import com.baggio.innohospital.converter.AppointmentMapper;
import com.baggio.innohospital.repository.AppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository repository;

    private final AppointmentMapper mapper;

    private final ObjectMapper objectMapper;

    @Override
    public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = repository.save(mapper.toAppointment(appointmentDto));
        return mapper.toAppointmentDto(appointment);
    }

    @SneakyThrows
    @Override
    public List<AppointmentDto> getAll() {
        List<Appointment> appointments = repository.findAll();
        log.info(objectMapper.writeValueAsString(appointments));
        List<AppointmentDto> responseList = appointments.stream().map(mapper::toAppointmentDto).collect(Collectors.toList());
        log.info(objectMapper.writeValueAsString(responseList));
        return repository.findAll().stream().map(mapper::toAppointmentDto).collect(Collectors.toList());
    }

}
