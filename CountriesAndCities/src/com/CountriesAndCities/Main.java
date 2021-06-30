package com.CountriesAndCities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DAO DAO = new CountriesAndCitiesDAO();

        ArrayList<Country> countries = DAO.readAllCountries();
        ArrayList<City> cities = DAO.readAllCities();

        DAO.mapCitiesToCountries();




System.out.println("Sort by Population given Country Code : ");

        System.out.println(DAO.sortByCityPopulationByCountryCode("CUB"));
        System.out.println("List of Countries Population :  ");

        System.out.println(DAO.getListOfCountriesPopulations());
        System.out.println("Average of Countries Population :  ");
        System.out.println(DAO.getAvgCountriesPopulation().getAsDouble());
        System.out.println("Max Country Population :  ");
        System.out.println(DAO.getMaxCounttyPopulation());
        System.out.println("Highest City of Country Population :  ");
        System.out.println(DAO.getHighestCityForCountryPopulation());
        System.out.println("Highest Capital in Population :  ");
        System.out.println(DAO.getHighestPopulationCapital());







//        System.out.println(countries);
    }
}
