package com.baggio.innohospital.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FulfillmentDto {

    private String name;

    private Integer sort;

    private String tenantId;

}
