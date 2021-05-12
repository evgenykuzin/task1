package module1;

import org.junit.Assert;
import org.junit.Test;
import util.FileUtil;
import util.Printer;

import java.util.List;

public class TestModule1 {

    @Test
    public void testParseCities() {
        List<City> expected = List.of(
                new City("Адыгейск","Адыгея","Южный",144246,1830),
                new City("Майкоп","Адыгея","Южный",233232,1835),
                new City("Алтайск","Алтай","Сибирь",232345,1826),
                new City("Челябинск","Челябинская область","Урал",1231221,1500),
                new City("Химки","Московская область","Центральный",188500,1804),
                new City("Подольск","Московская область","Центральный",183100,1805),
                new City("Королев","Московская область","Центральный",176000,1809),
                new City("Мытищи", "Московская область", "Центральный", 164600, 1820)
        );
        List<City> cities = Main.parseCitiesFromFile(FileUtil.getFileFromResources("cities_catalog.txt"));
        Printer.printCollection(cities);
        Assert.assertEquals(expected, cities);
    }

}
