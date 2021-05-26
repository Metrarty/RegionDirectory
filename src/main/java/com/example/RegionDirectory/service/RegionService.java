package com.example.RegionDirectory.service;

import com.example.RegionDirectory.boundary.model.RegionDto;
import com.example.RegionDirectory.repository.RegionRepository;
import com.example.RegionDirectory.repository.entity.Region;
import com.example.RegionDirectory.service.mapper.RegionMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Region service.
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Log4j2
public class RegionService {

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    /**
     * Creates city and saved into repository.
     * @param regionDto regions DTO
     */
    @Transactional
    public void createRegion(@NonNull RegionDto regionDto) {
        log.info("RegionService.createRegion was called with {}", regionDto);
        Region entity = regionMapper.toEntity(regionDto);
        regionRepository.insert(entity);
    }

    /**
     * Finds region by ID.
     * @param id region ID
     * @return region DTO
     */
    public RegionDto findById(Long id) {
        log.info("RegionService.findById was called");
        Region entity = regionRepository.findById(id);
        return regionMapper.toDto(entity);
    }

    /**
     * Finds all exist regions.
     * @return list of regions DTO
     */
    public List<RegionDto> findAllRegions() {
        log.info("RegionService.findAllRegions was called");
        List<Region> entities = regionRepository.findAll();
        List<RegionDto> result = new ArrayList<>();
        for (Region region : entities) {
            RegionDto regionDto = regionMapper.toDto(region);
            result.add(regionDto);
        }
        return result;
    }

    /**
     * Edits region, selected by ID
     * @param regionDto region DTO
     * @param id ID of found region
     * @return amount of edited regions DTO
     */
    @Transactional
    public int editRegion(@NonNull RegionDto regionDto, @NonNull Long id) {
        log.info("RegionService.editRegion was called with {}{}", regionDto, id);
        Region editedRegion = regionMapper.toEntity(regionDto);
        Region originalRegion = regionRepository.findById(id);
        editedRegion.setId(originalRegion.getId());
        return regionRepository.update(editedRegion);
    }

    /**
     * Deletes city, selected by ID.
     * @param id region ID
     * @return amount of deleted regions
     */
    @Transactional
    public int deleteRegionById(@NonNull Long id) {
        log.info("RegionService.deleteRegionById was called with {}", id);
        return regionRepository.deleteById(id);
    }
}
