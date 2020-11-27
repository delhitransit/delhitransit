/*
 * @author Ankit Varshney
 */

package com.delhitransit.core.service;

import com.delhitransit.core.EntityGenerator.StopEntityGenerator;
import com.delhitransit.core.GeoLocationHelper;
import com.delhitransit.core.model.entity.StopEntity;
import com.delhitransit.core.repository.StopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;
import java.util.List;

import static com.delhitransit.core.api.controller.DelhiTransitController.DEFAULT_PAGE_REQUEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class StopServiceTest {

    private final StopEntity stopEntity = StopEntityGenerator.generate();

    private StopService stopService;

    @BeforeEach
    void setup() {
        StopRepository mockStopRepository = mock(StopRepository.class);

        Page<StopEntity> listOfStopEntity = new PageImpl<>(Collections.singletonList(stopEntity));

        Mockito.when(mockStopRepository.findAllByNameContainsIgnoreCase(stopEntity.getName(), DEFAULT_PAGE_REQUEST ))
               .thenReturn(listOfStopEntity);
        Mockito.when(mockStopRepository.findAllByNameIgnoreCase(stopEntity.getName(), DEFAULT_PAGE_REQUEST ))
               .thenReturn(listOfStopEntity);

        GeoLocationHelper location = GeoLocationHelper.fromDegrees(stopEntity.getLatitude(), stopEntity.getLongitude());
        GeoLocationHelper[] coordinates = location.boundingCoordinates(1L, null);
        Mockito.when(mockStopRepository.findAllByLatitudeBetweenAndLongitudeBetween(
                coordinates[0].getLatitudeInDegrees(),
                coordinates[1].getLatitudeInDegrees(),
                coordinates[0].getLongitudeInDegrees(),
                coordinates[1].getLongitudeInDegrees(),
                DEFAULT_PAGE_REQUEST
        )).thenReturn(listOfStopEntity);

        stopService = new StopService(mockStopRepository);
    }

    @Test
    void findAllByExactNameTest() {
        Page<StopEntity> stopEntities = stopService.getStopsByNameIgnoreCase(stopEntity.getName(), DEFAULT_PAGE_REQUEST);
        assertEntityIdenticalToStopEntity(stopEntities);
    }

    @Test
    void findAllByNameSubsequenceTest() {
        Page<StopEntity> stopEntities = stopService.getStopsByNameContainsIgnoreCase(stopEntity.getName(), DEFAULT_PAGE_REQUEST);
        assertEntityIdenticalToStopEntity(stopEntities);
    }

    @Test
    void findAllByLatitudeBetweenAndLongitudeBetweenTest() {
        Page<StopEntity> stopEntities = stopService.getStopsNearLocation(
                stopEntity.getLatitude(), stopEntity.getLongitude(), null,DEFAULT_PAGE_REQUEST);
        assertEntityIdenticalToStopEntity(stopEntities);
    }

    void assertEntityIdenticalToStopEntity(Page<StopEntity> page) {
        assertNotNull(page);
        List<StopEntity> stopEntities = page.toList();
        assertNotNull(stopEntities);
        assertEquals(1, stopEntities.size());
        assertEquals(stopEntity, stopEntities.get(0));
    }

}
