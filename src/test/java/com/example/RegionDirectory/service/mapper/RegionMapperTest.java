package com.example.RegionDirectory.service.mapper;

import com.example.RegionDirectory.boundary.model.RegionDto;
import com.example.RegionDirectory.repository.entity.Region;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegionMapperTest {

    @InjectMocks
    private RegionMapper regionMapper;

    @Test
    public void testToDto() {
        //prepare
        Region region = new Region();
        region.setId(1L);
        region.setRegionName("Moscow");
        region.setShortRegionName("MSC");

        RegionDto expected = new RegionDto();
        expected.setId(region.getId());
        expected.setRegionName(region.getRegionName());
        expected.setShortRegionName(region.getShortRegionName());

        //run
        RegionDto actual = regionMapper.toDto(region);

        //test
        Assert.assertEquals("Must be equals", expected, actual);
    }

    @Test
    public void testToEntity() {
        //prepare
        RegionDto regionDto = new RegionDto();
        regionDto.setId(1L);
        regionDto.setRegionName("Moscow");
        regionDto.setShortRegionName("MSC");

        Region expected = new Region();
        expected.setId(regionDto.getId());
        expected.setRegionName(regionDto.getRegionName());
        expected.setShortRegionName(regionDto.getShortRegionName());

        //run
        Region actual = regionMapper.toEntity(regionDto);

        //test
        Assert.assertEquals("Must be equals", expected, actual);
    }
}
