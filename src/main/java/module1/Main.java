package module1;

import module2.SortCitiesUtil;
import util.Printer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "cities_catalog_for_sort.txt";
        if (args.length > 0) fileName = args[0];
        File file = Util.getFileFromResources(fileName);
        List<City> cities = parseCitiesFromFile(file);
        SortCitiesUtil.sortByName(cities);
        Printer.printCollection(cities);

    }

    public static List<City> parseCities(InputStream is) {
        List<City> cities = new ArrayList<>();
        Scanner scanner = new Scanner(is);
        while (scanner.hasNext()) {
            var nextLine = scanner.nextLine();
            String mock = "null";
            if (nextLine.lastIndexOf(";") == nextLine.length() - 1) {
                nextLine += mock;
            }
            var fields = nextLine.split(";");
            City city = new City();
            city.setName(fields[1]);
            city.setRegion(fields[2]);
            city.setDistrict(fields[3]);
            city.setPopulation(fields[4]);
            city.setFoundation(fields[5]);
            if (city.getFoundation().equals(mock)) city.setFoundation("");
            cities.add(city);
        }

        return cities;
    }

    public static List<City> parseCitiesFromFile(File file) {
        try (var fis = new FileInputStream(file)) {
            return parseCities(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
