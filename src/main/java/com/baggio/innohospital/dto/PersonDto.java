package com.baggio.innohospital.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public abstract class PersonDto extends BaseEntityDto{

    private String name;

    private String email;

    private LocalDate dob;

}
