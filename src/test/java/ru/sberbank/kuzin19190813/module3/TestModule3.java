package ru.sberbank.kuzin19190813.module3;

import ru.sberbank.kuzin19190813.entities.City;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static ru.sberbank.kuzin19190813.module1.Parser.parseCitiesFromFile;
import static ru.sberbank.kuzin19190813.util.FileManager.getFromResources;

public class TestModule3 {

    @Test
    public void testPopulationFilter() {
        List<City> cities = parseCitiesFromFile(getFromResources("cities_catalog.txt"));
        PopulationFilter.PopulationRow populationRow = PopulationFilter.getMaxPopulationRow(cities);
        PopulationFilter.PopulationRow expected = new PopulationFilter.PopulationRow(3, 1231221);
        Assert.assertEquals(expected, populationRow);
    }

}
