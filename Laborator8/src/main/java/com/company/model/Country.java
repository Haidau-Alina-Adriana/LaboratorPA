package com.company.model;

public class Country {
    private static int index = 1;
    private int id;
    private String name;
    private int code;
    private String continent;

    public Country() {
    }

    public Country(String name, int code, String continent) {
        this.id = index;
        this.name = name;
        this.code = code;
        this.continent = continent;
        index++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", continent=" + continent +
                '}';
    }
}
