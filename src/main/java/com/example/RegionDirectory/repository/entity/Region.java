package com.example.RegionDirectory.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Region {
    private Long id;
    private String regionName;
    private String shortRegionName;
}
