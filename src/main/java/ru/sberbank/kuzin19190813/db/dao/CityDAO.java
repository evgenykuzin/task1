package ru.sberbank.kuzin19190813.db.dao;

import ru.sberbank.kuzin19190813.entities.City;

import java.util.List;

public class CityDAO extends AbstractDAO<City, Long> {
    public CityDAO() {
        super(City.class);
    }

    public static CityDAO getInstance() {
        return CityDAOHolder.CITY_DAO;
    }

    private static class CityDAOHolder {
        public static CityDAO CITY_DAO = new CityDAO();
    }

    public List<City> search(String by, String value) {
        return super.search("City", by, value);
    }
}
