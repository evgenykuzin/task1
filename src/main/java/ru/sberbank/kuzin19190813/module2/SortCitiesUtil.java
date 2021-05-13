package ru.sberbank.kuzin19190813.module2;

import ru.sberbank.kuzin19190813.entities.City;
import ru.sberbank.kuzin19190813.util.Printer;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SortCitiesUtil {
    public static void sortByName(List<City> cities) {
        Comparator<City> alphabetComparator =
                Comparator.comparing(city -> city.getName().toLowerCase(Locale.ROOT));
        cities.sort(alphabetComparator);
        Printer.printCollection(cities);
    }

    public static void sortByDistrictAndName(List<City> cities) {
        Comparator<City> districtAndNameAlphabetComparator =
                Comparator.comparing(City::getDistrict).thenComparing(City::getName);
        cities.sort(districtAndNameAlphabetComparator);
        Printer.printCollection(cities);
    }

}
