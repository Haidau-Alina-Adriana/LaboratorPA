package com.company;

import java.sql.*;

public class ContinentDAO {
    private Connection con;

    public ContinentDAO() {
        this.con = Database.getConnection();
    }

    public void create(Continent continent) throws SQLException {
        PreparedStatement query = con.prepareStatement("insert into continents(id, " + "name ) VALUES (?, ?)");
        query.setInt(1, continent.getId());
        query.setString(2, continent.getName());
        query.executeUpdate();
    }

    public Continent findByName(String name) throws SQLException {
        PreparedStatement query = con.prepareStatement("select * from continents where name = ?");
        query.setString(1, name);
        ResultSet resultSet = query.executeQuery();

        Continent continent = new Continent();
        while (resultSet.next()) {
            continent.setId(resultSet.getInt("id"));
            continent.setName(resultSet.getString("name"));
        }
        return continent;
    }

    public Continent findById(int id) throws SQLException {
        PreparedStatement query = con.prepareStatement("select * from continents where id = ?");
        query.setInt(1, id);
        ResultSet resultSet = query.executeQuery();

        Continent continent = new Continent();
        while (resultSet.next()) {
            continent.setId(resultSet.getInt("id"));
            continent.setName(resultSet.getString("name"));
        }
        return continent;
    }
}
