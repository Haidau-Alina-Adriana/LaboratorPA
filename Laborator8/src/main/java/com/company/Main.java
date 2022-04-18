package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Database.getConnection().commit();
        try {
            var continents = new ContinentDAO();
            continents.create(new Continent("Europe"));
            continents.create(new Continent("America"));
            continents.create(new Continent("Africa"));

            Continent europe = continents.findByName("Europe");
            Continent africa = continents.findByName("Africa");
            Continent america = continents.findById(2);

            var countries = new CountryDAO();

            countries.create(new Country("Romania", europe.getId(), europe.getName()));
            countries.create(new Country("Austria", europe.getId(), europe.getName()));
            countries.create(new Country("Congo", africa.getId(), africa.getName()));
            countries.create(new Country("Canada", america.getId(), america.getName()));

            Database.getConnection().commit();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            Database.getConnection().close();
        }

    }
}
