package com.company;

import com.company.DAO.CityDAO;
import com.company.DAO.ContinentDAO;
import com.company.DAO.CountryDAO;
import com.company.model.City;
import com.company.model.Continent;
import com.company.model.Country;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static double distance(City city1, City city2) {

        double lat1 = city1.getLatitude();
        double lat2 = city2.getLatitude();
        double lon1 = city1.getLongitude();
        double lon2 = city2.getLongitude();

        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;

        return (c * r);
    }

    public static void main(String[] args) throws SQLException {
        try {

            PreparedStatement query1 = Database.getConnection().prepareStatement("DROP TABLE continents");
            PreparedStatement query2 = Database.getConnection().prepareStatement("DROP TABLE countries");
            PreparedStatement query3 = Database.getConnection().prepareStatement("DROP TABLE cities");

            PreparedStatement query4 = Database.getConnection().prepareStatement("CREATE TABLE countries (\n" +
                    "    id number," +
                    "    name varchar(50)," +
                    "    code number," +
                    "    continent varchar(50)" +
                    ")");
            PreparedStatement query5 = Database.getConnection().prepareStatement("CREATE TABLE continents (\n" +
                    "    id number," +
                    "    name varchar(50)" +
                    ")");
            PreparedStatement query6 = Database.getConnection().prepareStatement("CREATE TABLE cities (\n" +
                    "    id number," +
                    "    country varchar(50)," +
                    "    name varchar(50)," +
                    "    capital number(1)," +
                    "    latitude float," +
                    "    longitude float" +
                    ")");

            query1.executeUpdate();
            query2.executeUpdate();
            query3.executeUpdate();
            query4.executeUpdate();
            query5.executeUpdate();
            query6.executeUpdate();

            Database.getConnection().commit();

            var continents = new ContinentDAO();
//            continents.create(new Continent("Europe"));
//            continents.create(new Continent("America"));
//            continents.create(new Continent("Africa"));
//
//            Continent europe = continents.findByName("Europe");
//            Continent africa = continents.findByName("Africa");
//            Continent america = continents.findById(2);
//
            var countries = new CountryDAO();
//
//            countries.create(new Country("Romania", europe.getId(), europe.getName()));
//            countries.create(new Country("Austria", europe.getId(), europe.getName()));
//            countries.create(new Country("Congo", africa.getId(), africa.getName()));
//            countries.create(new Country("Canada", america.getId(), america.getName()));
//
//            Country romania = countries.findByName("Romania");
//
            var cities = new CityDAO();
//
//            cities.create(new City(romania.getName(), "Bucuresti", 1, 44.43278, 26.10389));
//            cities.create(new City(romania.getName(), "Iasi", 0, 47.1622, 27.5889));
//

            Set<String> continents1 = new HashSet<>();
            Set<String> countries1 = new HashSet<>();
            Set<String> cities1 = new HashSet<>();

            try (CSVReader csvReader = new CSVReader(new FileReader("concap.csv"))) {
                String[] values = csvReader.readNext();
                while ((values = csvReader.readNext()) != null) {
                    if (!continents1.contains(values[5])) {
                        continents1.add(values[5]);
                        continents.create(new Continent(values[5]));
                    }
                    if (!countries1.contains(values[0])) {
                        countries1.add(values[0]);
                        countries.create(new Country(values[0], -1, values[5]));
                    }
                    if (!cities1.contains(values[1])) {
                        cities1.add(values[1]);
                        cities.create(new City(values[0], values[1], 1, Double.parseDouble(values[2]), Double.parseDouble(values[3])));
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }

            System.out.println("Distance from Vienna to Sofia: " + distance(cities.findByName("Vienna"), cities.findByName("Sofia")) + " K.M");

            Database.getConnection().commit();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            Database.getConnection().close();
        }

    }
}
