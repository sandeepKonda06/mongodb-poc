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
        "PartyLegalEntity",
        "Contact"
})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Builder
public class CustomerPartyDTO {
    @JsonProperty("EndpointID")
    private EndpointIDDTO endpointID = EndpointIDDTO.builder().build();
    @JsonProperty("PartyIdentification")
    private CustomerPartyIdentificationDTO partyIdentification = CustomerPartyIdentificationDTO.builder().build();
    @JsonProperty("PartyName")
    private PartyNameDTO partyName = PartyNameDTO.builder().build();
    @JsonProperty("PostalAddress")
    private PostalAddressDTO postalAddress = PostalAddressDTO.builder().build();
    @JsonProperty("PartyTaxScheme")
    private PartyTaxSchemeDTO partyTaxScheme = PartyTaxSchemeDTO.builder().build();
    @JsonProperty("PartyLegalEntity")
    private CustomerPartyLegalEntityDTO partyLegalEntity = CustomerPartyLegalEntityDTO.builder().build();
    @JsonProperty("Contact")
    private ContactDTO contact = ContactDTO.builder().build();
}
