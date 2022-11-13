package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImplMock;
import ru.netology.i18n.LocalizationServiceImplMock;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class MessageSenderImplTest {
    @Mock
    Location location;
    @Spy
    LocalizationServiceImplMock mockLocalizationService=new LocalizationServiceImplMock();
    MessageSenderImpl messageSender;
    GeoServiceImplMock mockGeoService=new GeoServiceImplMock();
    Map<String, String> headers = new HashMap<String, String>();

    @Test
    void send_ru_moscow() {
        mockLocalizationService.setValue("Добро пожаловать");
        messageSender = new MessageSenderImpl(mockGeoService, mockLocalizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String receiver=messageSender.send(headers);
        Assertions.assertEquals("Добро пожаловать",receiver);
    }
    @Test
    void send_ru(){
        mockLocalizationService.setValue("Добро пожаловать");
        messageSender = new MessageSenderImpl(mockGeoService, mockLocalizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");
        String receiver=messageSender.send(headers);
        Assertions.assertEquals("Добро пожаловать",receiver);
    }
    @Test
    void send_us_newYork(){
        mockLocalizationService.setValue("Welcome");
        messageSender = new MessageSenderImpl(mockGeoService, mockLocalizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String receiver=messageSender.send(headers);
        Assertions.assertEquals("Welcome",receiver);
    }
    @Test
    void send_us(){
        mockLocalizationService.setValue("Welcome");
        messageSender = new MessageSenderImpl(mockGeoService, mockLocalizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");
        String receiver=messageSender.send(headers);
        Assertions.assertEquals("Welcome",receiver);
    }

}

