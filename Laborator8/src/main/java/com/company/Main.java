package com.company;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {

            PreparedStatement query1 = Database.getConnection().prepareStatement("DROP TABLE continents");
            PreparedStatement query2 = Database.getConnection().prepareStatement("DROP TABLE countries");
            PreparedStatement query3 = Database.getConnection().prepareStatement("CREATE TABLE countries (\n" +
                    "    id number," +
                    "    name varchar(50)," +
                    "    code number," +
                    "    continent varchar(50)" +
                    ")");
            PreparedStatement query4 = Database.getConnection().prepareStatement("CREATE TABLE continents (\n" +
                    "    id number," +
                    "    name varchar(50)" +
                    ")");

            query1.executeUpdate();
            query2.executeUpdate();
            query3.executeUpdate();
            query4.executeUpdate();

            Database.getConnection().commit();

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
