package com.example.RegionDirectory.boundary;


import com.example.RegionDirectory.boundary.model.RegionDto;
import com.example.RegionDirectory.repository.RegionRepository;
import com.example.RegionDirectory.repository.entity.Region;
import com.example.RegionDirectory.service.RegionService;
import com.example.RegionDirectory.service.mapper.RegionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Log4j2
public class RegionController {

    private final RegionService regionService;
    private final RegionRepository regionRepository;

    @RequestMapping("/region/findbyid/{id}/")
    public Region findOne(@PathVariable Long id) {
        return regionRepository.findById(id);
    }

    @RequestMapping("/region/create/")
    public Region create(@RequestBody Region region) {
        return regionRepository.insert(region);
    }

}
