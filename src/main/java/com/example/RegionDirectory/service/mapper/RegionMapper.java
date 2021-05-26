package com.example.RegionDirectory.service.mapper;


import com.example.RegionDirectory.repository.entity.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionMapper {
    public void insert(Region region);

    public void delete(Long id);

    public void update(Region region);

    public Region getById(Long id);

    public List<Region> list();
}
