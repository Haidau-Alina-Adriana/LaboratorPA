package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO {
    private Connection con;

    public CityDAO() {
        this.con = Database.getConnection();
    }

    public void create(City city) throws SQLException {
        PreparedStatement query = con.prepareStatement("insert into cities(id, " + "country, " + " name, " + " capital, " + " latitude, " + " longitude) VALUES (?, ?, ?, ?, ?, ?)");
        query.setInt(1, city.getId());
        query.setString(2, city.getCountry());
        query.setString(3, city.getName());
        query.setInt(4, city.getCapital());
        query.setDouble(5, city.getLatitude());
        query.setDouble(6, city.getLongitude());
        query.executeUpdate();
    }

    public City findByName(String name) throws SQLException {
        PreparedStatement query = con.prepareStatement("select * from cities where name = ?");
        query.setString(1, name);
        ResultSet resultSet = query.executeQuery();

        City city = new City();
        while (resultSet.next()) {
            city.setId(resultSet.getInt("id"));
            city.setCountry(resultSet.getString("country"));
            city.setName(resultSet.getString("name"));
            city.setCapital(resultSet.getInt("capital"));
            city.setLatitude(resultSet.getDouble("latitude"));
            city.setLongitude(resultSet.getDouble("longitude"));

        }
        return city;
    }

    public City findById(int id) throws SQLException {
        PreparedStatement query = con.prepareStatement("select * from cities where id = ?");
        query.setInt(1, id);
        ResultSet resultSet = query.executeQuery();

        City city = new City();
        while (resultSet.next()) {
            city.setId(resultSet.getInt("id"));
            city.setCountry(resultSet.getString("country"));
            city.setName(resultSet.getString("name"));
            city.setCapital(resultSet.getInt("capital"));
            city.setLatitude(resultSet.getDouble("latitude"));
            city.setLongitude(resultSet.getDouble("longitude"));
        }
        return city;
    }
}
