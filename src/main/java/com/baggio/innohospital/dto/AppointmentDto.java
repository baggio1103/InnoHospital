package com.baggio.innohospital.dto;

import com.baggio.innohospital.config.TimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto extends BaseEntityDto{

    private String patientId;

    @JsonFormat(pattern = TimeFormat.DATE_TIME_ISO_EXTENDED_WITH_OFFSET_FORMAT)
    private String appointmentDate;

    @JsonFormat(pattern = TimeFormat.DATE_TIME_ISO_EXTENDED_WITH_OFFSET_FORMAT)
    private String timeZone;

}
