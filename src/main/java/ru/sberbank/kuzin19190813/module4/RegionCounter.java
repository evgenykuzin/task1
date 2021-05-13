package ru.sberbank.kuzin19190813.module4;

import ru.sberbank.kuzin19190813.entities.City;
import ru.sberbank.kuzin19190813.util.Printer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RegionCounter {
    public static List<RegionCountRow> getRegionCountRows(List<City> cities) {
        List<RegionCountRow> regionCountRows = cities.stream()
                .collect(Collectors.groupingBy(City::getRegion))
                .entrySet()
                .stream()
                .map(entry -> new RegionCountRow(entry.getKey(), entry.getValue().size()))
                .collect(Collectors.toList());
        Printer.printCollection(regionCountRows);
        return regionCountRows;
    }

    public static class RegionCountRow {
        private final String region;
        private final Integer count;

        public RegionCountRow(String region, Integer count) {
            this.region = region;
            this.count = count;
        }

        public String getRegion() {
            return region;
        }

        public Integer getCount() {
            return count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RegionCountRow that = (RegionCountRow) o;
            return Objects.equals(region, that.region) && Objects.equals(count, that.count);
        }

        @Override
        public int hashCode() {
            return Objects.hash(region, count);
        }

        @Override
        public String toString() {
            return region + " - " + count;
        }
    }
}
