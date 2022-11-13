package ru.netology.geo;

import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplMock implements GeoService {
    private Location value;

    @Override
    public Location byIp(String ip) {
        return new Location("Moscow", Country.RUSSIA, "Lenina", 15);
    }

    public void setValue(Location value) {
        this.value = value;
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        throw new RuntimeException("not implemented");
    }
}
