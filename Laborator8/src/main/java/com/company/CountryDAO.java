package com.company;

import java.sql.*;

public class CountryDAO {
    private Connection con;

    public CountryDAO() {
        this.con = Database.getConnection();
    }

    public void create(Country country) throws SQLException {
        PreparedStatement query = con.prepareStatement("insert into countries(id, " + "name, " + " code, " + " continent) VALUES (?, ?, ?, ?)");
        query.setInt(1, country.getId());
        query.setString(2, country.getName());
        query.setInt(3, country.getCode());
        query.setString(4, country.getContinent());
        query.executeUpdate();
    }

    public Country findByName(String name) throws SQLException {
        PreparedStatement query = con.prepareStatement("select * from countries where name = ?");
        query.setString(1, name);
        ResultSet resultSet = query.executeQuery();

        Country country = new Country();
        while (resultSet.next()) {
            country.setId(resultSet.getInt("id"));
            country.setName(resultSet.getString("name"));
            country.setCode(resultSet.getInt("code"));
            country.setContinent(resultSet.getString("continent"));
        }
        return country;
    }

    public Country findById(int id) throws SQLException {
        PreparedStatement query = con.prepareStatement("select * from countries where id = ?");
        query.setInt(1, id);
        ResultSet resultSet = query.executeQuery();

        Country country = new Country();
        while (resultSet.next()) {
            country.setId(resultSet.getInt("id"));
            country.setName(resultSet.getString("name"));
            country.setCode(resultSet.getInt("code"));
            country.setContinent(resultSet.getString("continent"));
        }
        return country;
    }
}
