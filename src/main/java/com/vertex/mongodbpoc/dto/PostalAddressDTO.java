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
@JsonPropertyOrder({
        "EndpointID",
        "PartyIdentification",
        "PartyName",
        "PostalAddress",
        "PartyTaxScheme",
        "PartyLegalEntity"
})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Builder
public class PostalAddressDTO {
    @JsonProperty("StreetName")
    private String streetName;
    @JsonProperty("AdditionalStreetName")
    private String additionalStreetName;
    @JsonProperty("CityName")
    private String cityName;
    @JsonProperty("PostalZone")
    private String postalZone;
    @JsonProperty("Country")
    private CountryDTO country = CountryDTO.builder().build();
}
