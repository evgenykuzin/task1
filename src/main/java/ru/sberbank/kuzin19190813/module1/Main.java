package ru.sberbank.kuzin19190813.module1;

import ru.sberbank.kuzin19190813.entities.City;
import ru.sberbank.kuzin19190813.util.Printer;

import java.io.File;
import java.util.List;

import static ru.sberbank.kuzin19190813.module1.Parser.parseCitiesFromFile;
import static ru.sberbank.kuzin19190813.util.FileManager.getFromResources;

public class Main {
    public static void main(String[] args) {
        String fileName = "cities_catalog.txt";
        if (args.length > 0) fileName = args[0];
        File file = getFromResources(fileName);
        List<City> cities = parseCitiesFromFile(file);
        Printer.printCollection(cities);
    }
}
