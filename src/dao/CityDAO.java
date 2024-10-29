package dao;

import entities.City;

public class CityDAO extends GeneralDAO<City> {
    public CityDAO() {
        super(City.class, "src/resources/cities.csv");
    }
}