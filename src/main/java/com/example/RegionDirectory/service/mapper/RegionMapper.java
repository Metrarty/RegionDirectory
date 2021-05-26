package com.example.RegionDirectory.service.mapper;

import com.example.RegionDirectory.boundary.model.RegionDto;
import com.example.RegionDirectory.repository.entity.Region;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * Region mapper.
 */
@Component
@Log4j2
public class RegionMapper {

    /**
     * Transfer data from region to region DTO.
     * @param region region
     * @return region DTO
     */
    public RegionDto toDto(@NonNull Region region) {
        log.info("RegionMapper.toDto was called with {}", region);
        RegionDto entity = new RegionDto();
        entity.setId(region.getId());
        entity.setRegionName(region.getRegionName());
        entity.setShortRegionName(region.getShortRegionName());
        return entity;
    }

    /**
     * Transfer data from region DTO to region.
     * @param regionDto region DTO
     * @return region
     */
    public Region toEntity(RegionDto regionDto) {
        log.info("RegionMapper.toEntity was called with {}", regionDto);
        Region entity = new Region();
        entity.setId(regionDto.getId());
        entity.setRegionName(regionDto.getRegionName());
        entity.setShortRegionName(regionDto.getShortRegionName());
        return entity;
    }
}
