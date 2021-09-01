package com.baggio.innohospital.mapper;

import com.baggio.innohospital.data.Fulfillment;
import com.baggio.innohospital.dto.FulfillmentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FulfillmentMapper {

    Fulfillment toFulfillment(FulfillmentDto fulfillmentDto);

    FulfillmentDto toFulfillmentDto(Fulfillment fulfillment);

}
