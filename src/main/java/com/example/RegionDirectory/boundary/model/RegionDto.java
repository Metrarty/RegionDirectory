package com.example.RegionDirectory.boundary.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegionDto {
    private Long id;
    @NotNull
    private String regionName;
    @NotNull
    private String shortRegionName;
}
