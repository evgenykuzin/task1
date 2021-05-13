package ru.sberbank.kuzin19190813.crud;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.kuzin19190813.db.HibernateUtil;
import ru.sberbank.kuzin19190813.db.dao.CityDAO;
import ru.sberbank.kuzin19190813.entities.City;
import ru.sberbank.kuzin19190813.module1.Parser;
import ru.sberbank.kuzin19190813.util.FileManager;

import java.util.List;

public class DbTest {
    private CityDAO cityDAO;

    @BeforeEach
    public void initDAO() {
        cityDAO = CityDAO.getInstance();
    }

    public static List<City> getCities() {
        return Parser.parseCitiesFromFile(FileManager.getFromResources("cities_catalog.txt"));
    }

    @Test
    public void testConnection() {
        Assertions.assertTrue(HibernateUtil.getSessionFactory().isOpen());
    }

    @Test
    public void testCreateAndGet() {
        List<City> cities = getCities();
        cityDAO.saveAll(cities);
        List<City> citiesFromDB = cityDAO.getAll();
        Assertions.assertTrue(cities.size() != 0);
        Assertions.assertTrue(citiesFromDB.size() != 0);
        Assertions.assertEquals(cities, citiesFromDB);
    }

    @Test
    public void testCreateAndUpdate() {
        List<City> cities = getCities();
        cityDAO.saveAll(cities);
        City city = cityDAO.get(1L);
        Integer expectedFoundation = 123456;
        city.setFoundation(expectedFoundation);
        cityDAO.update(city);
        City updatedCity = cityDAO.get(1L);
        Assertions.assertEquals(expectedFoundation, updatedCity.getFoundation());
    }

    @Test
    public void testCreateAndDelete() {
        List<City> cities = getCities();
        cityDAO.saveAll(cities);
        City city = cityDAO.get(1L);
        cityDAO.delete(city);
        City updatedCity = cityDAO.get(1L);
        Assertions.assertNull(updatedCity);
    }

    @Test
    public void testCreateAndSearch() {
        List<City> cities = getCities();
        String expectedName = "Челябинск";
        City expectedCity = cities.stream().filter(city -> city.getName().equals(expectedName)).findFirst().orElse(null);
        Assertions.assertNotNull(expectedCity);
        cityDAO.saveAll(cities);
        List<City> searchResult = cityDAO.search("name", expectedName);
        Assertions.assertEquals(1, searchResult.size());
        Assertions.assertEquals(expectedCity, searchResult.get(0));
    }
}
