package com.CountriesAndCities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CountriesAndCitiesDAO implements DAO {

    ArrayList<Country> countries = new ArrayList<>();
    ArrayList<City> cities = new ArrayList<>();

    @Override
    public ArrayList<Country> readAllCountries() {
        BufferedReader br = null;

        try {
            br = new BufferedReader (new FileReader("/Users/abdelrahmanelghamry/IdeaProjects/CountriesAndCities/Countries.csv")); // read the first line from the text file which will be head column
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = null;
//        try {
//            line = br.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (line != null) {
//
////            System.out.println (line);
//
//        }

        do {

            try {
                line = br.readLine(); // real data
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (line != null) {

                String[] metadata = line.trim().split(",");

                countries.add(createCountry(metadata));
            }

        } while (line != null);

        return countries;    }

    @Override
    public Country createCountry(String[] metadata) {
        return new Country(metadata[0],metadata[1],metadata[2],Double.parseDouble(metadata[3]),Double.parseDouble(metadata[4]),Double.parseDouble(metadata[5]),Integer.parseInt(metadata[6]));
    }

    @Override
    public ArrayList<City> readAllCities() {
        BufferedReader br = null;

        try {
            br = new BufferedReader (new FileReader("/Users/abdelrahmanelghamry/IdeaProjects/CountriesAndCities/Cities.csv")); // read the first line from the text file which will be head column
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = null;
//        try {
//            line = br.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (line != null) {
//
////            System.out.println (line);
//
//        }

        do {

            try {
                line = br.readLine(); // real data
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (line != null) {


                String[] metadata = line.trim().split(",");

                cities.add(createCity(metadata));
            }

        } while (line != null);

        return cities;
    }

    @Override
    public City createCity(String[] metadata) {
        return new City(Integer.parseInt(metadata[0]),metadata[1],Integer.parseInt(metadata[2]),metadata[3].trim());
    }

    @Override
    public void removeEmptyPopulation() {

    }

    @Override
    public List<City> sortByCityPopulation(List<City> cities_b) {
        cities_b.sort(Comparator.comparingInt(City::getPopulation));
        return  cities_b;

    }

    @Override
    public List<City> sortByCityPopulationByCountryCode(String code) {

       return sortByCityPopulation( mapCitiesToCountries().get(code));

    }

    @Override
    public Map<String, List<City>> mapCitiesToCountries()  {
        Map<String, List<City>> mapping_of_cities_countries =  cities.stream().collect(Collectors.groupingBy(City::getCountryCode,
                Collectors.toList()));
        return mapping_of_cities_countries;

    }

    @Override
    public Map<String, Double> getListOfCountriesPopulations() {
        return  countries.stream().collect(Collectors.toMap(Country::getCode, Country::getPopulation));
    }

    @Override
    public OptionalDouble getAvgCountriesPopulation() {
         OptionalDouble average = countries
                .stream()
                .mapToDouble(Country::getPopulation)
                 .average();
        return average;
    }

    @Override
    public Country getMaxCounttyPopulation() {
        Country max = countries
                .stream()
                .max(Comparator.comparingDouble(Country::getPopulation)).orElseThrow(NoSuchElementException::new);

        return max;
    }

@Override
    public Map<String, List<City>> getHighestCityForCountryPopulation() {
       Map<String, List<City>> mapping_of_cities_countries = mapCitiesToCountries();
    Map<String, List<City>> cities_map_with_highest_population = new HashMap<>();

    for (String s : mapping_of_cities_countries.keySet()
         ) {

        int max = mapping_of_cities_countries.get(s).stream()
                .max(Comparator.comparing(City::getPopulation))
                .get()
                .getPopulation();
        Map<String, List<City>> citities_map =    cities.stream().filter(m -> m.getPopulation() == max).collect(Collectors.groupingBy(City::getCountryCode,
                Collectors.toList()));

        Country result1 = countries.stream()                        // Convert to steam
                .filter(x -> ((String) citities_map.keySet().toArray()[0]).equals(x.getCode()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);
        cities_map_with_highest_population.put(result1.getName(),citities_map.get(citities_map.keySet().toArray()[0]));



    }


        return cities_map_with_highest_population;
    }

    @Override
    public City getHighestPopulationCapital() {

        Map<String,Integer> countries_capitals= countries.stream().collect(Collectors.toMap(Country::getCode, Country::getCapital));




        List<City> capitals = cities.stream()
                .filter(c -> countries_capitals.containsValue(c.getId()))

                .collect(Collectors.toList());

        City max = capitals
                .stream()
                .max(Comparator.comparingDouble(City::getPopulation)).orElseThrow(NoSuchElementException::new);
        return max;
    }

}
