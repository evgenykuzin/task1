package module3;

import module1.City;
import module1.Main;
import module1.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestModule3 {

    @Test
    public void testParseCities() {
        List<City> cities = Main.parseCitiesFromFile(Util.getFileFromResources("cities_catalog.txt"));
        PopulationFilter.PopulationRow populationRow = PopulationFilter.getMaxPopulationRow(cities);
        PopulationFilter.PopulationRow expected = new PopulationFilter.PopulationRow(1, 233232);
        Assert.assertEquals(expected, populationRow);
    }

}
