package com.example.RegionDirectory.service;

import com.example.RegionDirectory.boundary.model.RegionDto;
import com.example.RegionDirectory.repository.RegionRepository;
import com.example.RegionDirectory.repository.entity.Region;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Log4j2
public class RegionService {



    public RegionDto createRegion(RegionDto regionDto) {
        log.info("RegionService.createRegion was called with {}", regionDto);

        return null;
    }

    public List<RegionDto> findAllRegions() {
        return null;
    }

    public RegionDto editRegion(RegionDto regionDto, Long id) {
        return null;
    }

    public void deleteRegionById(Long id) {

    }
}
