package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

@ExtendWith(MockitoExtension.class)
class GeoServiceImplTest {
    @Mock
    GeoServiceImpl mockGeoService;
    Location mockLocation;

    @Test
    void byIp_LOCALHOST() {
        Mockito.when(mockGeoService.byIp("127.0.0.1")).thenReturn(mockLocation = new Location(null, null, null, 0));
        Assertions.assertEquals(mockLocation, mockGeoService.byIp("127.0.0.1"));
    }

    @Test
    void byIp_MOSCOW() {
        Mockito.when(mockGeoService.byIp("172.0.32.11")).thenReturn(mockLocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Assertions.assertEquals(mockLocation, mockGeoService.byIp("172.0.32.11"));
    }

    @Test
    void byIp_NEW_YORK() {
        Mockito.when(mockGeoService.byIp("96.44.183.149")).thenReturn(mockLocation = new Location("New York", Country.USA, "10th Avenue", 32));
        Assertions.assertEquals(mockLocation, mockGeoService.byIp("96.44.183.149"));
    }

    @Test
    void byIp_172() {
        Mockito.when(mockGeoService.byIp("172.")).thenReturn(mockLocation = new Location("Moscow", Country.RUSSIA, null, 0));
        Assertions.assertEquals(mockLocation, mockGeoService.byIp("172."));
    }

    @Test
    void byIp_96() {
        Mockito.when(mockGeoService.byIp("96.")).thenReturn(mockLocation = new Location("New York", Country.USA, null, 0));
        Assertions.assertEquals(mockLocation, mockGeoService.byIp("96."));
    }
}