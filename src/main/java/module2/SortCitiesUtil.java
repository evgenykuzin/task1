package module2;

import module1.City;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SortCitiesUtil {
    public static void sortByName(List<City> cities) {
        Comparator<City> alphabetComparator =
                Comparator.comparing(city -> city.getName().toLowerCase(Locale.ROOT));
        cities.sort(alphabetComparator);
    }

    public static void sortByDistrictAndName(List<City> cities) {
        Comparator<City> districtAndNameAlphabetComparator =
                Comparator.comparing(City::getDistrict).thenComparing(City::getName);
        cities.sort(districtAndNameAlphabetComparator);
    }

}
