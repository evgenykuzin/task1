package module1;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestModule1 {

    @Test
    public void testParseCities() {
        List<City> expected = List.of(
                new City("Адыгейск","Адыгея","Южный",144246,1830),
                new City("Майкоп","Адыгея","Южный",233232,1835),
                new City("Алтайск","Алтай","Сибирь",232345,1826),
                new City("Челябинск","Челябинская область","Урал",1231221,1500)
        );
        List<City> cities = Main.parseCitiesFromFile(Util.getFileFromResources("cities_catalog.txt"));
        Assert.assertEquals(expected, cities);
    }

}
