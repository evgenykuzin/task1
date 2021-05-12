package module1;

import util.FileUtil;
import util.Printer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String MOCK = "null";

    public static void main(String[] args) {
        String fileName = "cities_catalog.txt";
        if (args.length > 0) fileName = args[0];
        File file = FileUtil.getFileFromResources(fileName);
        List<City> cities = parseCitiesFromFile(file);
        Printer.printCollection(cities);
    }

    public static List<City> parseCities(InputStream is) {
        List<City> cities = new ArrayList<>();
        Scanner scanner = new Scanner(is);
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            if (nextLine.lastIndexOf(";") == nextLine.length() - 1) {
                nextLine += MOCK;
            }
            String[] fields = nextLine.split(";");
            City city = new City();
            city.setName(fields[1]);
            city.setRegion(fields[2]);
            city.setDistrict(fields[3]);
            String populationString = fields[4];
            Integer population = parseInt(populationString);
            city.setPopulation(population);
            String foundationString = fields[5];
            Integer foundation = parseInt(foundationString);
            city.setFoundation(foundation);
            cities.add(city);
        }
        return cities;
    }

    private static Integer parseInt(String string) {
        return string.isEmpty() || string.equals(MOCK) ? null : Integer.parseInt(string);
    }

    public static List<City> parseCitiesFromFile(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            return parseCities(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
