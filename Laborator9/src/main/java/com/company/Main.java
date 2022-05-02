package com.company;

import jpa.entity.CitiesEntity;
import jpa.entity.ContinentsEntity;
import jpa.entity.CountriesEntity;
import jpa.repository.CityRepository;
import jpa.repository.ContinentRepository;
import jpa.repository.CountryRepository;
import jpa.utils.EntityManagerResponsible;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

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



        EntityManagerFactory entityManagerFactory = EntityManagerResponsible.getInstance();
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        ContinentRepository continentRepository = new ContinentRepository();
        CountryRepository countryRepository = new CountryRepository();
        CityRepository cityRepository = new CityRepository();

        ContinentsEntity continent = new ContinentsEntity();
        continent.setId(1L);
        continent.setName("Europe");
        continentRepository.create(continent);

        CountriesEntity country = new CountriesEntity();
        country.setId(1L);
        country.setName("Romania");
        country.setCode(continent.getId());
        country.setContinent(continent.getName());
        countryRepository.create(country);

        CitiesEntity city = new CitiesEntity();
        city.setId(1L);
        city.setCountry(country.getName());
        city.setName("Bucuresti");
        city.setLatitude(44.43278);
        city.setLongitude(26.10389);
        cityRepository.create(city);


        entityManager.close();
        entityManagerFactory.close();
        Database.closeConnection();

    }
}
