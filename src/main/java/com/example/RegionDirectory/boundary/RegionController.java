package com.example.RegionDirectory.boundary;


import com.example.RegionDirectory.boundary.model.RegionDto;
import com.example.RegionDirectory.repository.RegionRepository;
import com.example.RegionDirectory.repository.entity.Region;
import com.example.RegionDirectory.service.RegionService;
import com.example.RegionDirectory.service.mapper.RegionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Region controller.
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Log4j2
public class RegionController {

    private final RegionService regionService;

    /**
     * Creates new region.
     * @param regionDto region DTO
     * @return HttpStatus CREATED
     */
    @PostMapping("/region/create/")
    public ResponseEntity<Void> create(@Valid @RequestBody RegionDto regionDto) {
        log.info("RegionController.create was called with {}", regionDto);
        regionService.createRegion(regionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Receives all regions DTO.
     * @return List of all regions DTO
     */
    @GetMapping("/region/findall/")
    public ResponseEntity<List<RegionDto>> findAll() {
        log.info("RegionController.findALl was called");
        List<RegionDto> result = regionService.findAllRegions();
        return ResponseEntity.ok(result);
    }

    /**
     * Receives one region, selected by ID.
     * @param id region ID
     * @return region DTO, select by ID
     */
    @Cacheable(value = "regions")
    @GetMapping("/region/findbyid/{id}/")
    public ResponseEntity<RegionDto> findOne(@PathVariable Long id) {
        log.info("RegionController.findOne was called with {}", id);
        RegionDto result = regionService.findById(id);
        return ResponseEntity.ok(result);
    }

    /**
     * Edits exist region DTO, selected dy ID.
     * @param regionDto region DTO
     * @param id region DTO id
     * @return amount of edited regions DTO
     */
    @CacheEvict(value="regions", key = "#root.args[1]")
    @PutMapping("/region/editbyid/{id}/")
    public ResponseEntity<Integer> editRegion(@Valid @RequestBody RegionDto regionDto, @PathVariable Long id) {
        log.info("RegionController.editRegion was called with {}{}", regionDto, id);
       int result = regionService.editRegion(regionDto, id);
       return ResponseEntity.ok(result);
    }

    /**
     * Deletes exist region, selected by ID.
     * @param id region ID
     * @return amount of deleted regions
     */
    @CacheEvict(value="regions")
    @DeleteMapping("/region/deletebyid/{id}/")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id) {
        log.info("RegionController.deleteById was called with {}", id);
        int result = regionService.deleteRegionById(id);
        return ResponseEntity.ok(result);
    }
}
