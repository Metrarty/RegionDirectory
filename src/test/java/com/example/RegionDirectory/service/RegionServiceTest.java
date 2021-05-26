package com.example.RegionDirectory.service;

import com.example.RegionDirectory.boundary.model.RegionDto;
import com.example.RegionDirectory.repository.RegionRepository;
import com.example.RegionDirectory.repository.entity.Region;
import com.example.RegionDirectory.service.mapper.RegionMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegionServiceTest {

    @InjectMocks
    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @Mock
    private RegionMapper regionMapper;

    @Test
    public void testCreateRegion() {
        //prepare
        RegionDto testRegionDto = new RegionDto();
        Region testRegion = new Region();
        when(regionMapper.toEntity(testRegionDto)).thenReturn(testRegion);

        //run
        regionService.createRegion(testRegionDto);

        //test
        verify(regionRepository, times(1)).insert(testRegion);
        verifyNoMoreInteractions(regionRepository);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateRegion_WhenInputIsNull() {
        regionService.createRegion(null);
    }

    @Test
    public void testFindRegionById() {
        //prepare
        Region region = new Region();
        when(regionRepository.findById(1L)).thenReturn(region);
        RegionDto regionDto = new RegionDto();
        when(regionMapper.toDto(region)).thenReturn(regionDto);

        //test
        regionService.findById(1L);

        //run
        verify(regionRepository, times(1)).findById(1L);
        verify(regionMapper, times(1)).toDto(region);
        verifyNoMoreInteractions(regionRepository, regionMapper);
    }

    @Test
    public void testFindAllCities() {
        //prepare
        Region region = new Region();
        List<Region> regions = Collections.singletonList(region);
        when(regionRepository.findAll()).thenReturn(regions);
        RegionDto dto = new RegionDto();
        dto.setRegionName("Ufa");
        dto.setShortRegionName("U");
        when(regionMapper.toDto(region)).thenReturn(dto);
        RegionDto expectedDto = new RegionDto();
        expectedDto.setRegionName("Ufa");
        expectedDto.setShortRegionName("U");
        //run
        List<RegionDto> actual = regionService.findAllRegions();
        //test
        Assert.assertEquals("Must be equal", 1, actual.size());
        Assert.assertEquals("Must be equal", expectedDto, actual.get(0));
        verify(regionRepository, times(1)).findAll();
        verifyNoMoreInteractions(regionRepository);
    }

    @Test
    public void testEditRegion() {
        //prepare
        RegionDto input = new RegionDto();
        Region region = new Region();
        when(regionMapper.toEntity(input)).thenReturn(region);

        Region foundRegion = new Region();
        foundRegion.setId(1L);
        when(regionRepository.findById(1L)).thenReturn(foundRegion);

        Region saved = new Region();
        saved.setId(1L);
        when(regionRepository.update(foundRegion)).thenReturn(1);

        //run
        regionService.editRegion(input, 1L);

        //test
        verify(regionMapper, times(1)).toEntity(input);
        verify(regionRepository, times(1)).findById(1L);
        verify(regionRepository, times(1)).update(saved);
        verifyNoMoreInteractions(regionRepository, regionMapper);
    }

    @Test(expected = NullPointerException.class)
    public void testEditRegionById_WhenInputIsNull() {
        regionService.editRegion(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testEditRegionById_WhenRegionDtoIsNull() {
        regionService.editRegion(null, 1L);
    }

    @Test(expected = NullPointerException.class)
    public void testEditRegionById_WhenRegionIdIsNull() {
        RegionDto regionDto = new RegionDto();
        regionService.editRegion(regionDto, null);
    }

    @Test
    public void testDeleteRegionById() {
        //run
        regionService.deleteRegionById(1L);

        //test
        verify(regionRepository, times(1)).deleteById(1L);
        verifyNoMoreInteractions(regionRepository);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteRegionById_WhenInputIsNull() {
        regionService.deleteRegionById(null);
    }
}


