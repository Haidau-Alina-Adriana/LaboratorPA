package com.company;

import jpa.entity.CitiesEntity;
import jpa.entity.ContinentsEntity;
import jpa.entity.CountriesEntity;
import jpa.repository.CitiesRepository;
import jpa.repository.ContinentsRepository;
import jpa.repository.CountriesRepository;
import jpa.utils.EntityManagerResponsible;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        PreparedStatement query1 = Database.getConnection().prepareStatement("DROP TABLE continents");
        PreparedStatement query2 = Database.getConnection().prepareStatement("DROP TABLE countries");
        PreparedStatement query3 = Database.getConnection().prepareStatement("DROP TABLE cities");

        PreparedStatement query4 = Database.getConnection().prepareStatement("CREATE TABLE countries (\n" +
                "    id number NOT NULL PRIMARY KEY," +
                "    name varchar(50) NOT NULL," +
                "    code number," +
                "    continent varchar(50)" +
                ")");
        PreparedStatement query5 = Database.getConnection().prepareStatement("CREATE TABLE continents (\n" +
                "    id number NOT NULL PRIMARY KEY," +
                "    name varchar(50) NOT NULL" +
                ")");
        PreparedStatement query6 = Database.getConnection().prepareStatement("CREATE TABLE cities (\n" +
                "    id number NOT NULL PRIMARY KEY," +
                "    country varchar(50)," +
                "    name varchar(50) NOT NULL," +
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


        ContinentsRepository continentRepository = new ContinentsRepository();
        CountriesRepository countryRepository = new CountriesRepository();
        CitiesRepository cityRepository = new CitiesRepository();

        ContinentsEntity continent = new ContinentsEntity();
        continent.setId(1L);
        continent.setName("Europe");
        continentRepository.create(continent);

        ContinentsEntity findContinent = ContinentsRepository.findById(1);
        System.out.println(findContinent.toString());

        CountriesEntity country = new CountriesEntity();
        country.setId(1L);
        country.setName("Romania");
        country.setCode(continent.getId());
        country.setContinent(continent.getName());
        countryRepository.create(country);

        List<CountriesEntity> findCountry = CountriesRepository.findByName("Romania");
        System.out.println(findCountry.toString());

        CitiesEntity city1 = new CitiesEntity();
        city1.setId(1L);
        city1.setCountry(country.getName());
        city1.setName("Bucuresti");
        city1.setLatitude(44.43278);
        city1.setLongitude(26.10389);
        cityRepository.create(city1);

        CitiesEntity city2 = new CitiesEntity();
        city2.setId(2L);
        city2.setCountry(country.getName());
        city2.setName("Iasi");
        city2.setLatitude(47.1622);
        city2.setLongitude(27.5889);
        cityRepository.create(city2);

        CitiesEntity city3 = new CitiesEntity();
        city3.setId(3L);
        city3.setCountry(country.getName());
        city3.setName("Cluj");
        city3.setLatitude(46.7667);
        city3.setLongitude(23.6);
        cityRepository.create(city3);

        CitiesEntity findCity = CitiesRepository.findById(2);
        System.out.println(findCity.toString());

        entityManager.close();
        entityManagerFactory.close();
        Database.closeConnection();

    }
}
