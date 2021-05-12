package module3;

import module1.City;

import java.util.List;
import java.util.Objects;

public class PopulationFilter {
    public static PopulationRow getMaxPopulationRow(List<City> cities){
        City[] citiesArray = cities.toArray(new City[0]);
        PopulationRow maxPopulationRow = new PopulationRow(0, citiesArray[0].getPopulation());
        for (int i = 0; i < citiesArray.length; i++) {
            Integer population = citiesArray[i].getPopulation();
            PopulationRow nextPopulationRow = new PopulationRow(i, population);
            if (nextPopulationRow.getCount() > maxPopulationRow.getCount()) {
                maxPopulationRow = nextPopulationRow;
            }
        }
        System.out.println(maxPopulationRow);
        return maxPopulationRow;
    }

    public static class PopulationRow {
        private final Integer index, count;

        public PopulationRow(Integer index, Integer count) {
            this.index = index;
            if (count == null) count = 0;
            this.count = count;
        }

        public Integer getIndex() {
            return index;
        }

        public Integer getCount() {
            return count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PopulationRow that = (PopulationRow) o;
            return Objects.equals(index, that.index) && Objects.equals(count, that.count);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, count);
        }

        @Override
        public String toString() {
            return "[" + index + "]=" + count;
        }
    }
}
