package com.example.RegionDirectory.repository;

import com.example.RegionDirectory.repository.entity.Region;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegionRepository {

    @Insert("INSERT INTO REGION(id, region_name, short_region_name) VALUES (#{id}, #{region_name}, #{short_region_name})")
    public Region insert(Region region);

    @Delete("DELETE FROM region WHERE id = #{id}")
    public Long deleteById(long id);

    @Update("UPDATE region SET region_name=#{region_name}, short_region_name=#{short_region_name} where id=#{id}")
    public Long update(Region region);

    @Select("SELECT * FROM region WHERE id = #{id}")
    public Region findById(long id);

    @Select("select * from region")
    public List<Region> findAll();
}
