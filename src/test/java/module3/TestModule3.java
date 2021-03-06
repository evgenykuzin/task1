package module3;

import module1.City;
import module1.Main;
import org.junit.Assert;
import org.junit.Test;
import util.FileUtil;

import java.util.List;

public class TestModule3 {

    @Test
    public void testPopulationFilter() {
        List<City> cities = Main.parseCitiesFromFile(FileUtil.getFileFromResources("cities_catalog.txt"));
        PopulationFilter.PopulationRow populationRow = PopulationFilter.getMaxPopulationRow(cities);
        PopulationFilter.PopulationRow expected = new PopulationFilter.PopulationRow(3, 1231221);
        Assert.assertEquals(expected, populationRow);
    }

}
