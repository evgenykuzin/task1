package module4;

import module1.City;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RegionCounter {
    public static List<RegionCountRow> getRegionCountRows(List<City> cities) {
        return cities.stream()
                .collect(Collectors.groupingBy(City::getRegion))
                .entrySet()
                .stream()
                .map(entry -> new RegionCountRow(entry.getKey(), entry.getValue().size()))
                .collect(Collectors.toList());
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
