package ru.sberbank.kuzin19190813.module4;

import ru.sberbank.kuzin19190813.entities.City;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static ru.sberbank.kuzin19190813.module1.Parser.parseCitiesFromFile;
import static ru.sberbank.kuzin19190813.util.FileManager.getFromResources;

public class TestModule4 {

    @Test
    public void testRegionCounter() {
        List<RegionCounter.RegionCountRow> expected = List.of(
                new RegionCounter.RegionCountRow("Адыгея", 2),
                new RegionCounter.RegionCountRow("Московская область", 4),
                new RegionCounter.RegionCountRow("Алтай", 1),
                new RegionCounter.RegionCountRow("Челябинская область", 1)
        );
        List<City> cities = parseCitiesFromFile(getFromResources("cities_catalog.txt"));
        List<RegionCounter.RegionCountRow> regionCountRows = RegionCounter.getRegionCountRows(cities);
        Assert.assertEquals(expected, regionCountRows);
    }

}
