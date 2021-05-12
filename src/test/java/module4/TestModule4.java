package module4;

import module1.City;
import module1.Main;
import module1.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class TestModule4 {

    @Test
    public void testParseCities() {
        List<RegionCounter.RegionCountRow> expected = List.of(
                new RegionCounter.RegionCountRow("Адыгея", 2),
                new RegionCounter.RegionCountRow("Московская область", 4),
                new RegionCounter.RegionCountRow("Алтай", 1),
                new RegionCounter.RegionCountRow("Челябинская область", 1)
        );
        List<City> cities = Main.parseCitiesFromFile(Util.getFileFromResources("cities_catalog_for_region_count.txt"));
        List<RegionCounter.RegionCountRow> regionCountRows = RegionCounter.getRegionCountRows(cities);
        Assert.assertEquals(expected, regionCountRows);
    }

}
