package com.example.RegionDirectory.repository.entity;

public class Region {
    private Long id;
    private String regionName;
    private String shortRegionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getShortRegionName() {
        return shortRegionName;
    }

    public void setShortRegionName(String shortRegionName) {
        this.shortRegionName = shortRegionName;
    }

}
