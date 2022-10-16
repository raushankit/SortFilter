package com.raushankit.sortFilter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CountryDto {

    private Long id;

    private String commonName;

    private String officialName;

    @Column(name = "regions")
    private String region;

    private String subregion;

    private Double area;

    private Long population;

    private String fifa;

    private String startOfWeek;
}
