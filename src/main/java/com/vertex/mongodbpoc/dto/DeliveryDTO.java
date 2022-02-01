package com.vertex.mongodbpoc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ActualDeliveryDate", "DeliveryLocation", "DeliveryParty"})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Builder
public class DeliveryDTO {
    @JsonProperty("ActualDeliveryDate")
    private String actualDeliveryDate;
    @JsonProperty("DeliveryLocation")
    private DeliveryLocationDTO deliveryLocation = DeliveryLocationDTO.builder().build();
    @JsonProperty("DeliveryParty")
    private DeliveryPartyDTO deliveryParty = DeliveryPartyDTO.builder().build();
}
