package module2;

import module1.City;
import module1.Main;
import org.junit.Assert;
import org.junit.Test;
import util.FileUtil;

import java.util.List;
import java.util.function.Consumer;

public class TestModule2 {

    @Test
    public void testSortCities() {
        List<City> expected1 = List.of(
                new City("Адыгейск","Адыгея","Южный",144246,1830),
                new City("Алтайск","Алтай","Сибирь",232345,1826),
                new City("Королев","Московская область","Центральный",176000,1809),
                new City("Майкоп","Адыгея","Южный",233232,1835),
                new City("Мытищи", "Московская область", "Центральный", 164600, 1820),
                new City("Подольск","Московская область","Центральный",183100,1805),
                new City("Химки","Московская область","Центральный",188500,1804),
                new City("Челябинск","Челябинская область","Урал",1231221,1500)
        );
        List<City> expected2 = List.of(
                new City("Алтайск","Алтай","Сибирь",232345,1826),
                new City("Челябинск","Челябинская область","Урал",1231221,1500),
                new City("Королев","Московская область","Центральный",176000,1809),
                new City("Мытищи", "Московская область", "Центральный", 164600, 1820),
                new City("Подольск","Московская область","Центральный",183100,1805),
                new City("Химки","Московская область","Центральный",188500,1804),
                new City("Адыгейск","Адыгея","Южный",144246,1830),
                new City("Майкоп","Адыгея","Южный",233232,1835)
        );
        testSort(expected1, SortCitiesUtil::sortByName);
        System.out.println("\n");
        testSort(expected2, SortCitiesUtil::sortByDistrictAndName);
    }

    private static void testSort(List<City> expected, Consumer<List<City>> sortConsumer) {
        List<City> cities = getCities();
        sortConsumer.accept(cities);
        Assert.assertEquals(expected, cities);
    }

    private static List<City> getCities() {
        return Main.parseCitiesFromFile(FileUtil.getFileFromResources("cities_catalog.txt"));
    }

}
