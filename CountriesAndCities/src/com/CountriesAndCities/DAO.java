package com.CountriesAndCities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public interface DAO {
    public ArrayList<Country> readAllCountries();
    public Country createCountry(String [] metadata);
    public ArrayList<City> readAllCities();
    public City createCity(String [] metadata);
    public void removeEmptyPopulation();

    public List<City> sortByCityPopulation(List<City> cities_b);



    List<City> sortByCityPopulationByCountryCode(String code);

    public Map<String, List<City>> mapCitiesToCountries();

    public Map<String, Double> getListOfCountriesPopulations();

    public OptionalDouble getAvgCountriesPopulation();

    Country getMaxCounttyPopulation();

    Map<String, List<City>> getHighestCityForCountryPopulation();

    City getHighestPopulationCapital();
}
