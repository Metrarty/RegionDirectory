package com.example.RegionDirectory.repository;

import com.example.RegionDirectory.repository.entity.Region;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegionRepository {

    @Insert("INSERT INTO REGION(id, region_name, short_region_name) VALUES (#{id}, #{regionName}, #{shortRegionName})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Region region);

    @Delete("DELETE FROM region WHERE id = #{id}")
    int deleteById(long id);

    @Update("UPDATE region SET region_name=#{regionName}, short_region_name=#{shortRegionName} where id=#{id}")
    int update(Region region);

    @Select("SELECT * FROM region WHERE id = #{id}")
    Region findById(long id);

    @Select("select * from region")
    List<Region> findAll();
}
