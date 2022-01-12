package com.baggio.innohospital.controller;

import com.baggio.innohospital.dto.AppointmentDto;
import com.baggio.innohospital.service.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    private final ObjectMapper mapper;

    @SneakyThrows
    @PostMapping()
    public AppointmentDto saveAppointment(@RequestBody AppointmentDto appointmentDto){
        log.info(mapper.writeValueAsString(appointmentDto));
        return appointmentService.saveAppointment(appointmentDto);
    }

    @GetMapping("")
    public List<AppointmentDto> getAll(){
        return appointmentService.getAll();
    }

}
