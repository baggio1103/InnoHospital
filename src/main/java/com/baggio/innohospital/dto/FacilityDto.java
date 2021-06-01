package com.baggio.innohospital.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDto extends BaseEntityDto{

    private String description;

    private Double price;

    private DoctorDto doctorDto;


}
