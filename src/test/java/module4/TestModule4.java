package module4;

import module1.City;
import module1.Main;
import org.junit.Assert;
import org.junit.Test;
import util.FileUtil;

import java.util.List;

public class TestModule4 {

    @Test
    public void testRegionCounter() {
        List<RegionCounter.RegionCountRow> expected = List.of(
                new RegionCounter.RegionCountRow("Адыгея", 2),
                new RegionCounter.RegionCountRow("Московская область", 4),
                new RegionCounter.RegionCountRow("Алтай", 1),
                new RegionCounter.RegionCountRow("Челябинская область", 1)
        );
        List<City> cities = Main.parseCitiesFromFile(FileUtil.getFileFromResources("cities_catalog.txt"));
        List<RegionCounter.RegionCountRow> regionCountRows = RegionCounter.getRegionCountRows(cities);
        Assert.assertEquals(expected, regionCountRows);
    }

}
