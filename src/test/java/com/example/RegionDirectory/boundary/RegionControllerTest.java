package com.example.RegionDirectory.boundary;

import com.example.RegionDirectory.boundary.model.RegionDto;
import com.example.RegionDirectory.service.RegionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegionControllerTest {

    @InjectMocks
    private RegionController regionController;

    @Mock
    private RegionService regionService;

    @Test
    public void testCreateRegion() {
        RegionDto regionDto = new RegionDto();
        regionController.create(regionDto);
        verify(regionService, times(1)).createRegion(regionDto);
        verifyNoMoreInteractions(regionService);
    }

    @Test
    public void testFindOne() {
        regionController.findOne(1L);
        verify(regionService, times(1)).findById(1L);
        verifyNoMoreInteractions(regionService);
    }

    @Test
    public void testFindAllRegions() {
        regionController.findAll();
        verify(regionService, times(1)).findAllRegions();
        verifyNoMoreInteractions(regionService);
    }

    @Test
    public void testEditRegion() {
        RegionDto regionDto = new RegionDto();
        regionController.editRegion(regionDto, 1L);
        verify(regionService, times(1)).editRegion(regionDto, 1L);
        verifyNoMoreInteractions(regionService);
    }

    @Test
    public void testDeleteRegionById() {
        regionController.deleteById(1L);
        verify(regionService, times(1)).deleteRegionById(1L);
        verifyNoMoreInteractions(regionService);
    }
}
