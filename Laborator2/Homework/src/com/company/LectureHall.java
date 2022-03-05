package com.company;

public class LectureHall extends Room {

    private String operatingSystem;

    /**
     * Constructor mostenit cu toti parametrii
     *
     * @param name            numele salii
     * @param type            tipul salii
     * @param capacity        capacitatea salii
     * @param operatingSystem tipul sistemului de operare al calculatoarelor din sala
     */
    public LectureHall(String name, String type, int capacity, String operatingSystem) {
        super(name, type, capacity);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    void setType(String type) {
        this.type = type;
    }
}
