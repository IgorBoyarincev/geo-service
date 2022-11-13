package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;

@ExtendWith(MockitoExtension.class)
class LocalizationServiceImplTest {
    @Mock
    LocalizationServiceImpl mockLocalizationService;
    Country country;

    @Test
    void local_ru() {
        Mockito.when(mockLocalizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        Assertions.assertEquals("Добро пожаловать", mockLocalizationService.locale(Country.RUSSIA));
    }

    @Test
    void local_usa() {
        Mockito.when(mockLocalizationService.locale(Country.USA)).thenReturn("Welcome");
        Assertions.assertEquals("Welcome", mockLocalizationService.locale(Country.USA));
    }

    @Test
    void local_germany() {
        Mockito.when(mockLocalizationService.locale(Country.GERMANY)).thenReturn("Welcome");
        Assertions.assertEquals("Welcome", mockLocalizationService.locale(Country.GERMANY));
    }

    @Test
    void locale_brazil() {
        Mockito.when(mockLocalizationService.locale(Country.BRAZIL)).thenReturn("Welcome");
        Assertions.assertEquals("Welcome", mockLocalizationService.locale(Country.BRAZIL));
    }

    void setUp() {
    }
}